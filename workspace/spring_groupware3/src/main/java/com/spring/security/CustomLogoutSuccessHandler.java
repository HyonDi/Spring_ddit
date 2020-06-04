package com.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.spring.dto.EmployeeVO;
import com.spring.service.employee.EmployeeService;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler{
	
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                             	Authentication authentication) throws IOException, ServletException {
        if (authentication != null && authentication.getDetails() != null) {
            try {
            	User user = (User)authentication.getDetails();        		
        		EmployeeVO loginUser = user.getMemberVO();
        		
        		employeeService.recentLoginTime(loginUser.getId());        		
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        response.sendRedirect(request.getContextPath()+"/commons/login");
    }
}