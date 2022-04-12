package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch01")
@Log4j2
public class ch01Controller {
	private static final Logger logger = LoggerFactory.getLogger(ch01Controller.class);
   

   @RequestMapping("/content")
   public String content(){
      logger.info("실행1");
	  log.info("실행");
	  System.out.print("실생");
      return "ch01/content";
   }
}