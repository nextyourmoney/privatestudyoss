package com.mycompany.myapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class Ch15Aspect1Before{
	
	//해당 경로의 메소드가 실행 전 먼저 공통 코드를 실행시킨다.//같은 선언이 있을경우 동시에 실행한다.
	@Before("execution(public * com.mycompany.myapp.controller.Ch15Controller.before*(..))")
	public void method() {
		log.info("실행");
	
		
	}
	
}