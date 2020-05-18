package com.groupware.security;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.groupware.dto.EmployeeVO;
import com.groupware.service.employee.EmployeeService;

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
		 
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/groupware/context/root-context.xml");
		
		EmployeeService service = (EmployeeService) ctx.getBean("employeeService");
		
		String id = authentication.getName();
		
		try {
			EmployeeVO loginUser = (EmployeeVO) service.getEmployee(id).get("employee");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		super.onAuthenticationSuccess(request, response, authentication);// "하던데로 하렴." 하는것. 
		
	}
	
	
}
