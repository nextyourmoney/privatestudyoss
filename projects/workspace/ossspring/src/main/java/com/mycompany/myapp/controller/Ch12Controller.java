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
@RequestMapping("/ch12")
@Log4j2

//새로운 session저장소 생성
@SessionAttributes({"inputForm"})
public class Ch12Controller {
   private static final Logger logger = LoggerFactory.getLogger(Ch12Controller.class);
   private int count;  //컨트롤러에서 공유해서 사용하는 것 -> 컨트롤러에는 필드를 선언하지 않는 것이 좋다.
   
   @RequestMapping("/content")
   public String content(HttpServletRequest request) {
      logger.info("실행");
      return "ch12/content";
   }
   
   @RequestMapping("/fileList")
   public String fileList() {
	   log.info("실행");
	   return "ch12FileListView";
   }
   
   @RequestMapping("/fileDownload")
   public String fileDownload(@ModelAttribute("fileName") String fileName, @ModelAttribute("userAgent") @RequestHeader("User-Agent") String userAgent) {
	   log.info("실행");
	   return "ch12FileDownloadView";
   }
 
}
   