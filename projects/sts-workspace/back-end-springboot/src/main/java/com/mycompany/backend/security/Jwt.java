package com.mycompany.backend.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Jwt {
	//상수
	private static final String JWT_SECRET_KEY = "kosa12345"; //반드시 암호화 하여서 보유 할 
	//private static final long ACCESS_TOKEN_DURATION = 1000 * 60 * 30; //30분
	private static final long ACCESS_TOKEN_DURATION = 30000; //30초
	public static final long REFRESH_TOKEN_DURATION = 1000 * 60 * 60 * 24; //하루
	
	//AccessToken 생성 //권한에 대한 정보
	public static String createAccessToken(String mid, String authority) {
		log.info("실행");
		String accessToken = null;
		
		try {
			accessToken = Jwts.builder()
					//head 설
					.setHeaderParam("alg", "HS256")
					.setHeaderParam("type", "JWT")
					//페이로드 설정
					.setExpiration(new Date(new Date().getTime() + ACCESS_TOKEN_DURATION)) //유효기간은 30분
					.claim("mid", mid)
					.claim("authority", authority)
					//서명(시그니처)
					.signWith(SignatureAlgorithm.HS256, JWT_SECRET_KEY.getBytes("UTF-8"))
					.compact();
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return accessToken;
		
	}
	
	//refreshToken 생성 
	public static String createRefreshToken(String mid, String authority) {
		log.info("실행");
		String refreshToken = null;
		
		try {
			refreshToken = Jwts.builder()
					//head 설
					.setHeaderParam("alg", "HS256")
					.setHeaderParam("type", "JWT")
					//페이로드 설정
					.setExpiration(new Date(new Date().getTime() + REFRESH_TOKEN_DURATION)) //유효기간은 30분
					.claim("mid", mid)
					.claim("authority", authority)
					//서명(시그니처)
					.signWith(SignatureAlgorithm.HS256, JWT_SECRET_KEY.getBytes("UTF-8"))
					.compact();
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return refreshToken;
		
	}
	
	//토큰 유효성 검사
	public static boolean validateToken(String token) {
		log.info("실행");
		boolean result = false;
		
		//해석
		try {
			result = Jwts.parser()
					.setSigningKey(JWT_SECRET_KEY.getBytes("UTF-8"))
					.parseClaimsJws(token)
					.getBody()
					.getExpiration()
					.after(new Date());
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		
		return result;
	}
	
	//토큰 만료 시간 얻기
	public static Date getExpiration(String token) {
		log.info("실행");
		Date result = null;
		
		//해석
		try {
			result = Jwts.parser()
					.setSigningKey(JWT_SECRET_KEY.getBytes("UTF-8"))
					.parseClaimsJws(token)
					.getBody()
					.getExpiration();	
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		
		return result;
	}
	
	//인증 사용자정보 얻기
	public static Map<String, String> getUserInfo(String token){
		log.info("실행");
		Map<String, String> result = new HashMap<>();
		
		//해석
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(JWT_SECRET_KEY.getBytes("UTF-8"))
					.parseClaimsJws(token)
					.getBody();
			result.put("mid",claims.get("mid",String.class));
			result.put("authority", claims.get("authority", String.class));
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		
		return result;
	}
	
	//요청authorization 헤더값에서 accesstoken 얻
	//Bearer xxxxxxxx.xxxxxxxxx.xxxxxx의 형태로 토큰이 나오는데 여기서 xxx부분을 구한다. 
	public static String getAccessToken(String authorization) {
		String accessToken = null;
		if(authorization != null && authorization.startsWith("Bearer ")) {
			accessToken = authorization.substring(7);
			
		}
		
		return accessToken;
		
	}
	
	public static void main(String[] args) throws Exception {
		String accessToken = createAccessToken("user", "ROLE_USER");
		//Thread.sleep(2000);
		System.out.println(validateToken(accessToken));
		Date expiration = getExpiration(accessToken);
		System.out.println(expiration);
		
		Map<String, String> userInfo = getUserInfo(accessToken);
		System.out.println(userInfo);
		
		//log.info(accessToken);
	}
}








