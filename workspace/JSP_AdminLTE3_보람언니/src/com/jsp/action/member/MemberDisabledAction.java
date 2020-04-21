package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberDisabledAction implements Action {

	private MemberService memberService = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
					memberService.disabledMember(id);
				} catch (SQLException e) {
					e.printStackTrace();
					url = "error/disabled_fail";
				}
			}
			
		return url;
	}

}
