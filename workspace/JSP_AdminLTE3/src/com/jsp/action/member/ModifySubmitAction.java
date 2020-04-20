package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.MemberRegistRequest;
import com.jsp.service.MemberServiceImpl;

public class ModifySubmitAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 역할 : 가입처리 시키기.(redirect 해야하는데 이렇게안하고 윈도우 닫고(request죽음.) reload할것임.)
		// 그렇다면 여기에는 doGet실행시키는 메서드가 필요 없는가???
		// doGet(request, response);
		
		response.setCharacterEncoding("utf-8");
		
		// 성공시 갈 곳.
		String url="member/modify_success"; // .jsp 적으면 안됨!
		
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
			MemberServiceImpl.getInstance().modify(member);
		} catch (SQLException e) {
			e.printStackTrace();
			// 실패시!!
			url = "member/modify_cancel";
		}
		
		return url;
	}

}
