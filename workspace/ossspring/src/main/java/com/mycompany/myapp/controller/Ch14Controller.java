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
@RequestMapping("/ch14")
@Log4j2
public class Ch14Controller {
	@Resource
	private Ch14MemberService memberService;
	
	
	
   @RequestMapping("/content")
   public String content() {
	   
	  
     // log.info("실행");
      return "ch14/content";
   }
   
   @GetMapping("/join")
   public String joinForm() {
	   return "ch14/joinForm";
   }
   
   @PostMapping("/join")
   public String join(Ch14Member member, Model model) {
	   member.setMenabled(true);
	   member.setMrole("ROLE_USER");
	   
	   //JoinResult jr = JoinResult.DUPLICARTED;
	   JoinResult jr = memberService.join(member);
	   if(jr == JoinResult.SUCCESS) {
		   return "redirect:/ch14/content";
	   } else if(jr == JoinResult.DUPLICARTED) {
		   model.addAttribute("error", "중복된 아이디가 있습니다?.");
		   return "ch14/joinForm";
	   } else {
		   model.addAttribute("error", "회원 가입 실패");
		   return "ch14/joinForm";
	   }
	  
   }
   
   @GetMapping("/login")
   public String loginForm() {
	   return "ch14/loginForm";
   }
   
   @PostMapping("login")
   public String login(Ch14Member member, HttpSession session, Model model) {
	   LoginResult result = memberService.login(member);
	   if(result == LoginResult.SUCCESS) {
		   session.setAttribute("sessionMid", member.getMid());
		   return "redirect:/ch14/content";
	   } else if(result == LoginResult.FAIL_MID) {
		   model.addAttribute("error", "아이디가 존재 ㅌ");
		   return "ch14/loginForm";
	   } else {
		   model.addAttribute("error", "패스워드가 틀리다");
		   return "ch14/loginForm";
	   }
   }
   
   @GetMapping("/logout")
   public String logout(HttpSession session) {
	   session.removeAttribute("sessionMid");
	   return "redirect:/ch14/content";
	   
   }
   
   @Resource
   private Ch14BoardService boardService;
   
   
   @GetMapping("/boardList")
   public String boardList(@RequestParam(defaultValue="1") int pageNo, Model model) {
	   int totalBoardNum = boardService.getTotalBoardNum();
	   Pager pager = new Pager(5, 5, totalBoardNum, pageNo);
	   model.addAttribute("pager", pager);
	   log.info("test");
	   
	   List<Ch14Board> boards = boardService.getBoards(pager);
	   log.info("test1");
	   model.addAttribute("boards", boards);
	   
	   return "/ch14/boardList";
	   
   }
   
   @GetMapping("/boardWriteForm")
   public String boardWriterForm() {
	   return "ch14/boardWriteForm";
   }

   
  @PostMapping("/boardWrite")
   public String boardWrite(Ch14Board board) throws IOException {
	  if(board.getBattach().isEmpty()) { //파일이 넘어오지 않아도 에러가 아니다.
		  board.setBattachoname(board.getBattach().getOriginalFilename());
		  board.setBattachtype(board.getBattach().getContentType());
		  board.setBattachoname(new Date().getTime() + "-" + board.getBattachoname());
		  File file = new File("/Users/jbc/Desktop/" + board.getBattachoname());
		 
		  log.info(file);
		  board.getBattach().transferTo(file);  
	  }
	  
	  boardService.writeBoard(board);
	  return "redirect:/ch14/boardList";
  }
  
  @GetMapping("/boardDetail")
  public String boardDetail(int bno, Model model) {
	  Ch14Board board = boardService.getBoard(bno);
	  model.addAttribute("board", board);
	  return "ch14/boardDetail";
	  
	  
  }

  
  @GetMapping("/filedownload")
  public void filedownload(int bno, HttpServletResponse response, @RequestHeader("User-Agent") String userAgent) throws Exception {
	  
	  Ch14Board board = boardService.getBoard(bno);
	  String contentType = board.getBattachtype();
      //다운로드 할 파일 이름
      String originalFilename = board.getBattachoname();
      //다운로드 받아서 할 파일 이름 //다운을 하면 다음과 같은 파일이름으로 되어야 한다.
      String saveFilename = board.getBattachsname();
      
      //응답 내용의 데이터 타입을 응답 헤더에 추가
      response.setContentType(contentType);
      
      //다운로드할 파일명을 헤더에 추가
      if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {
         //IE 브라우저일 경우
         originalFilename = URLEncoder.encode(originalFilename, "UTF-8");
      } else {
         //크롬, 엣지, 사파리일 경우
         originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
      }
      
      //attachment를 통해 첨부파일임을 선언한다.
      response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFilename + "\"");
      
      //파일 데이터를 응답 본문에 실기
      File file = new File("/Users/jbc/Desktop/upload/" + saveFilename);
      if(file.exists()) {
         FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
      }
  }
  
  @GetMapping("/boardUpdateForm")
  public String boardUpdateForm(int bno, Model model) {
	  Ch14Board board = boardService.getBoard(bno);
	  model.addAttribute("board", board);
	  return "ch14/boardUpdateForm";
	}
  
  @PostMapping("/boardUpdate")
  public String boardUpdate(Ch14Board board) {
//	  Ch14Board dbboard = boardService.getBoard(board.getBno());
//	  dbboard.setBtitle(board.getBtitle());
//	  dbboard.setBcontent(board.getBcontent());
//	  boardService.updateBoard(dbboard);
	  boardService.updateBoard(board);
	  return "redirect:/ch14/boardDetail?bno=" + board.getBno();
	  
  }
  
  @GetMapping("/boardDelete")
  public String boardDelete(int bno) {
	  boardService.removeBoard(bno);
	  return "redirect:/ch14/boardList";
  }
  
}
   