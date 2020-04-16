package com.jsp.test;

public class Parent {
	
	
	private static Parent instance = new Parent();
	private Parent() {}
	public static Parent getInstance() {
		return instance;
	}
	
	private Child child;// new 를 하지않음! listenr 가 하게하려고!
	
	public void setChild(Child child) {
		this.child=child;
	}
	
	public String resultSum(int a, int b) throws Exception {
		String resultSum="";
		int result = child.sum(a, b);
		// child instance 안줘서 여기 null 뜬다!주입은 listener 에서 해줄것이다.
		
		resultSum = a + " 와 " + b + " 를 더한 결과는 " + result + "입니다.";
		
		return resultSum;
	}
}
