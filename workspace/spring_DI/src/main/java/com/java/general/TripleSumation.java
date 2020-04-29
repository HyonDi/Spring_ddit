package com.java.general;

public class TripleSumation extends Sumation {
	
	private int c;

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	@Override
	public int sum() {
		int result = super.sum() + c;
		return result;
	}
	
}
