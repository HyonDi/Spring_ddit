package com.groupware.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler{
// extends 를 해줘야 handler인지 알 수 있다.

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		// request.setAttribute("msg", exception.getMessage());
		// request에 심는다. = forward로 간다.
		
		//임시
		request.setAttribute("msg", "아이디 혹은 패스워드가 일치하지 않습니다.");
		
		super.onAuthenticationFailure(request, response, exception);
	}
	
	
}
