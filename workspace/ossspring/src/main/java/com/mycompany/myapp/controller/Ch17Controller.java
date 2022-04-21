package com.mycompany.myapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.controller.dto.Ch16Account;
import com.mycompany.myapp.service.Ch16AccountService;
import com.mycompany.myapp.service.Ch16AccountService.TransferResult;

@Controller
@RequestMapping("/ch17")
public class Ch17Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch17Controller.class);
	
	   @RequestMapping("/content")
	   public String content(Model model) {
	      logger.info("실행");
	      return "ch17/content";
	   }
	   
	   @RequestMapping("/loginForm")
	   public String loginForm() {
	      logger.info("실행");
	      return "ch17/loginForm";
	   }
	   
	   @RequestMapping("/adminAction")
	   public String adminAction() {
	      logger.info("실행");
	      return "redirect:/ch17/content";
	   }
	   
	   @RequestMapping("/managerAction")
	   public String managerAction() {
	      logger.info("실행");
	      return "redirect:/ch17/content";
	   }
	   
	   @RequestMapping("/userAction")
	   public String userAction() {
	      logger.info("실행");
	      return "redirect:/ch17/content";
	   }
	   
	   @RequestMapping("/error403")
	   public String error403() {
	      logger.info("실행");
	      return "ch17/error403";
	   }
}










