package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoLoggingAspect {

	//setup our logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations 
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..)) ")
	private void forController() {
		
	}
	
	// setup pointcut declarations  for service
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..)) ")
	private void forService() {
		
	}
	
	// setup pointcut declarations for dao
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..)) ")
	private void forDAO() {
		
	}
	
	// setup pointcut declarations for controller or service or dao packages
	@Pointcut("forController() || forService() || forDAO()")
	private void forAppFlow() {
		
	}
	
	//add the @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method  we are calling 
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("===============>> in the @Before: calling method" +method);
		
		//display the arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop through and display args
		for(Object tempArg: args) {
			myLogger.info("=======> arguement" +tempArg);
		}
	}

	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning (JoinPoint theJoinPoint , Object theResult) {
		
		//display method we are returning from
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("===============>> in the @AfterReturning: from method" +method);
		//display data returned
		myLogger.info("===========> the result is: " +theResult);
		
	}
	
}
