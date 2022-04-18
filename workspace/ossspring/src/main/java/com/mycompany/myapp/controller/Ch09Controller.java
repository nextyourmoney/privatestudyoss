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

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch09")
@Log4j2

//새로운 session저장소 생성
@SessionAttributes({"inputForm"})
public class Ch09Controller {
   private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);
   private int count;  //컨트롤러에서 공유해서 사용하는 것 -> 컨트롤러에는 필드를 선언하지 않는 것이 좋다.
   
   @RequestMapping("/content")
   public String content(HttpServletRequest request) {
      logger.info("실행");
      return "ch09/content";
   }
   
   @PostMapping("/fileupload")
   public String fileUpload(String title, String desc, MultipartFile attach) throws Exception {
	   log.info("title" + title);
	   log.info("title" + desc);
	   log.info("title" + attach.getOriginalFilename());
	   log.info("title" + attach.getContentType());
	   log.info("title" + attach.getSize());
	   
	   //받은 파일을 DB에 저장할 때
	   //byte[] bytes = attach.getBytes();
	   //InputStream is = attach.getInputStream();
	   
	   //받은 파일을 서버 파일 시스템에 저장
	   
	   //현재 시간을 기준으로 파일이름을 생성하여 파일이름 중첩을 방지한다. 
	   String saveFilename = new Date().getTime() + "_" + attach.getOriginalFilename();
	   File file = new File("/Users/jbc/Desktop/upload/" + saveFilename);
	   attach.transferTo(file);
	   
	   return "redirect:/ch09/content";
   }
   
   @PostMapping(value = "/fileuploadAjax", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public String fileUploadajax(Ch09Dto dto) throws Exception {
	   log.info("title" + dto.getTitle());
	   log.info("title" + dto.getDesc());
	   
	   log.info("title" + dto.getAttach().getOriginalFilename());
	   log.info("title" + dto.getAttach().getContentType());
	   log.info("title" + dto.getAttach().getSize());
	   
	   //받은 파일을 DB에 저장할 때
	   //byte[] bytes = attach.getBytes();
	   //InputStream is = attach.getInputStream();
	   
	   //받은 파일을 서버 파일 시스템에 저장
	   
	   //현재 시간을 기준으로 파일이름을 생성하여 파일이름 중첩을 방지한다. 
	   String saveFilename = new Date().getTime() + "_" + dto.getAttach().getOriginalFilename();
	   File file = new File("/Users/jbc/Desktop/upload/" + saveFilename);
	   dto.getAttach().transferTo(file);
	   
	   JSONObject jsonObject = new JSONObject();
	   jsonObject.put("result", "success");
	   jsonObject.put("saveFilename", saveFilename);
	   String json = jsonObject.toString();
	   
	   return json;
   }
   
   @RequestMapping("/filedownload")
   public void filedownload(int fileNo, HttpServletResponse response, @RequestHeader("User-Agent") String userAgent) throws Exception {
      //DB에서 가져올 정보
      String contentType = "image/png";
      
      //다운로드 할 파일 이름
      String originalFilename = "1650005369558_photo1.jpg";
      
      //다운로드 받아서 할 파일 이름 //다운을 하면 다음과 같은 파일이름으로 되어야 한다.
      String saveFilename = "1650005259485-car.png";
      
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
   
}
   