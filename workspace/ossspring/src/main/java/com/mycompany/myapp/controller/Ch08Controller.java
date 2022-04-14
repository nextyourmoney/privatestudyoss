package com.mycompany.myapp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.controller.dto.*;
import com.mycompany.myapp.dao.Ch07Board;
import com.mycompany.myapp.dao.Ch07City;
import com.mycompany.myapp.dao.Ch07Cloth;
import com.mycompany.myapp.dao.Ch07Member;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch08")
@Log4j2
public class Ch08Controller {
   private static final Logger logger = LoggerFactory.getLogger(Ch08Controller.class);
   private int count;  //컨트롤러에서 공유해서 사용하는 것 -> 컨트롤러에는 필드를 선언하지 않는 것이 좋다.
   
   @RequestMapping("/content")
   public String content(HttpServletRequest request) {
      logger.info("실행");
      return "ch08/content";
   }
   
   @GetMapping(value="/saveData", produces="application/json; charset=UTF-8")
   @ResponseBody
   public String saveData(String name, HttpSession session) {
	   session.setAttribute("name", name);
	   
	   //{result: success}
	  JSONObject jsonObject = new JSONObject();
	  jsonObject.put("result", "success");
	  String json = jsonObject.toString();
	  
	 return json;
	  
   }
   
   @GetMapping(value="/readData", produces="application/json; charset=UTF-8")
   @ResponseBody
   public String readData(HttpSession session) {
	   
	   
	   String name = (String)session.getAttribute("name");
	  
			  JSONObject jsonObject = new JSONObject();
			  jsonObject.put("name", name);
			  String json = jsonObject.toString();
			  
			  return json;
	  
   }
   
   @GetMapping("/login")
   public String loginFor() {
	   return "ch08/loginForm";
   }
   
   @PostMapping("/login")
   public String login (String mid, String mpassword, HttpSession session) {
	   if(mid.equals("srping") && mpassword.equals("12345")) {
		   session.setAttribute("sessionMid", mid);
	   }
	   
	   return "redirect:/ch08/content";
	   
   }
   
   @GetMapping("/logout")
   public String logour(HttpSession session) {
	   //세션에서 주어진 키를 삭제
	   session.removeAttribute("sessionMid");
	   
	   //세션 객체 자체를 제거
	   session.invalidate();
	   return "redirect:/ch08/content";
   }
   
   
   
}