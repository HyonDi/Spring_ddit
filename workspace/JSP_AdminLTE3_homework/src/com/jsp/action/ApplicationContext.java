package com.jsp.action;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
	private static Map<String, Object> applicationContext = new HashMap<String, Object>();
	
	private ApplicationContext() {}
	
	public static Map<String, Object> getApplicationContext() {
		return applicationContext;
	}
	// board dao 에 boaddao 인스턴스
	// service 에 service인스턴스 이런식으로만들기위함. 이거 조립하는건 listener.
}
