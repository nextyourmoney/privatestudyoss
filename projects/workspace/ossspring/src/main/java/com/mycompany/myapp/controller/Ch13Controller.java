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

@Controller("ch13Controller")
@RequestMapping("/ch13")
@Log4j2
public class Ch13Controller {
	
	public Ch13Controller() {
		log.info("실행");
	}
	
   @RequestMapping("/content")
   public String content(HttpServletRequest request) {
      log.info("실행");
      return "ch13/content";
   }
   

 
}
   