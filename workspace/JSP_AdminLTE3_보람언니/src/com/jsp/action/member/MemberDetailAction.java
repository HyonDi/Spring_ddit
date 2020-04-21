package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberDetailAction implements Action {

	private MemberService memberService = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//화면 결정
		String url = "member/detail";
		
		//파라미터 처리
		String id = request.getParameter("id");
		
		//서비스 요청 -> 결과
		//결과에 따른 화면 분할
		MemberVO member = null;
		try {
			member = memberService.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
		}
		
		request.setAttribute("member", member);
		
		return url;
	}

}
