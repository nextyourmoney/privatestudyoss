package com.mycompany.myapp.controller.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch09Dto {

	private String title;
	private String desc;
	private MultipartFile attach;
}
