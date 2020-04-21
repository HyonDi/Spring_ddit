package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberServiceImpl;
/**
 * 상세 정보 확인 서블릿 (화면만 보여주는거라 doGet 사용)
 *
 */
//@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면 결정
		String url = "member/detail";
		
		//파라미터 처리
		String id = request.getParameter("id");
		
		//서비스 요청 -> 결과
		//결과에 따른 화면 분할
		MemberVO member = null;
		try {
			member = MemberServiceImpl.getInstance().getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
		}
		
		request.setAttribute("member", member);
		
		//화면 요청
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
