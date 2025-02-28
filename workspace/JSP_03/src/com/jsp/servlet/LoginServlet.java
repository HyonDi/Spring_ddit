package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/common/loginForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="/WEB-INF/views/common/login_success.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 로그인 처리부..MemberVO member = mService.getMember(id);
		
		
		// 공백일 때.
		String msg = "";
		if(id.equals("")) {
			msg = "아이디를 입력해주세요.";
		}
		request.setAttribute("msg", msg);// 앞이 "" 이거속에넣고 뒤에가 변수명.
		
		
		// 로그인 실패
		if(!(id.equals("mimi")&&pwd.equals("mimi"))) {
			request.setAttribute("id", id);
			url="/WEB-INF/views/common/loginForm.jsp";
			    
		}else {
		
		
		// 로그인 성공
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setEmail("mimi@mimi.com");
		
		// 세션에 로그인유저 넣음.
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", member);
	
		}
		//response.sendRedirect("/main");
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	

}
