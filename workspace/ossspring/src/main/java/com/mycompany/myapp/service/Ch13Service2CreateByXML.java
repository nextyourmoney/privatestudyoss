package com.mycompany.myapp.service;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Ch13Service2CreateByXML {
	public Ch13Service2CreateByXML() {
		log.info("tlfgog");
	}
	
	public static Ch13Service2CreateByXML getInstance1() {
		log.info("tlfgog");
		Ch13Service2CreateByXML obj = new Ch13Service2CreateByXML();
		return obj;
	}
	
	public Ch13Service2CreateByXML getInstance2() {
		log.info("tlfgog");
		Ch13Service2CreateByXML obj = new Ch13Service2CreateByXML();
		return obj;
	}

}
