package com.mycompany.myapp.controller.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//ch03 content.jsp의 파라미터와 변수명이 동일 해야한다.
@Data
public class ch03Dto {
	private String param1;
	private int param2;
	private double param3;
	private boolean param4;
	@DateTimeFormat(pattern = "yyyy-MM-dd") private Date param5;
	

}
