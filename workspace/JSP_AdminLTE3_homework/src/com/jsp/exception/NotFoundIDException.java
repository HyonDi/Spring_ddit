package com.jsp.exception;

public class NotFoundIDException extends Exception {

	public NotFoundIDException() {
		super("존재하지 않는 아이디 입니다.");
		// get 메서드로 파라미터로 넘긴 String을 부를 수 있음.
	}
}
