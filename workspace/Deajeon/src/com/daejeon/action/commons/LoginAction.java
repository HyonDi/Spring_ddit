package com.daejeon.action.commons;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daejeon.action.Action;
import com.daejeon.dto.MemberVO;
import com.daejeon.exception.InvalidPasswordException;
import com.daejeon.exception.NotFoundIDException;
import com.daejeon.service.MemberService;

public class LoginAction implements Action {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "redirect:/board/list.do";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		try {
			memberService.login(id, pwd);
			
			MemberVO loginUser = memberService.getMember(id);

			session.setAttribute("loginUser", loginUser);
			
			session.setMaxInactiveInterval(60*6);
			
		} catch (SQLException e) {
			url = "error/500_error";
			request.setAttribute("exception", e);
		} catch (NotFoundIDException | InvalidPasswordException e) {
			url = "redirect:/commons/loginForm.do";
			
			request.setAttribute("msg", e.getMessage());
		}
		
		return url;
	}

}
