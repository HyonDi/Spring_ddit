package com.jsp.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * redirect/forward , url 로 화면 전환을 해결해주는 클래스 (컨트롤러가 사용할것임)
 * @author PC-16
 *
 */
public class ViewResolver {
	// 서블릿이 쓰던 request, response를 받아야한다.
	
	public static void view(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException{
		
		// url이아니면 하는일 없도록
		if(url == null) {return;}
		
		// 실제 url path : /WEB-INF/views/member/list.jsp
		// action 리턴 url : member/list
		
		
		// 'redirect :' 이 url에 있는지 확인. 있으면 지우고 해당 url로 redirect.
		if(url.indexOf("redirect:") > -1) {
			
			url = request.getContextPath() + url.replace("redirect:", "");
			response.sendRedirect(url);
			
		}else { // redirect없으면 forward로 이동.
			
			String prefix="/WEB-INF/views/";
			String subfix=".jsp";
			url=prefix+url+subfix;
			request.getRequestDispatcher(url).forward(request, response);
		}
		

	}
}
