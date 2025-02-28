package com.jsp.action.commons;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class LoginAction implements Action {

	private MemberService memberService = MemberServiceImpl.getInstance();
	/**
	 * 초기화 : 인스턴스 생성시에 한번 실행
	 * set메소드 : 인스턴스 생성 후에 무언가를 변경하기 위해 사용
	 */
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//로그인 성공한 경우 redirect
		String url = "redirect:/member/list.do";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		try {
			memberService.login(id, pwd);
			
			MemberVO loginUser = memberService.getMember(id);
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(60*6);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
			request.setAttribute("exception", e);
		} catch (NotFoundIDException | InvalidPasswordException e) {
			e.printStackTrace();
			url = "redirect:/commons/loginForm.do";
			request.setAttribute("msg", e.getMessage());
		}
		return url;
	}

}
