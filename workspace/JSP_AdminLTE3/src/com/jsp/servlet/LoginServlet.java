package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

@WebServlet("/commons/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() execute!");
	}


	public void destroy() {
		System.out.println("destroy() execute!");
	}


	
	// do로 시작하는 애들은 사용자의 요청이 있을 때 마다 실행된다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet() execute!");
		
		String url = "/WEB-INF/views/commons/loginForm.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost() execute!");
		
		// redirect 로 간다!! (왜냐면 request를 끊어야해.) - viewresolver.java에서 
		/*String url = "redirect:/main";*/		
		String url = "redirect:/member/list";
		
		// main서블릿 만든다.
		
		// 파라미터 받는다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 로그인처리-- 이게 어떻게한건데?? request.getSession에 값이 어떻게 들어있어??
		// 값을 넣는 과정이아님! HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로 세션을 생성합니다.
		HttpSession session = request.getSession();
		
		try {
			MemberServiceImpl.getInstance().login(id, pwd);
			
			// membervo 가져오기
			MemberVO loginUser = MemberServiceImpl.getInstance().getMember(id);
			// 세션에 집어넣는다.
			session.setAttribute("loginUser", loginUser);
			
			// 6분간 세션 유지. 6분간 request 가 없으면 날아간다.
			session.setMaxInactiveInterval(10);
			
		} catch (SQLException e) { // db 터질때
			//e.printStackTrace();
			url = "error/500_error"; // forward이다.
			request.setAttribute("exception", e);
		} catch (NotFoundIDException | InvalidPasswordException e) { // 아이디 없을때 | 비밀번호 틀렸을 때.
			//e.printStackTrace();
			url = "commons/loginForm"; // forward
			request.setAttribute("msg", e.getMessage());
		}
		
		ViewResolver.view(request, response, url);
	}

}
