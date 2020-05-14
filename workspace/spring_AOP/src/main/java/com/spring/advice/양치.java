package com.spring.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class 양치 {
	// 얘도 application-context에 bean등록해야함.
	
	// advice : 언제할건지 정해야해서 joinpoint를 받아야함.
	
	
	// 이방법은 잘 안쓴다.(chickachikaProceed) 아래가더좋음.
	public void chikachikaProceed(ProceedingJoinPoint joinPoint) throws Throwable{
							// joinPoint가 되어있는 Proceed.
		
		Object result = joinPoint.proceed();// Point cut 대상.
		// joinPoint 줄 필요없음. 내부에 proceed에대한 정보가 있음.
		
		System.out.println("양치하기");// 위를 하고나서 할 행동.
	}
	
	
	public void chikachika(JoinPoint joinPoint) throws Throwable{
		// proceed가 없어서 외부에서 joinpoint 줘야함 전/후 중 언제할것인지.
		
		System.out.println("양치하기");
		
		
	}
	
	
}
