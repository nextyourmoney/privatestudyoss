package com.mycompany.myapp.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
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
		log.info("쿠키 생성 실행");
		
		 Cookie cookie = new Cookie("useremail", "blueskii@naver.com"); 
	     cookie.setDomain("localhost");    //localhost 면 전송
	     cookie.setPath("/");         //localhost/... 이면 모두 전송
	     cookie.setMaxAge(30*60);      //이 시간동안에만 전송
	     cookie.setHttpOnly(true);       //JavaScript에서 못 읽게함
	     cookie.setSecure(true);       //https://만 전송
	     response.addCookie(cookie);  //set형태로 쿠키를 세팅하고 
	     
		 cookie = new Cookie("userid", "spring"); 
	     cookie.setDomain("localhost");    //localhost 면 전송
	     cookie.setPath("/");         //localhost/... 이면 모두 전송
	     cookie.setMaxAge(30*60);      //이 시간동안에만 전송
	     cookie.setHttpOnly(false);       //JavaScript에서 못 읽게함
	     cookie.setSecure(true);       //https://만 전송
	     response.addCookie(cookie);  //set형태로 쿠키를 세팅하고 
		
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("getCookie1")
	public String getCookie1(HttpServletRequest request) {
		log.info("실행");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			String cookieName = cookie.getName();
			String cookieValue = cookie.getValue();
			log.info(cookieName + ":" + cookieValue);
		}
		
		return "redirect:/ch05/content";
		
	}
	
	@GetMapping("getCookie2")
	public String getCookie2(@CookieValue String userid, @CookieValue String useremail) {
		log.info("실행");
		log.info("userid: " + userid);
		log.info("useremail: " + useremail);
		
		
		return "redirect:/ch05/content";
		
	}
	
	//json기반 쿠키 생성
	@GetMapping("createJsonCookie")
	public String createJsonCookie(HttpServletResponse response) throws UnsupportedEncodingException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userid","spring");
		jsonObject.put("useremail", "dff@false");
		String json = jsonObject.toString();
		log.info(json);
		json = URLEncoder.encode(json, "UTF-8");
		
		Cookie cookie = new Cookie("user", json);
		response.addCookie(cookie);
		
		return "redirect:/ch05/content";
	}
	
	//쿠키 값 사용하기
	@GetMapping("getJsonCookie")
	public String getJsonCookie(@CookieValue String user) {
		log.info(user);
		JSONObject jsonObject = new JSONObject(user);
		String username = jsonObject.getString("username");
		String useremail = jsonObject.getString("useremail");
		log.info("username; " + username);
		log.info("useremail; " + useremail);
	return "redirect:/ch05/content";
	}
	
		
		
	
	
}

