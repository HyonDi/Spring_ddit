package com.daejeon.dispatcher;

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

	public void view(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException{
		
		if(url == null) {return;}

		if(url.indexOf("redirect:") > -1) {
			
			url = request.getContextPath() + url.replace("redirect:", "");
			response.sendRedirect(url);
			
		}else {
			
			String prefix="/WEB-INF/views/";
			String subfix=".jsp";
			url=prefix+url+subfix;
			request.getRequestDispatcher(url).forward(request, response);
		}
		

	}
}
