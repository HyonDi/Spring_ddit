package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")// index.jsp 있었을때랑 똑같이 그냥 localhost만쳐도 여기로올것임.
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// jsp를 꺼내서 보여주면서 request를 보내줌.(http://localhost/?msg=hyeonji 했을 때 msg가 넘어감.)
		//request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		
		// redirect는 무조건 get방식이야.(http://localhost/?msg=hyeonji 했을 때 msg가 넘어가지않음.)
		response.sendRedirect("login.html");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
