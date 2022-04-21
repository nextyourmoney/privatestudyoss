package com.mycompany.myapp.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class Ch15Aspect7Around {

	//annotaion class를 선언하여 사용한다. 
	@Around("@annotation(com.mycompany.myapp.aspect.Ch15Aspect7RuntimeCheck)")
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//전처리(핵심 코드 이전에 실행할 코드)
		log.info("전처리");
		long start = System.nanoTime();
		
		//ch15의 redirect 값을 가지게 된다.
		Object result = joinPoint.proceed(); //다음 code를 기준으로 한다.  //ch15aspect7runtimecheck을 실행한다.
		
		//후처리(핵심 코드 이전에 실행할 코드)
		log.info("후 처리");
		long end = System.nanoTime();
		
		//핵심 코드 (메소드) 이름 얻기
		String methodName = joinPoint.getSignature().toShortString();
		
		long howLong = end - start;
		log.info(methodName + "실행시간: " + howLong + "ns");
		
		//jsp로 데이터 전송
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();	
		HttpSession session = request.getSession();
		session.setAttribute("methodName", methodName);
		session.setAttribute("howLong", howLong);
		
		return result;
	}

}