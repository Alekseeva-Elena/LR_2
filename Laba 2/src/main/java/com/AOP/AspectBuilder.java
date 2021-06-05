package com.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy     
public class AspectBuilder {
	//@Before("execution(* springhw.aopendtoendservices.*.*(..))")

	@Before("execution(* springhw.aopendtoendservices.*.*(..))")
	public void calcStartInfo(JoinPoint jp) {
	    System.out.println(""+jp.getSignature());
	}
	
}
