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
public class Ch05Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch04/content";
	}
	
	
		
		
		
	
	
	}

