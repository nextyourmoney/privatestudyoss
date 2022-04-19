package com.mycompany.myapp.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.Ch13Dao2CreateByXML;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Ch13Service6InjectByXML {
	private Ch13Dao2CreateByXML dao;
	private String str;
	private List collection1;
	private Set collection2;
	private Map collection3;
	private Properties collection4;
	
	public void setCollection1(List collection1) {
		log.info("실행");
		this.collection1 = collection1;
	}

	public void setCollection2(Set collection2) {
		log.info("실행");
		this.collection2 = collection2;
	}

	public void setCollection3(Map collection3) {
		log.info("실행");
		this.collection3 = collection3;
	}

	public void setCollection4(Properties collection4) {
		log.info("실행");
		this.collection4 = collection4;
	}

	public Ch13Service6InjectByXML() {
		log.info("실행: Ch13Service6InjectByXML");
		
	}
	
	public Ch13Service6InjectByXML(Ch13Dao2CreateByXML dao, String str) {
		log.info("실행: Ch13Service6InjectByXML");
		this.dao = dao;
		this.str = str;
		
	}
	
	public void setDao(Ch13Dao2CreateByXML dao) {
		this.dao = dao;
	}
	
	public void setStr(String str) {
		this.str = str;
	}

}
