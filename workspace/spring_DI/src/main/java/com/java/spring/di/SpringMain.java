package com.java.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.java.general.Calculator;

public class SpringMain {
	
	public static void main(String[] args) {
		
		// 스프링이만들어준 컨테이너.			xml을 읽어주는 아이. 읽을 xml을 파라미터로넣어준다.
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:application-context.xml");
												//=contextLoader. 만들어진건 context.
		
		// 리스너가 로더부름 (xml파일이랑.) > 컨텍스트가 컨테이너만든다. > 컨테이너가 조립????
		
		/*Calculator cal3 = (Calculator) ctx.getBean("calculator");// calculator 타입은모르고 이 이름
		Calculator cal2 = ctx.getBean(Calculator.class);// calcaulator 타입의 클래스*/
		Calculator cal = (Calculator) ctx.getBean("calculator",Calculator.class); // calculator타입의 이름 calculator
		
		
		cal.sum(3, 5);
		cal.sum(3, 5, 10);
		
		
	}
}
