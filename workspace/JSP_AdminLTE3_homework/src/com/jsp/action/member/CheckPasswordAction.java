package com.jsp.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;

public class CheckPasswordAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 화면결정
		
		// 파라미터받기
		String result = null;
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		System.out.println("pwd : " + pwd);
		System.out.println("loginUser.getPwd() : " + loginUser.getPwd());
		
		if(pwd.equals(loginUser.getPwd())) {
			
			result="SUCCESS";
		}else {
			result="FAIL";
		}
		
		response.getWriter().print(result);
		
		return null;
		
	/*	String id = loginUser.getId();
		
		MemberVO member = null;
		
		// 서비스호출
		try {
			member = MemberServiceImpl.getInstance().getMember(id);
			request.setAttribute("data", "SUCCESS");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("data", "ERROR");
		}
		*/
		// 화면분할
		// 화면요청
	}

}
