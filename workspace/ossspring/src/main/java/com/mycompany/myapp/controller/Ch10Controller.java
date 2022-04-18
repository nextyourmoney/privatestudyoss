package com.mycompany.myapp.controller;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.controller.dto.*;
import com.mycompany.myapp.dao.Ch07Board;
import com.mycompany.myapp.dao.Ch07City;
import com.mycompany.myapp.dao.Ch07Cloth;
import com.mycompany.myapp.dao.Ch07Member;
import com.mycompany.myapp.exception.Ch10SoldOutException;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch10")
@Log4j2

//새로운 session저장소 생성
@SessionAttributes({"inputForm"})
public class Ch10Controller {
   private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);
   private int count;  //컨트롤러에서 공유해서 사용하는 것 -> 컨트롤러에는 필드를 선언하지 않는 것이 좋다.
   
   @RequestMapping("/content")
   public String content(HttpServletRequest request) {
      logger.info("실행");
      return "ch10/content";
   }
   
   @RequestMapping("/handlingException1")
   public String handlingException1(String data) {
	  try {
		  if(data.equals("java")) {
			   //NullpointerException 발생
		   }
	  } catch(NullPointerException e) {
		  return "ch10/500_null";
	  }
	  return "redirect:/ch10/content";
   }
   
   @RequestMapping("/handlingException2")
   public String handlingException2(String data) {
	  
		  if(data.equals("java")) {
			   //NullpointerException 발생
		   }

	  return "redirect:/ch10/content";
   }
   
   @RequestMapping("/handlingException3")
   public String handlingException3() {
      logger.info("실행");
      Object data = "abc";
      Date date = (Date) data; //ClassCastException 발생
      return "redirect:/ch10/content";
   }
   
   @RequestMapping("/handlingException4")
   public String handlingException4() {
      logger.info("실행");
      int stock = 0;
      if(stock == 0) {
    	  throw new Ch10SoldOutException("재고 없");
      }
      return "redirect:/ch10/content";
   }
   
   
   
}
   