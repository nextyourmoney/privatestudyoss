package com.mycompany.myapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.mycompany.myapp.controller.dto.Ch04Member;
import com.mycompany.myapp.controller.dto.ch04Dto;
import com.mycompany.myapp.validator.Ch04MemberEmailValidator;
import com.mycompany.myapp.validator.Ch04MemberJoinFormValidator;
import com.mycompany.myapp.validator.Ch04MemberLoginFormValidator;
import com.mycompany.myapp.validator.Ch04MemberIdValidator;
import com.mycompany.myapp.validator.Ch04MemberPasswordValidator;
import com.mycompany.myapp.validator.Ch04MemberTelValidator;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch05")
@Log4j2
public class Ch05Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch05/content";
	}
	
	@GetMapping("/getHeaderValue")
	public String getHeadervalue(HttpServletRequest request, @RequestHeader("User-Agent") String userAgent) {
		log.info("header 실행");
		log.info("client IP: " + request.getRemoteAddr()); //ip주소를 가진다.
		log.info("Request Method: " + request.getMethod()); //post, get등의 메소드 
		log.info("Context Path(Root): " + request.getContextPath()); //최상단 절대 경로의 값을 가져온다.
		log.info("Request URI: " + request.getRequestURI()); //클라이언트가 요청한 주소
		log.info("Request URL: " + request.getRequestURL()); //클라이언트의 전체 주소
		log.info("Header User-Agent: " + request.getHeader("User-Agent")); //헤더를 통해 운영체제와 브라우저 정보등을 가질 수 있다. 
		log.info(userAgent);
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("createCookie")
	public String createCookie(HttpServletResponse response) {
		log.info("실행");
		
		 Cookie cookie = new Cookie("useremail", "blueskii@naver.com"); 
	     cookie.setDomain("localhost");    //localhost 면 전송
	     cookie.setPath("/webapp/ch05");         //localhost/... 이면 모두 전송
	     cookie.setMaxAge(30*60);      //이 시간동안에만 전송
	     cookie.setHttpOnly(true);       //JavaScript에서 못 읽게함
	     cookie.setSecure(true);       //https://만 전송
	     response.addCookie(cookie);  //set형태로 쿠키를 세팅하고 
		
		
		return "redirect:/ch05/content";
	}
	
	
	
		
		
	
	
}

