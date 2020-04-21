package com.jsp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//("/*") : request가 올때마다 모든 것에 적용한다는 뜻
//@WebFilter("/*")
public class FilterTest implements Filter {

	//톰캣이 종료될때 이 instance를 버릴때 실행되는 destroy
	public void destroy() {
		System.out.println("Filter : destroy()");
	}

	//Get이건 Post이건 상관없이 요청을 받는다
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		
		System.out.println("Filter : doFilter() : " + httpReq.getRequestURI());
		
		//다음 Filter로 인계하는 메서드(forward 개념이라 request와 response를 넘김)
		chain.doFilter(request, response);
	}

	//최초로 로딩될때 딱 한번 실행
	//loginCheck가 필요하지 않은 곳이 드물기 때문에 그걸 거른다
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter : init()");
	}

}
