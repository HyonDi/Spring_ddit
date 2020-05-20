package com.groupware.security;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;

import com.groupware.dto.EmployeeVO;
import com.groupware.service.employee.EmployeeService;

public class SessionDestroyListener implements ApplicationListener<SessionDestroyedEvent> {
	// 세션 만료 혹은 expired됐을 때 다음 로그인시 최근접속날짜? 뜨는거 변경되게하기위함. (tomcat session이랑 security랑 연동시키기위함.)

	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		// logoutSuccessHandler에있던 내용.
		// loginSuceesHandler 도 새로운provider에 맞게 수정시켜야한다.
		List<SecurityContext> contexts = event.getSecurityContexts();
		if(!contexts.isEmpty()) {
			for(SecurityContext ctx : contexts) {
				Authentication auth = ctx.getAuthentication();
				
				if(auth != null && auth.getDetails() != null) {
					try {
						User user = (User)auth.getDetails();
						EmployeeVO loginUser = user.getMemberVO();
						
						employeeService.recentLoginTime(loginUser.getId());
						
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}

	
	
}
