package com.mycompany.backend.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.backend.dto.Member;
import com.mycompany.backend.security.Jwt;
import com.mycompany.backend.service.MemberService;
import com.mycompany.backend.service.MemberService.JoinResult;
import com.mycompany.backend.service.MemberService.LoginResult;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/member") //공통 경로

public class MemberController {
	
	@Resource 
	private MemberService memberService;
	
	@Resource PasswordEncoder passwordEncoder;
	
	@PostMapping("/join") //회원가입
	public Map<String, Object> join(@RequestBody Member member){ //RequestBody는 JSON Data가 들어가야 한다. 
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "success");
//		map.put("member", member);
		
		//계정 활성황
		member.setMenabled(true);
		//패스워드 암호화
		member.setMpassword(passwordEncoder.encode(member.getMpassword()));
		//회원가입 처리
		JoinResult joinResult = memberService.join(member);
		//응답 생성
		Map<String, Object> map = new HashMap<>();
		if(joinResult == JoinResult.SUCCESS) {
			map.put("result", "success");
		} else if(joinResult == JoinResult.DUPLICATED) {
			map.put("result", "duplicated");
		} else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Member member){
		log.info("실행");
		
		//로그인 인증 
		//mid와 mpassword가 없을 경우
		if(member.getMid() == null || member.getMpassword() == null) { //에러 밑 인증 과정 처리
			return ResponseEntity
					.status(401) //클라이언트 인증 오류 발생
					.body("mid or mpassword cannot be null");
		}
		
		//로그인 결과 얻기
		LoginResult loginResult = memberService.login(member);
		
		if(loginResult != LoginResult.SUCCESS) {
			return ResponseEntity
					.status(401) //클라이언트 인증 류 발생
					.body("mid or mpassword is wrong");
		}
		
		Member dbMember = memberService.getMember(member.getMid());
		String accessToken = Jwt.createAccessToken(member.getMid(), dbMember.getMrole()); //보안 토큰 생성
		String refreshToken = Jwt.createRefreshToken(member.getMid(), dbMember.getMrole()); //토큰 재활성?
		
		//쿠키 생성
		String refreshTokenCookie = ResponseCookie.from("refreshToken", refreshToken)
			.httpOnly(true) //클라이언트에서 자바스크립트로 접근못하게 막는다. 
			.secure(false)
			.path("/")
			.maxAge(Jwt.REFRESH_TOKEN_DURATION/1000)
			.domain("localhost")
			.build()
			.toString();
	
		//본문 생성
		String json = new JSONObject()
				.put("accessToken", accessToken)
				.put("mid", member.getMid())
				.toString();
		
		//응답 설정
		return ResponseEntity
				.ok() //응답 상태 코드: 200
				.header(HttpHeaders.SET_COOKIE, refreshTokenCookie)
				.header(HttpHeaders.CONTENT_TYPE, "application/json")
				.body(json);
	}
	
	@GetMapping("/refreshToken") //리플레시 토큰	//리플레시 토큰은 마지막에 접속 실패한 access토큰이 들어와야 한다. 
	public ResponseEntity<String> refreshToken(
			@RequestHeader("Authorization") String authorization,
			@CookieValue("refreshToken") String refreshToken
		){
		//access token 얻기
		String accessToken = Jwt.getAccessToken(authorization);
		if(accessToken == null) {
			return ResponseEntity.status(401).body("no access token");
		}
		
		//refreshToken 여부
		if(refreshToken == null) {
			return ResponseEntity.status(401).body("no refresh Token");
		}

		//새로운 accestoken 생성
		Map<String, String> userInfo = Jwt.getUserInfo(refreshToken); //refreshtoken에서 값을 가져온다. refresh는 동시에 생성되었었다. 
		String mid = userInfo.get("mid");
		String authority = userInfo.get("authority");
		String newAccessToken = Jwt.createAccessToken(mid, authority);
		
		//응답 설정
		String json = new JSONObject().put("accessToken", newAccessToken).put("mid", mid).toString();
		
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_TYPE, "application/json")
				//.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON) 두개의 헤더는 같다. 
				.body(json);
	}
}
	
	
	


