package com.mycompany.myapp.controller;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
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

import com.mycompany.myapp.aspect.Ch15Aspect7RuntimeCheck;
import com.mycompany.myapp.aspect.Ch15Aspect8LoginCheck;
import com.mycompany.myapp.controller.dto.*;
import com.mycompany.myapp.dao.mybatis.Ch14BoardDao;
import com.mycompany.myapp.exception.Ch10SoldOutException;
import com.mycompany.myapp.service.Ch14BoardService;
import com.mycompany.myapp.service.Ch14MemberService;
import com.mycompany.myapp.service.Ch14MemberService.JoinResult;
import com.mycompany.myapp.service.Ch14MemberService.LoginResult;
import com.mycompany.myapp.controller.dto.*;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch15")
@Log4j2
public class Ch15Controller {
	
	@RequestMapping("/content")
	public String content() {
		return "ch15/content";
	}
	
	@RequestMapping("/before1")
	public String before1() {
	    log.info("실행");
	    return "redirect:/ch15/content";
	}
	
	@RequestMapping("/before2")
	public String before2() {
	    log.info("실행");
	    return "redirect:/ch15/content";
	}
	
	   @RequestMapping("/after")
	   public String afterXXX() {
	      log.info("실행");
	      return "redirect:/ch15/content";
	   }
	   
	   @RequestMapping("/afterReturning")
	   public String afterReturning() {
	      log.info("실행");
	      return "redirect:/ch15/content";
	   }
	   
	   
	   //예외 처리
	   @RequestMapping("/afterThrowing")
	   public String afterThrowing() {
	      log.info("실행");
	      boolean result = true;
	      if(result) {
	         throw new RuntimeException("테스트 예외입니다.");
	      }
	      return "redirect:/ch15/content";
	   }
	   
	   @RequestMapping("/around")
	   public String around() {
	      log.info("실행");
	      return "redirect:/ch15/content";
	   }
	   
	   /*
	   @RequestMapping("/runtimeCheck")
	   @Ch15Aspect7RuntimeCheck
	   public String runtimeCheck() {
		   log.info("tlfgod");
		   return "redirect:/ch15/content";
		   
	   }
	   */
	   
	   @Resource
	   private Ch14BoardService boardService;
	   @RequestMapping("/runtimeCheck")
	   @Ch15Aspect7RuntimeCheck //시간 측정 기능을 구
	   public String runtimeCheck() {
	      log.info("실행");
	      Pager pager = new Pager(10, 5, boardService.getTotalBoardNum(), 1);
	      List<Ch14Board> boards = boardService.getBoards(pager);
	      return "redirect:/ch15/content";
	   }
	   
	   @GetMapping("/boardList")
	   @Ch15Aspect8LoginCheck
	   public String boardList(Model model) {
	      log.info("실행");
	      Pager pager = new Pager(5, 5, boardService.getTotalBoardNum(), 1);
	      List<Ch14Board> boards = boardService.getBoards(pager);
	      model.addAttribute("boards", boards);
	      return "ch15/boardList";
	   }
	
  
}
   