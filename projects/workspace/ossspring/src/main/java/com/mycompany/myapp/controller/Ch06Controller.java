package com.mycompany.myapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@RequestMapping("/ch06")
@Log4j2
public class Ch06Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch06/content";
	}
	
	@GetMapping("/forward")
	public String forward() {
		return "ch06/forward";
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/";
	}
	
	@GetMapping("getFragmentHtml")
	public String getFragmentHtml() {
		log.info("image 시작");
		return "ch06/fragmentHtml";
	}
	
	@GetMapping("getJson1")
	public String getJson1(HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo6.jpg");
		String json = jsonObject.toString();
		
		response.setContentType("application/json; charset=UTF=8"); //application의 json 파
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();
		
		return "ch06/fragmentHtml";
	}
	
	@ResponseBody//리턴되는 내용이 본문에 들어간다. 그러니까 html의 바디에 들어간다. 
	@GetMapping(value="/getJson2", produces="application/json; charset=UTF-8") 
	public String getJson2() throws IOException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo6.jpg");
		String json = jsonObject.toString();
		
		return json;
	}
	
	
	

}

