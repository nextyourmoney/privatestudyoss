package com.mycompany.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j2;

//import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch02")
@Log4j2
public class Ch02Controller {
	//private static final Logger logger = LoggerFactory.getLogger(Ch02Controller.class);
   
   @RequestMapping("/content")
   public String content() {
     // logger.info("실행");
      return "ch02/content";
   }
   
   
   //get 메소드를 가지는 경로의 처
   //@RequestMapping(value = "/method", method=RequestMethod.GET)
   @GetMapping("/method")
   public String method1() {
      log.info("실행");
      return "ch02/content";
   }
   
   //속성 값 
   //@RequestMapping(value = "/method", method=RequestMethod.POST)
   @PostMapping("/method")
   public String method2() {
      log.info("실행");
      return "ch02/content";
   }
   
   @PutMapping("/method")
   //@RequestMapping(value = "/method", method=RequestMethod.PUT)
   public String method3() {
      log.info("실행");
      return "ch02/content";
   }
   
   //@RequestMapping(value = "/method", method=RequestMethod.DELETE)
   @DeleteMapping("/method")
   public String method4() {
      log.info("실행");
      return "ch02/content";
   }


}