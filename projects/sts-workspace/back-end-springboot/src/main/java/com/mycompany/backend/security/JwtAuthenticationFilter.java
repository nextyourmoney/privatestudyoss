package com.mycompany.backend.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
				log.info("실행");
				
				//요청 헤더로부터 authorizaation 헤더 값 얻기
				String authorization  = request.getHeader("Authorization");
				
				//accesstoken추출
				String accessToken = Jwt.getAccessToken(authorization);
				log.info(accessToken);
				
				//검증 작업
				if(accessToken != null && Jwt.validateToken(accessToken)) {
					//인증 처리
					Map<String, String> userInfo = Jwt.getUserInfo(accessToken); //accesstoken에서는 mid와 authority를 payloaddp 추가했었다.
					String mid = userInfo.get("mid");
					String authority = userInfo.get("authority");
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(mid, null, 
							AuthorityUtils.createAuthorityList(authority));
					SecurityContext securityContext = SecurityContextHolder.getContext();
					securityContext.setAuthentication(authentication);
				}
				
				
				//jwt가 유효하다면 해당 필터에서 로그인 성공 처리르 해주어야 한다. 
				filterChain.doFilter(request, response); //다음 필터를 선언해준다. 마지막 필터라면 없어도 상관은 없다. 
		
	}
	
}
