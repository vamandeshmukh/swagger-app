package com.imarticus.tutorial.aop;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BooksInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
	
	 @Before("execution(* com.imarticus.tutorial.controllers.BookController.*(..))")
	public void beforeBookControllerMethods(JoinPoint joinPoint){
	
		String methodName =joinPoint.getSignature().getName();
				
		String args = Arrays.asList(joinPoint.getArgs()).stream().map(object->object.toString()).collect(Collectors.joining(","));

		logger.info("Executing before method Name => " + methodName + " arguments =>" + args);
	}
	 
	 
	 	@AfterThrowing(pointcut = "execution(* com.imarticus.tutorial.controllers.BookController.*(..))", throwing = "exception")
		public void afterThrowingExceptionOnBookControllerMethods(JoinPoint joinPoint, Exception exception){
			
			String methodName =joinPoint.getSignature().getName();
					
			String args = Arrays.asList(joinPoint.getArgs()).stream().map(object->object.toString()).collect(Collectors.joining(","));
			
			//Log into database or do something
			logger.info("Executing After Throwing Exception on  method Name => " + methodName + " arguments =>" + args);
			logger.error("Interceptor Exception" + exception.getMessage());
		}
	 
		 	
	 
	 @AfterReturning(pointcut = "execution(* com.imarticus.tutorial.controllers.BookController.*(..))", returning = "result")	 
	 public void afterSuccessfulReturnOnBookControllerMethods(JoinPoint joinPoint, Object result) {
			
			String methodName =joinPoint.getSignature().getName();
					
			String args = Arrays.asList(joinPoint.getArgs()).stream().map(object->object.toString()).collect(Collectors.joining(","));
		
			
			logger.info("Executing After Returning value on  method Name => " + methodName + " arguments =>" + args);
			logger.info("Returned value " + result.toString());
	 }
	 
}