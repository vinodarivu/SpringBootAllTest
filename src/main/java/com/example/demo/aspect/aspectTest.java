package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.demo.rest.model.ContentNegotiationRequest;

@Component
@Aspect
public class aspectTest {

	@Before(value = "execution(* com.example.demo.rest.RestExample.*(..)) and args(userName) ")
	public void beforeAdvice(JoinPoint joinPoint, String userName) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("get data from AOP  - " + userName);
	}
	
	@After(value = "execution(* com.example.demo.rest.RestExample.*(..)) and args(data) ")
	public void afterAdvice(JoinPoint joinPoint, ContentNegotiationRequest data) {
		System.out.println("After method:" + joinPoint.getSignature());
		System.out.println("get data from AOP for After  - " + data);
	}

}
