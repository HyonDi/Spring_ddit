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
import com.jsp.utils.ViewResolver;


@WebServlet("/member/disabled")
public class MemberDisabledServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		String id = request.getParameter("id");
		String url = "member/disabled_success";
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser.getId().equals(id)) { // 로그인한 사람 id 같을 시.
			
			url="member/disabled_denied";
		}else {
			
			try {
				MemberServiceImpl.getInstance().disabledMember(id);
			} catch (SQLException e) {
				e.printStackTrace();
				url = "member/disabled_fail";
			}
		}
		
		
		ViewResolver.view(request, response, url);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
