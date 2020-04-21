package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberServiceImpl;

//@WebServlet("/member/disabled")
public class MemberDisabledServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/disabled_success";
		
		String id = request.getParameter("id");
		
			//로그인한 사람인지 확인한다
			HttpSession session = request.getSession();
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			session.setAttribute("loginUser", loginUser);
			
			if(id.equals(loginUser.getId())) { //로그인한 사용자일 경우 불허함.
				url = "member/disabled_denied";
			}else {
				try {
					MemberServiceImpl.getInstance().disabledMember(id);
				} catch (SQLException e) {
					e.printStackTrace();
					url = "error/disabled_fail";
				}
			}
		
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
