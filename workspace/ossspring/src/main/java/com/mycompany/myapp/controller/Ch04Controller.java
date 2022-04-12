package com.mycompany.myapp.controller;

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
@RequestMapping("/ch04")
@Log4j2
public class Ch04Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch04/content";
	}
	
	@PostMapping("/method1")
	public String method1(ch04Dto dto) {
		log.info(dto.toString());
		
		return "ch04/content";
	}
	
	//DO와 유효성 검사기를 연다 webDataBinder가 중요하다
	//아래 valid와 연관된다.
	@InitBinder("joinForm")
	public void bindCh04MemberJoinFormValidator(WebDataBinder binder) {
		//binder.setValidator(new Ch04MemberJoinFormValidator());
		
		//하나하나의 요소별 유효성 검
		binder.addValidators(
		new Ch04MemberIdValidator(),
        new Ch04MemberPasswordValidator(),
        new Ch04MemberEmailValidator(),
        new Ch04MemberTelValidator()
        );
	}
	
	//valid는 유효성 검사를 하라는 지시이다.
	//BindingResult bindingresult == Errors errors
	//modelattribute로 joinform를 참조한다.
	@PostMapping("/join")
	public String join(@ModelAttribute("joinForm") @Valid Ch04Member member, Errors errors) {
		log.info(member);
		
		//유효성 검사 확인
		if(errors.hasErrors()) {
			//다시 입력 폼으로 돌아간다.
			return "ch04/content";
		} 
		
		//회원 가입 처리
		//....
		
		//홈페이지로 이동
			return "redirect:/";
		}
	
	
		@InitBinder("loginForm")
		public void bindCh04MemberLoginFormValidator(WebDataBinder binder) {
			binder.setValidator(new Ch04MemberLoginFormValidator());
			
		}
		
		
		@PostMapping("/login")
		public String login(@ModelAttribute("loginForm") @Valid Ch04Member member, Errors errors) {
			log.info(member);
			
			//유효성 검사 확인
			if(errors.hasErrors()) {
				return "ch04/content";
			} 
		
				return "redirect:/";
			}
		
		
		
	
	
	}

