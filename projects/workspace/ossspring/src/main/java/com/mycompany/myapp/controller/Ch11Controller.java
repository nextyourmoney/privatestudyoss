package com.mycompany.myapp.controller;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.mycompany.myapp.exception.Ch10SoldOutException;

import com.mycompany.myapp.controller.dto.*;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch11")
@Log4j2

//새로운 session저장소 생성
@SessionAttributes({"inputForm"})
public class Ch11Controller {
   private static final Logger logger = LoggerFactory.getLogger(Ch11Controller.class);
   private int count;  //컨트롤러에서 공유해서 사용하는 것 -> 컨트롤러에는 필드를 선언하지 않는 것이 좋다.
   
   @RequestMapping("/content")
   public String content(HttpServletRequest request) {
      logger.info("실행");
      return "ch11/content";
   }
   
   @GetMapping("/form1")
   public String form1(@ModelAttribute("member") Ch11Member member) {
	   member.setMid("spring");
	   member.setMname("JBC");
	   member.setMpassword("12345");
	   member.setMnation("한국");
	   return "ch11/form1"; 
   }
   
   @PostMapping("/form1")
   public String handleform1(@ModelAttribute("member") Ch11Member member) {
	  log.info("mid", member.getMid());
	  log.info("mname", member.getMname());
	  log.info("mpassword", member.getMpassword());
	  log.info("mnation", member.getMnation());
	  log.info("malnguage: " + Arrays.toString(member.getMskill()));
      log.info(member);
	   return "redirect:/ch11/form1";
   }
   
   @GetMapping("/form2")
   public String form2(@ModelAttribute("member") Ch11Member member, Model model) {
      logger.info("실행");
      
      //드롭다운리스트의 항목을 추가할 목적
      List<String> typeList = new ArrayList<>();
      typeList.add("일반회원");
      typeList.add("기업회원");
      typeList.add("헤드헌터회원");
      model.addAttribute("typeList", typeList);   
      
      //기본 선택 항목을 설정
      member.setMtype("기업회원");
      
      //드롭다운리스트의 항목을 추가할 목적
      List<String> jobList = new ArrayList<>();
      jobList.add("학생");
      jobList.add("개발자");
      jobList.add("디자이너");
      model.addAttribute("jobList", jobList);
      
      //기본 선택 항목을 설정
      member.setMjob("개발자");
      
      //드롭다운리스트의 항목을 추가할 목적
      List<Ch11City> cityList = new ArrayList<>();
      cityList.add(new Ch11City(1, "서울"));
      cityList.add(new Ch11City(2, "부산"));
      cityList.add(new Ch11City(3, "제주"));
      model.addAttribute("cityList", cityList);
      
      //기본 선택 항목을 설정
      member.setMcity(3);
      
      return "ch11/form2";
   }
   
   @GetMapping("/form3")
   public String form3(@ModelAttribute("member") Ch11Member member, Model model) {
      logger.info("실행");
      
      List<String> languageList = new ArrayList<>();
      languageList.add("C");
      languageList.add("Python");
      languageList.add("Java");
      languageList.add("JavaScript");
      model.addAttribute("languageList", languageList);
      
      member.setMlanguage(new String[] {"Python", "JavaScript"});
      
      List<Ch11Skill> skillList = new ArrayList<>();
      skillList.add(new Ch11Skill(1, "SpringFramework"));
      skillList.add(new Ch11Skill(2, "SpringBoot"));
      skillList.add(new Ch11Skill(3, "Vue"));
      model.addAttribute("skillList", skillList);
      
      member.setMskill(new int[] {1, 3});
      
      return "ch11/form3";
   }
   
   @GetMapping("/form4")
   public String form4(@ModelAttribute("member") Ch11Member member, Model model) {
      logger.info("실행");
      
      //드롭다운리스트의 항목을 추가할 목적
      List<String> jobList = new ArrayList<>();
      jobList.add("학생");
      jobList.add("개발자");
      jobList.add("디자이너");
      model.addAttribute("jobList", jobList);
      
      //기본 선택 항목을 설정
      member.setMjob("개발자");
      
      //드롭다운리스트의 항목을 추가할 목적
      List<Ch11City> cityList = new ArrayList<>();
      cityList.add(new Ch11City(1, "서울"));
      cityList.add(new Ch11City(2, "부산"));
      cityList.add(new Ch11City(3, "제주"));
      model.addAttribute("cityList", cityList);
      
      //기본 선택 항목을 설정
      member.setMcity(3);
      
      return "ch11/form4";
   }
   
   @GetMapping("/form5")
   public String form5(@ModelAttribute("member") Ch11Member member) {
	  
	   return "ch11/form5"; 
   }

   
   
}
   