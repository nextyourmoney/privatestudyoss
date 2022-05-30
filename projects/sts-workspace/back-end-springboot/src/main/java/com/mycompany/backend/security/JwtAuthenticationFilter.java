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
				String authorization  = request.getHeader("Authorization"); //생성된 accesstoken은 header에 저장되고 해당 코드는 헤더에서 권한을가져온다. 
				
				//accesstoken추출
				String accessToken = Jwt.getAccessToken(authorization); //jwt에서 선언된 토큰의 값을 가져오는 함수를 사용하여 토큰값들을 그대로 가져온다. 
				log.info(accessToken);
				
				//검증 작업
				if(accessToken != null && Jwt.validateToken(accessToken)) { //유효한 로그인 입력들인지 검증한다. 
					//인증 처리
					Map<String, String> userInfo = Jwt.getUserInfo(accessToken); //accesstoken에서는 mid와 authority를 payloaddp 추가했었다. //해당 코드를 통해 코드의 값들을 key, value로 가져온다. 
					String mid = userInfo.get("mid"); //선언된 토큰에서 값들을 가져온다. 
					String authority = userInfo.get("authority");
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(mid, null, 
							AuthorityUtils.createAuthorityList(authority)); //매개변수들은 각각 아이디, 패스워드, 인증관련 여부이다. 해당 코드를 통해인증만 할 것인지, 권한을 확인할 것인지 확일 할 수 있다.
																			//이때 패스워드를 넣지 않는 것은 이미 if를 통해서 인증여부를 확인했기 떄문이다. 
					SecurityContext securityContext = SecurityContextHolder.getContext(); //filter에서 인증된 정보가 모두 저장된다.
					securityContext.setAuthentication(authentication); //처리된 인증 정보를 필터 정보가 인증된 곳중에서도 저장된다. 
				}
				
				
				//jwt가 유효하다면 해당 필터에서 로그인 성공 처리르 해주어야 한다. 
				filterChain.doFilter(request, response); //다음 필터를 선언해준다. 마지막 필터라면 없어도 상관은 없다. 
		
	}
	
}
