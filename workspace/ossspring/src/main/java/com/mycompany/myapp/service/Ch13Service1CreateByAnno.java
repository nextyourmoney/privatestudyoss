package com.mycompany.myapp.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service("ch13Service1CreateByAnno") //별도로 이름 선언하지 않으면 맨 앞그랒가 소문자이다.
@Log4j2
public class Ch13Service1CreateByAnno {
	public Ch13Service1CreateByAnno() {
		log.info("tlfgog");
	}

}
