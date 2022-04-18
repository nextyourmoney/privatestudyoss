package com.mycompany.myapp.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;

@Repository("ch13Dao1CreateByAnno")
@Log4j2
public class Ch13Dao1CreateByAnno {
	public Ch13Dao1CreateByAnno() {
		log.info("tlfgod");
	}
	
}
