package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/commons/login")
public class LoginServlet extends HttpServlet {
   
	/*public void init(ServletConfig config) throws ServletException {
		System.out.println("init() execute!");
	}

	public void destroy() {
		System.out.println("destroy() execute!");
	}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/commons/loginForm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 성공한 경우 redirect
		String url = "redirect:/member/list";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		try {
			MemberServiceImpl.getInstance().login(id, pwd);
			
			MemberVO loginUser = MemberServiceImpl.getInstance().getMember(id);
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(60*6);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
			request.setAttribute("exception", e);
		} catch (NotFoundIDException | InvalidPasswordException e) {
			e.printStackTrace();
			url = "commons/loginForm";
			request.setAttribute("msg", e.getMessage());
		}
		
		//ViewResolver는 외부에서 값을 받아 쓰기때문에 인스턴스를 생성하지 않고 사용. (static method)
		ViewResolver.view(request, response, url);
	}

}
