package com.java.general;

public class UpdateCalculator extends Calculator{
	
	// new 로계속 초기화할것이 아니라 주입을받아 결합도를 떨어뜨려야한다.
	private Sumation sumation;// = new Sumation();
	public void setSumation(Sumation sumation) {
		this.sumation = sumation;
	}
	// 부모쪽 sumation이 private이라 새로만들었음.(셋메서드랑 변수를)
	// 부모쪽에서 protected로 바꿔도된다.
	
	public void sum(int a, int b) {

		sumation.setA(a);
		sumation.setB(b);
		
		System.out.println("두 정수 " + a + ", "+b+" 의 합 은" + sumation.sum() + "일까요?");
	}
	
	public void sum(int a, int b, int c) {
		if(sumation instanceof TripleSumation) {
			((TripleSumation) sumation).setC(c);
			int result = sumation.sum();
			System.out.println("세 정수 " + a + ", "+b+ "," + c + " 의 합 은" + result + "인줄 알고 계십니까?");
		}else {
			System.out.println("함부로 세 정수 합을 하지마세요.");
		}
	}
	
}
