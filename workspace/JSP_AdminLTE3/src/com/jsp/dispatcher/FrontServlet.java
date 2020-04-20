package com.jsp.dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;


public class FrontServlet extends HttpServlet {
	
	// doGet, doPost 모두 요청을 받으면 requestPro()를 호출하고 끝.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	

	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자가요청하는 url 이 뭔지알아야함.
		
		// property key
		
		// 2. action받아서 실행(excute()) : view를 return.
		
		// 3. 화면 url(View)받아서 viewresolver준다.
		
		String command = request.getRequestURI(); // contextPath  포함.
		
		if(command.indexOf(request.getContextPath()) == 0) { // contextPath 삭제
			command = command.substring(request.getContextPath().length());
		}
		
		Action act = null;
		String view = null;
		
		act = HandlerMapper.getAction(command);
		
		if(act == null) {
			System.out.println("!! not found : " + command);
			// throw new PageNotFoundException();
		} else {
			view = act.execute(request, response);
			
			if(view != null)
				ViewResolver.view(request, response, view);
		}
	}
}
