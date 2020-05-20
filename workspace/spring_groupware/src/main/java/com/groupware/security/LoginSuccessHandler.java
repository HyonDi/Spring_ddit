package com.groupware.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.groupware.dto.EmployeeVO;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	
/*	이렇게 하는것 주입안됨.
	EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
*/
	// 따라서 고의적으로 context Loading해야한다.filter가 container를 가져오도록 해야한다.(만들어져있는 container말고)
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		 
		
		/*ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/groupware/context/root-context.xml");
		
		EmployeeService service = (EmployeeService) ctx.getBean("employeeService");
		
		String id = authentication.getName();
		
		try {
			EmployeeVO loginUser = (EmployeeVO) service.getEmployee(id).get("employee");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
		} catch(SQLException e) {
			e.printStackTrace();
		}*/

		
		
		/* 새로운 방법!-새 provider */
		// authentication 갖다준다. 로그인성공한. UserDetail안에 loginUser(getmember로) 뽑음.
		User user = (User)authentication.getDetails();
		EmployeeVO loginUser = user.getMemberVO();
		
		// session에 넣음.
		HttpSession session = request.getSession();
		
		session.setAttribute("loginUser", loginUser);
		// 30분이상은 줘도 소용없다. 30분이후엔 tomcat이 날림.
		session.setMaxInactiveInterval(20*15); //second
		
		// 빈컨트롤러만들어서.. ajax로 시간마다 날리라고??
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(!user.isAccountNonLocked()) {
			out.println("<script>");
			out.println("alert('휴직상태로 권한이 일반사용자로 제한됩니다.');");
			out.println("location.href='/" + request.getContextPath() + "';");
			out.println("</script>");
		}else {
			super.onAuthenticationSuccess(request, response, authentication);// "하던데로 하렴." 하는것. 
		}
		
	}
	
	
}
