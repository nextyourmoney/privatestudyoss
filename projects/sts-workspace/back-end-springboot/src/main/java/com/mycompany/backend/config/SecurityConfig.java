package com.mycompany.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mycompany.backend.security.JwtAuthenticationFilter;

import lombok.extern.log4j.Log4j2;

@EnableWebSecurity // 기본적으로 configuration이 포함되어 있기에 compiguration을선언하지 않아도 bean 생성가능
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("실행");

		// 서버 세션 비활성황
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// 폼 로그인 비활성화
		http.formLogin().disable();
		// 사이트간 요청 위조 방지
		http.csrf().disable();
		// 요청 경로 권한 설정
		http.authorizeRequests().antMatchers("/board/**").authenticated() // 인증된 사용자만 접근(로그인)
				.antMatchers("/**").permitAll(); // 그외의 경로는 로그인 없이도 접근 가능

		// CORS설정(다른 도메인의 javascript로 접근을 할 수 있도록 허용) ----- REST는 반드시 설정 할 것
		http.cors();
		//JWT 인증 필터 추가 //인증과 관련된 필터는 지정된 위치에 추가하여야 한다. //폼인증이 선언되기 전에 필터를 선언해야 한다. 
		http.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("실행");

		// mpa 폼인증 방식에서 사용(jwt 인증 방식에서는 사용하지않는다. )
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(new CustomUserDetailService()); //db에서 멤버에 대한 정보를 가져온다. 
//		provider.setPasswordEncoder(passwordEncoder()); //비밀번호 암호화 
//		auth.authenticationProvider(provider);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		log.info("실행");
		//
		DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
		defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchyImpl()); // 권한 계층 설정(roleHierarchyImpl)
																				   // admin>manager>user
		web.expressionHandler(defaultWebSecurityExpressionHandler);

		// MPA에서 시큐리티를 적용하지 않는 경로 설정
		/* web.ignoring() //security를 무시하는 경로이다. (permitall과는 다르게 security가 완전히 동작하지 않는다. )
		.antMatchers("/images/**")
		.antMatchers("/css/**")
		.antMatchers("/js/**")
		.antMatchers("/bootstrap/**")
		.antMatchers("/jquery/**")
		.antMatchers("/favicon.ico"); */
	}

	@Bean // 관리 객체 생성 //패스워드 암호
	public PasswordEncoder passwordEncoder() {

		return PasswordEncoderFactories.createDelegatingPasswordEncoder(); // 어떤 암호인지 함께
		// return new BCryptPasswordEncoder(); //암호화 없이 암화된 것만 나

	}

	@Bean // 권한 우선순위 설정
	public RoleHierarchyImpl roleHierarchyImpl() {
		log.info("실행");
		RoleHierarchyImpl roleHierarchyImpl = new RoleHierarchyImpl();
		roleHierarchyImpl.setHierarchy("ROLE_ADMIN > ROLE_MANAGER > ROLE_USER");
		return roleHierarchyImpl;
	}

	@Bean //mpa방식에서는 없어도 되는 조건이고 rest api에서만 사용한다. 
	public CorsConfigurationSource corsConfigurationSource() {
		log.info("실행");
		CorsConfiguration configuration = new CorsConfiguration();
		// 모든 요청 사이트 허용
		configuration.addAllowedOrigin("*"); //모든 도메인의 자바 스크립트 접근을 허용
		// 모든 요청 방식 허용
		configuration.addAllowedMethod("*"); //get, post, put, delete방식 중 허용
		// 모든 요청 헤더 허용
		configuration.addAllowedHeader("*");
		// 모든 URL 요청에 대해서 위 내용을 적용
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
