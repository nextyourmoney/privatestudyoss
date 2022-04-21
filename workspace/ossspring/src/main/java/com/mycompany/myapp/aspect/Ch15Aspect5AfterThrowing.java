package com.mycompany.myapp.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class Ch15Aspect5AfterThrowing {

	// 예외 처리
	@AfterThrowing(
			pointcut = "execution(public * com.mycompany.myapp.controller.Ch15Controller.afterThrowing*(..))", 
			throwing = "e" // 매게																																																										// 선언
	)

	// Throwable은 예외 최상위 Exception을 상속한다.
	public void method(Throwable e) {
		log.info("실행");
		log.info("예외 메시지" + e.getMessage());

	}

}