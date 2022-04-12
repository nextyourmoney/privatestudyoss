package com.mycompany.myapp.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.controller.dto.ch03Dto;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch03")
@Log4j2
public class Ch03Controller {
	
	@RequestMapping("/content")
	public String content() {
		log.info("데이터 받기 실행");
		
		return "ch03/content";
		
	}
	
	/*
	 * 기본 default로 String을 받는다.
	@RequestMapping("/method1")
	public String method1(String param1, String param2, String param3, String param4, String param5) {
		log.info(param1);
		log.info(param2);
		log.info(param3);
		log.info(param4);
		log.info(param5);
		return "ch03/content";
	}
	*/
	
	//각각의 형식으로 지정 할 수 있고 Date는 Spring의 제공하는 데이터 형식 포멧이다.
	//매개변수의 이름과 파라미터의 이름이 다를 경우 RequestParam을 통해 매핑 시킨다. 
	@GetMapping("/method1")
	public String method1(@RequestParam("param1") String arg1, int param2, double param3, boolean param4, @DateTimeFormat(pattern = "yyyy-MM-dd") String param5) {
		log.info(arg1);
		log.info(param2);
		log.info(param3);
		log.info(param4);
		log.info(param5);
		return "ch03/content";
	}
	
	//post방식으로의 선언 및 사
	@PostMapping("method2")
	public String method2(String param1, int param2, double param3, boolean param4, @DateTimeFormat(pattern = "yyyy-MM-dd") String param5) {
		log.info(param1);
		log.info(param2);
		log.info(param3);
		log.info(param4);
		log.info(param5);
		return "ch03/content";
	}
	
	//필수를 true라고 선언 했을 때 값이 없다면 에러가 발생한다. 
		@GetMapping("/method3")
		public String method3(@RequestParam(required = true) String param1, @RequestParam(required = true)  int param2) {
			log.info(param1);
			log.info(param2);
			return "ch03/content";
		}
		
		//다음과 같이 매개변수에 선언된 값이 포함되어 있지 않으면 에러가 발생하기 때문에 default선언을 해주어야 한다. 
		@GetMapping("/method4")
		public String method4( String param1, @RequestParam(defaultValue = "500") int param2, @RequestParam(defaultValue = "5.0")double param3, boolean param4 ) {
			log.info(param1);
			log.info(param2);
			log.info(param3);
			return "ch03/content";
		}
		
		//객체로파라미터 값 받기
		@GetMapping("/method5")
		public String method5(ch03Dto dto ) {
			log.info(dto);
			log.info(dto.getParam1());
			log.info(dto.getParam2());
			log.info(dto.getParam3());
			log.info(dto.isParam4());
			log.info(dto.getParam5());
			return "ch03/content";
		}
	
	

}
