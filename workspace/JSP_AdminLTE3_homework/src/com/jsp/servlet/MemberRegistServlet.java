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
import com.jsp.request.MemberRegistRequest;
import com.jsp.service.MemberServiceImpl;


//@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 역할 : 등록화면보여주기.
		String url = "member/regist";// prefix, subfix로 url간결하게함.
		// ViewResolver를 통해서 보낼거기때문에 url줄여서 사용할 수 있음.
		
		ViewResolver.view(request, response, url); // 그..보내는거.... ViewResolver 로함...............................
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 역할 : 가입처리 시키기.(redirect 해야하는데 이렇게안하고 윈도우 닫고(request죽음.) reload할것임.)
		// 그렇다면 여기에는 doGet실행시키는 메서드가 필요 없는가???
		// doGet(request, response);
		
		// 성공시 갈 곳.
		String url="member/regist_success"; // .jsp 적으면 안됨!
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
		String[] phone = request.getParameterValues("phone");
		String authority = request.getParameter("authority");
		String name = request.getParameter("name");
		
		MemberRegistRequest memberReq = new MemberRegistRequest(id, pwd, authority, email, phone, picture, name);
		
		MemberVO member = memberReq.toMemberVO();
		
		// redirect/forward로 화면을 내보내야하는 애야. 그래서
		try {
			MemberServiceImpl.getInstance().regist(member);
		} catch (SQLException e) {
			e.printStackTrace();
			// 실패시!!
			url = "member/regist_fail";
		}
		
		ViewResolver.view(request, response, url);
		
		
	}

}
