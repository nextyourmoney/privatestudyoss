package com.mycompany.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mycompany.backend.security.CustomUserDetailService;

import lombok.extern.log4j.Log4j2;


@EnableWebSecurity //기본적으로 configuration이 포함되어 있기에 compiguration을선언하지 않아도 bean 생성가능
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter   {
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		log.info("tlfgod");
		
		//서버 세션 비활성황
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//폼 로그인 비활성화
		http.formLogin().disable();
		//사이트간 요청 위조 방지
		http.csrf().disable();
		//요청 경로 권한 설정
		http.authorizeRequests()
			.antMatchers("/board/**").authenticated() //인증된 사용자만 접근(로그인)
			.antMatchers("/**").permitAll(); //그외의 경로는 로그인 없이도 접근 가능
		
		//CORS설정(다른 도메인의 javascript로 접근을 할 수 있도록 허용)  ----- REST는 반드시 설정 할 것
		http.cors();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		log.info("tlfgod");
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(new CustomUserDetailService()); //db에서 멤버에 대한 정보를 가져온다. 
		provider.setPasswordEncoder(passwordEncoder()); //비밀번호 암호화 
		auth.authenticationProvider(provider);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		log.info("tlfgod");
	}
	
	@Bean //관리 객체 생성 //패스워드 암호
	public PasswordEncoder passwordEncoder() {
		
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder(); //어떤 암호인지 함께 
		return new BCryptPasswordEncoder(); //암호화 없이 암화된 것만 나
		
	}
	
	

}
