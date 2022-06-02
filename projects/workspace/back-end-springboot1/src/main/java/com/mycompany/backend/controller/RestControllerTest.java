package com.mycompany.backend.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.backend.dto.Board;
import com.mycompany.backend.dto.Member;

import lombok.extern.log4j.Log4j2;

@RestController // 모든 요청매핑 메소드에 @ResponseBody가 자동으로 붙게함
@RequestMapping("/rest")
@Log4j2
public class RestControllerTest {
	@GetMapping("getObject")
	@ResponseBody
	public Board getObject() {
		log.info("실행");
		Board board = new Board();
		board.setBno(1);
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setMid("user");
		board.setBdate(new Date());
		return board;
	}

	@GetMapping("getMap")
	@ResponseBody
	public Map<String, Object> getMap() {
		log.info("실행");

		Map<String, Object> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", 25);

		Board board = new Board();
		board.setBno(1);
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setMid("user");
		board.setBdate(new Date());
		map.put("board", board);

		return map;
	}

	@GetMapping("/getArray")
	public String[] getArray() {
		log.info("실행");
		String[] array = { "Java", "Spring", "Vue" };
		return array;
	}

	@GetMapping("/getList1")
	public List<String> getList1() {
		log.info("실행");
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("Spring");
		list.add("vue");
		return list;
	}

	@RequestMapping("getList2")
	public List<Board> getList2() {
		log.info("실행");
		List<Board> list = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setBno(i);
			board.setBtitle("제목" + i);
			board.setBcontent("내용" + i);
			board.setMid("user");
			board.setBdate(new Date());
			list.add(board);
		}
		return list;
	}
	
	//여러 형태의 
	@GetMapping("/useHttpServletResponse")
	public void getHeader(HttpServletResponse response) throws IOException {
		//응답 헤더 설정
		response.setContentType("application/json; charset=UTF-8");
		response.addHeader("TestHeader", "value");
		
		Cookie cookie = new Cookie("refreshToken", "XXXXX");
		response.addCookie(cookie);
		
		//응답 본문 설
		//json의존성 추가 필요 //json 자체를 객체로 사용한다.
		PrintWriter pw = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		String json = jsonObject.toString();
		
		pw.println(json);
		pw.flush();
		pw.close();
	}
	
	@GetMapping("/useHttpServletResponseEntity")
	public ResponseEntity<String> useResponseEntity() {
		
		  JSONObject jsonObject = new JSONObject();
		  jsonObject.put("name", "홍길동");
		  jsonObject.put("age", 25);
		  String json = jsonObject.toString();
		  
		  String cookieStr = ResponseCookie.from("refreshToken", "xxx")
				  .build()
				  .toString();

	  return ResponseEntity
			  .ok()
			  .header(HttpHeaders.CONTENT_TYPE, "application/json")
			  .header("TestHeader", "value")
			  .header(HttpHeaders.COOKIE, getArray())
			  .body(json);
	}
	
	@RequestMapping("/sendQueryString")
	public Member sendQueryString(Member member) {
		return member; 
		
	}
	
	@RequestMapping("/sendJson")
	public Member sendJson(@RequestBody Member member) {
		return member; 
		
	}
	
	@PostMapping("/sendMultipartFormData")
	public Map<String, String> sendMultipartFormData(String title, MultipartFile attach) throws IllegalStateException, IOException{
		String savedFile = new Date().getTime() + "-" + attach.getOriginalFilename();
		attach.transferTo(new File("/Users/jbc/Desktop/osstem/upload/" + savedFile));
		
		Map<String, String> map = new HashMap<>();
		map.put("result", "succes");
		map.put("savedFile", savedFile);
		return map;
		
		
	}
	
	

}
