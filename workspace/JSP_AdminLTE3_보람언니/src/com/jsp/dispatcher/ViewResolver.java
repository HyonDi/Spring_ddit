package com.jsp.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 해결사!!! (중복되는 url의 낭비를 해결하기위한 클래스)
 *
 */
public class ViewResolver {
	public static void view(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException{
		
		if(url == null) {return;}
		
		//실제 url path : /WEB-INF/views/member/list.jsp
		//action 리턴 url : member/list
		
		if(url.indexOf("redirect:") > -1) {
			url = request.getContextPath() + url.replace("redirect:", "");
			response.sendRedirect(url); //브라우저가 받음
		}else {
			String prefix = "/WEB-INF/views/";
			String subfix = ".jsp";
			url = prefix + url + subfix;
			request.getRequestDispatcher(url).forward(request, response); //servlet에서 받은 rq, rs forward하기
		}

			
	}
}
