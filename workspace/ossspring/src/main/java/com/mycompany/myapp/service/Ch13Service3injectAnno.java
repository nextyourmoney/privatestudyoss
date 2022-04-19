package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.Ch13Dao1CreateByAnno;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Ch13Service3injectAnno {
	public Ch13Service3injectAnno() {
		log.info("실행");
		
	}
	/*
	
	//타입으로 주입
	@Autowired
	private Ch13Dao1CreateByAnno ch13Dao1;
	
	//Ch13Dao1CreateByAnno타입이 있다면 자동으로 추가한다.
	@Autowired
	public Ch13Service3injectAnno(Ch13Dao1CreateByAnno ch13Dao1) {
		log.info("실행: 타입으로 주");
		this.ch13Dao1 = ch13Dao1;
	}
	
	@Autowired
	public void setCh13Dao1(Ch13Dao1CreateByAnno ch13Dao1) {
		log.info("실행2");
	this.ch13Dao1 = ch13Dao1;
	}
	*/
	
	//이름으로 주입
	@Autowired @Qualifier("ch13Dao1")
	private Ch13Dao1CreateByAnno ch13Dao1;
	
	@Autowired 
	public Ch13Service3injectAnno(@Qualifier("ch13Dao1") Ch13Dao1CreateByAnno ch13Dao1) {
		log.info("실행: 타입으로 주");
		this.ch13Dao1 = ch13Dao1;
	}
	
	@Autowired //이름으로 주
	public void setCh13Dao1(@Qualifier("ch13Dao1") Ch13Dao1CreateByAnno ch13Dao1) {
		log.info("실행2");
	this.ch13Dao1 = ch13Dao1;
	}
	

}
