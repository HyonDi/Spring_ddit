package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberServiceImpl;

/**
 * Servlet implementation class CheckPassworldServlet
 */
//@WebServlet("/member/checkPassword")// 원서블릿으로만들기위해 url다지웠습니다.
public class CheckPassworldServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면결정
		
		// 파라미터받기
		String result = null;
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		System.out.println("pwd : " + pwd);
		System.out.println("loginUser.getPwd() : " + loginUser.getPwd());
		
		if(pwd.equals(loginUser.getPwd())) {
			
			result="SUCCESS";
		}else {
			result="FAIL";
		}
		
		response.getWriter().print(result);
		
	/*	String id = loginUser.getId();
		
		MemberVO member = null;
		
		// 서비스호출
		try {
			member = MemberServiceImpl.getInstance().getMember(id);
			request.setAttribute("data", "SUCCESS");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("data", "ERROR");
		}
		*/
		// 화면분할
		// 화면요청
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
