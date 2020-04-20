package com.jsp.action.commons;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class LoginAction implements Action {

	// 의존주입을 받기위해 작성함.
	private MemberService memberService = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	// set메서드는 인스턴스만든다음에 호출되기때문에 값을변경시킨다. 
	// 따라서 MemberServiceImpl.getInstance(); 해놓긴했지만 나중에 set으로 주입시켜서 쓸것임.
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 화면전환 X, 화면 url리턴. LoginServlet doPost내용 긁어왔다.
		
		
		
		
		
		System.out.println("doPost() execute!");
		
		// redirect 로 간다!! (왜냐면 request를 끊어야해.) - viewresolver.java에서 
		/*String url = "redirect:/main";*/		
		String url = "redirect:/member/list.do";
		
		// main서블릿 만든다.
		
		// 파라미터 받는다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 로그인처리-- 이게 어떻게한건데?? request.getSession에 값이 어떻게 들어있어??
		// 값을 넣는 과정이아님! HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로 세션을 생성합니다.
		HttpSession session = request.getSession();
		
		try {
			memberService.login(id, pwd); // 여기고침.MemberServiceImpl.getInstance() 를 memberService로 바꿈.
			
			// membervo 가져오기
			MemberVO loginUser = memberService.getMember(id); // 여기고침.MemberServiceImpl.getInstance() 를 memberService로 바꿈.
			// 세션에 집어넣는다.
			session.setAttribute("loginUser", loginUser);
			
			session.setMaxInactiveInterval(60*6);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			url = "error/500_error"; // forward //  forwod는 url이아임.jsp위지?
			request.setAttribute("exception", e);
		} catch (NotFoundIDException | InvalidPasswordException e) { // 아이디 없을때 | 비밀번호 틀렸을 때.
			//e.printStackTrace();
			url = "redirect:/commons/loginForm.do"; // jsp주소아님 = redirect. url이다.
			
			request.setAttribute("msg", e.getMessage());
		}
		
		
		//ViewResolver.view(request, response, url); -- 현재클래스는 화면전환하는애가아니어서 주석.
		return url;
	}
}


