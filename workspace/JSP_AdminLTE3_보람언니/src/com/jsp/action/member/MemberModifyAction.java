package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.MemberRegistRequest;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberModifyAction implements Action {

	private MemberService memberService = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "member/modify_success";
		//String result = null;
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
		String[] phone = request.getParameterValues("phone");
		String authority = request.getParameter("authority");
		String name = request.getParameter("name");
		
		MemberRegistRequest memberReq = new MemberRegistRequest(id, pwd, authority, email, phone, picture, name);
		
		MemberVO member = memberReq.toMemberVO();
		
		try {
			memberService.modify(member);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "member/modify_fail";
			//업로드 파일 삭제하기
		}
		
		return url;
	}

}
