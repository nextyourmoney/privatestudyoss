package com.mycompany.backend.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpHeaders;
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
	//빈의 이름을 이용해서 주입할 객체를 검색한다
	@Resource 
	private MemberService memberService;
	
	@Resource PasswordEncoder passwordEncoder;
	
	//redis 주입 설정
	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@PostMapping("/join") //회원가입
	public Map<String, Object> join(@RequestBody Member member){ //RequestBody는 JSON Data가 들어가야 한다. 
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "success");
//		map.put("member", member);
		
		//계정 활성황
		member.setMenabled(true); 
		//패스워드 암호화
		member.setMpassword(passwordEncoder.encode(member.getMpassword())); //dto객체로 입력 받은 데이터들 중에서 패스워드를 암호화 한다.  requestbody이므로 json data입
		//회원가입 처리
		JoinResult joinResult = memberService.join(member);
		//응답 생성
		Map<String, Object> map = new HashMap<>(); //결과값 저장되는 리스트 생성 
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
					.status(401) //클라이언트 인증 오류 발생 //강제로 설정된 오류를 발생시켜 body의 문장을 출력한다. 
					.body("mid or mpassword cannot be null");
		}
		
		//로그인 결과 얻기
		LoginResult loginResult = memberService.login(member);
		
		if(loginResult != LoginResult.SUCCESS) {
			return ResponseEntity
					.status(401) //클라이언트 인증 류 발생
					.body("mid or mpassword is wrong");
		}
		
		Member dbMember = memberService.getMember(member.getMid()); //선택 아이디의 member data를 가진다. 
		String accessToken = Jwt.createAccessToken(member.getMid(), dbMember.getMrole()); //보안 토큰 생성 //jwt의 아이디와 권한을 기반으로 인증 토큰을 생성한다. 
		String refreshToken = Jwt.createRefreshToken(member.getMid(), dbMember.getMrole()); //인증 토큰이 만료 되었을 떄 활용되는 refreshtoken을 생성한다. 마찬가지로 동일 충골이다.
		
		log.info("여기인듯");
		//redis에 저장
		ValueOperations<String, String> vo = redisTemplate.opsForValue(); //Redis의 Strings 자료구조는 opsForValue 메서드를 사용합니다
 		vo.set(accessToken, refreshToken, Jwt.REFRESH_TOKEN_DURATION, TimeUnit.MILLISECONDS);//access를 키, refresh를 값, 만료기간(리플레시 만료기관과 동일) 선언 
		
 		//쿠키 생성 //토큰값 저장됨
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
	
	@GetMapping("/refreshToken") //리플레시 토큰	//리플레시 토큰은 마지막에 접속 실패한 access토큰이 들어와야 한다. /
	public ResponseEntity<String> refreshToken( //response entity는 http요청 또는 응답에 해당하는 헤더와 바디를 포함하고 있다. 그리고 requestentity, responseetity는상속받아 구현한 클래스이다.
												//특히 responseEntity는 httpRequest에 대한 응답 데이터를 포함하는 클래스이다. (httpstatus, headers, body)를 폼함.
			@RequestHeader("Authorization") String authorization, //입력되는권한은 헤더에 authorization을 키로 두고 저장,refresh는 쿠키에 refresh를 키로 두고 저장한다.
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
		
		//동일한 토큰인지 확인
		ValueOperations<String, String> vo = redisTemplate.opsForValue(); //레디스의 값 변수
		String redisRefreshToken = vo.get(accessToken); //레디스 값 중에서 accesstoken을 찾고 이는 refresfh로 설정
		if(redisRefreshToken == null) {
			//access 토큰이 잘못됐다. 
			return ResponseEntity.status(401).body("invalidate access token");
			
		} 
		
		if(!refreshToken.equals(redisRefreshToken)) {
			return ResponseEntity.status(401).body("invalidate refresh token");
		}
		
//		if(Jwt.validateToken(redisRefreshToken)) {
//			return ResponseEntity.status(401).body("invalidate refresh token");
//		}

		//새로운 accestoken 생성
		Map<String, String> userInfo = Jwt.getUserInfo(refreshToken); //refreshtoken에서 값을 가져온다. refresh는 access와 함꼐 생성된다. 그렇기에 동일한 유저 정보를 가지고 있다. 
		String mid = userInfo.get("mid");
		String authority = userInfo.get("authority");
		String newAccessToken = Jwt.createAccessToken(mid, authority); //refreshtoken에 저장되어있던 값들을 기반으로 access 토큰을 다시 생성한다. 
		
		//redis에 저장된 기본 정보를 삭제
		redisTemplate.delete(accessToken); //기존 정보를 삭제해야 안전하고 완전하다
		
		//redis의  새로운 정보를 저장
//		vo.set(accessToken, refreshToken, Jwt.REFRESH_TOKEN_DURATION, TimeUnit.MILLISECONDS); //이건 풀타임 저장이다. 
		Date expiration = Jwt.getExpiration(refreshToken);
		vo.set(newAccessToken, refreshToken, expiration.getTime() - new Date().getTime(), TimeUnit.MILLISECONDS); //각각 토큰과 남은 토큰 시간이다. 
		
		//응답 설정
		String json = new JSONObject().put("accessToken", newAccessToken).put("mid", mid).toString();
		
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_TYPE, "application/json")
				//.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON) 두개의 헤더는 같다. 
				.body(json);
	}

	
	@GetMapping("/logout")
	public ResponseEntity<String> logout(@RequestHeader("Authorization") String authorization){ //주소 헤더의 authorizatio을 authorization으로 받아온다. 
		//Access token 얻기
		String accessToken = Jwt.getAccessToken(authorization);
		if(accessToken == null) {
			return ResponseEntity.status(401).body("invalid access token");
		}
		
		//redis에 저장된 인증 정보를 삭제
		redisTemplate.delete(accessToken);
		
		//refreshtoken 쿠키 삭제
		String refreshTokenCookie = ResponseCookie.from("refreshToken", "")
				.httpOnly(true) //클라이언트에서 자바스크립트로 접근못하게 막는다. 
				.secure(false)
				.path("/")
				.maxAge(0) //수명을 없앰으로써 쿠키의 삭제 효과를 만들어낸다. 
				.domain("localhost")
				.build()
				.toString();
		
		//응답 설정
		return ResponseEntity
				.ok()
				.header(HttpHeaders.SET_COOKIE, refreshTokenCookie) //logout에서 쿠키가 삭제 효과를 가지기 때문에 삭제된다. 
				.body("success");
		
	
	}
}
	
	


