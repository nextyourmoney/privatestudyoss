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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.controller.dto.*;


import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch08")
@Log4j2

//새로운 session저장소 생성
@SessionAttributes({"inputForm"})
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
   
   @GetMapping("/userInfo")
   public String userInfo(HttpSession session, @SessionAttribute String sessionMid, @SessionAttribute("sessionMid") String mid) {
	   
	   String memberId = (String) session.getAttribute("sessionMid");
	   
	   log.info("sessionmid" + sessionMid);
	   log.info("mid:" + mid);
	   log.info(memberId);
	   
	   
	   return "redirect:/ch08/content";
   }
   
   @RequestMapping(value="/loginAjax", produces= "application/json; charset=UTF-8")
   @ResponseBody //응답의 본문에 들어간다.
   public String loginAjax(String mid, String mpassword, HttpSession session) {
	   String result = null;
	   if(mid.equals("spring")) {
		   if(mpassword.equals("12345")) {
			   result = "success";
			   session.setAttribute("sessionMid", mid);
		   } else {
			  result = "worngpassword";
		   }
	   } else {
		   result = "worngMid";
		   
	   }
	   JSONObject jsonObject = new  JSONObject();
	   jsonObject.put("result", result);
	   String json = jsonObject.toString();
	   return json;
	   
	   
   }
    
   @RequestMapping(value = "/logoutAjax", produces = {"application/json; charset = UTF-8"})
   @ResponseBody
   public String logoutAjax(HttpSession session, HttpServletRequest request) {
      //세션에서 주어진 키를 삭제
      //session.removeAttribute("sessionMid");
	   
      //세션 객체 자체를 제거
      request.getSession().invalidate();
      //request.getSession(true);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("result", "success");
      String json = jsonObject.toString();
      return json;
   }
   

   //새로운 세션 저장소에 저장하는 역활을 한다. 
   //새로운 세션저장소에 저장 할 때 기존의 객체들을사용하기 위해 기존에 inputForm이라는 이름의 객체들을 inputForm이라고 재정의 한다.
   //여러번 실행되면 객체가 매번 새로 생성되기 때문에 단 한번 실행된다.
   @ModelAttribute("inputForm")
   public Ch08InputForm getCh08InputForm() {
	   Ch08InputForm inputForm = new Ch08InputForm();
	   return inputForm;
	   
   }
   
   @GetMapping("/inputStep1")
   public String inputStep1() {
	   return"ch08/inputStep1";
   }
   
   //inputFrom이라는 이름으로 객체를 사용할 수 있다.
   //dto에 데이터가 자동으로 저장되어 있다.
   @PostMapping("/inputStep2")
   public String inputStep2(@ModelAttribute("inputForm") Ch08InputForm inputForm) {
	   log.info("data1 " + inputForm.getData1());
	   log.info("data2: " + inputForm.getData2());
	   return"ch08/inputStep2";
   }
   
   //done이 참고하는 객체와 inputstetp2가 참조하는 객체가 같다.
   @PostMapping("/inputDone")
   public String inputStep3(@ModelAttribute("inputForm") Ch08InputForm inputForm, SessionStatus sessionStatus) {
	   log.info("data1: " + inputForm.getData1());
	   log.info("data2: " + inputForm.getData2());
	   log.info("data3: " + inputForm.getData3());
	   log.info("data4: " + inputForm.getData4());
	   sessionStatus.setComplete();
	   return"redirect:/ch08/content";
   }
   
   
}