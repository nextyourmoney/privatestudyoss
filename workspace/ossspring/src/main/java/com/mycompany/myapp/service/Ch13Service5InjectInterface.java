package com.mycompany.myapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.Ch13DaoI;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Ch13Service5InjectInterface {
	public Ch13Service5InjectInterface() {
		log.info("test3");
	}
	
	@Autowired @Qualifier("ch13DaoImpl1")
	private Ch13DaoI ch13DaoI1;
	
	@Resource(name="ch13DaoImpl2")
	private Ch13DaoI ch13DaoI2;
	
	@Autowired
	public void setCh13DaoI1(Ch13DaoI ch13DaoI1) {
		this.ch13DaoI1 = ch13DaoI1;
	}
	
	@Resource
	public void setCh13DaoI2(Ch13DaoI ch13DaoI2) {
		this.ch13DaoI2 = ch13DaoI2;
	}

}
