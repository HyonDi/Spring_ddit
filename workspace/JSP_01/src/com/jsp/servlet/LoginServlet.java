package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.AddressingFeature.Responses;

import javafx.scene.control.Alert;


//@WebServlet("/login.html") // 선언자. 선언역할을합니다. 기준. web.xml에 매핑시켰기때문에 주석처리했음.
public class LoginServlet extends HttpServlet {
	// extends HttpServlet 붙여야 서블릿인줄 안다.
	
	@Override// 부모한테 없는 메서드면 오버라이드 붙일 수 없음!! (doGet메서드의 이름을 바꾸면 에러발생)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// html코드로 읽게한다. + 인코딩
		response.setContentType("text/html;charset=utf-8");
		
		// request를 보낸쪽에 outputStream하는것..
		PrintWriter out = response.getWriter();
		
		//System.out.println("doGet() execute!!"); // 시스템에 출력.
		//out.println("doGet() execute!!"); // 사용자에게 출력.
		
		/*//jsp 만들었음.loginform.jsp
		out.println("<DOCTYPE!>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("로그인 페이지");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"login.html\" method=\"post\" >");
		out.println("아이디 :  <input type=\"text\" name=\"id\" /><br/>");
		out.println("패스워드 : <input type=\"password\" name=\"pwd\" /><br/>");
		out.println("<input type=\"submit\" value=\"로그인\" />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");*/
		
		// forward로 jsp로이동한다. dispatcher : 총괄자. 
		request.getRequestDispatcher("/WEB-INF/views/loginForm.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 밑에거를 안주면 부모거 오버라이드할때 처음부터 끝까지 처음부터다시만드는 것.
		// 이게있으면 부모거쓰던거에 수정할부분만 고치는 것. 수정할부분이 안서있으면 하던데로 하라는 의미.
		// super.doGet(request, response);
		
		// 아래는 get이건 post건 구분하지 않겠다는 의미.
		// doGet(request, response);
		
		// System.out.println("doPost() execute!!");
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		// MemberVO member = memberService.getMember(id);
		
		request.getRequestDispatcher("login_success.jsp").forward(request, response);
		
		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('로그인 성공입니다.')");
		out.println("location.href='https://www.naver.com';");
		// location으로 주소줄바꾸면 이전의 request는 사라진다. = 새로고침해도 계속네이버. = redirect???
		out.println("</script>");*/
		
		
	}

}
