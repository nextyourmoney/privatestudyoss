package com.mycompany.myapp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Order() //순서를 임의로 정의할 수 있다.
@Log4j2
public class Ch15Aspect3After{
	
	@After("execution(public * com.mycompany.myapp.controller.Ch15Controller.after*(..))")
	public void method() {
		log.info("실행");
		
	}
	
	
}