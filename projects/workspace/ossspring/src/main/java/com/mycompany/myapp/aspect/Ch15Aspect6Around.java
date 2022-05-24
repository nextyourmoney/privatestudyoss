package com.mycompany.myapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class Ch15Aspect6Around {

	@Around("execution(public * com.mycompany.myapp.controller.Ch15Controller.around*(..))")
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//전처리(핵심 코드 이전에 실행할 코드)
		log.info("전처리");
		
		Object result = joinPoint.proceed(); //다음 code를 기준으로 한다.  //around를 실행한다는 의미이다.
		
		//후처리(핵심 코드 이전에 실행할 코드)
		log.info("후 처리");
		return result;
	}

}