package com.jsp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	// servlet 과 이름만다른형태의 메서드.
	public String execute(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException;
	
}
