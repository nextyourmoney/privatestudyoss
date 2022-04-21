package com.mycompany.myapp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Order() //순서를 임의로 정의할 수 있다.
@Log4j2
public class Ch15Aspect4AfterReturning{
	
	//메소드가 예외 없이 실행되었을 떄 예외 없이 실행되고 메소드 값이 return에 실행된다.
	//after로 시작하니까 after도 실행한다.
	@AfterReturning(
		      pointcut="execution(public * com.mycompany.myapp.controller.Ch15Controller.afterReturning*(..))",
		      returning="returnValue"  //매게 변수 선언	      
			)
	
	//위의 returnvalue가 들어온다.
	public void method(String returnValue) {
		log.info("실행");
		log.info("리턴값" + returnValue);
		
	}
	
	
}