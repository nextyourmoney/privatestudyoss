package com.mycompany.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.backend.dto.Member;
import com.mycompany.backend.security.Jwt;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/member") //공통 경로

public class MemberController {
	@PostMapping("/join") //회원가입
	public Map<String, Object> join(@RequestBody Member member){ //RequestBody는 JSON Data가 들어가야 한다. 
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("member", member);
		return map;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Member member){
		String accessToken = Jwt.createAccessToken(member.getMid(), "ROLE_USER"); //보안 토큰 생성
		String refreshToken = Jwt.createRefreshToken(member.getMid(), "ROLE_USER"); //토큰 재활성?
		
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
	
	
	

}
