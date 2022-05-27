package com.mycompany.backend.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
				log.info("실행");
				
				//jwt가 유효하다면 해당 필터에서 로그인 성공 처리르 해주어야 한다. 
				filterChain.doFilter(request, response); //다음 필터를 선언해준다. 마지막 필터라면 없어도 상관은 없다. 
		
	}
	
}
