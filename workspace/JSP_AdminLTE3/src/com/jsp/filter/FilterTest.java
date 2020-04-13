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


//@WebFilter("/*")// request가 올 때 마다 무조건 잡을거란 뜻.(/*)// 어노테이션주석하면 등록안된다.
public class FilterTest implements Filter {
	// 서블릿(extends) 와 다르게 필터는 (implements) 여서 메서드를 삭제하면 안돼.

	
	public void destroy() {
		// 컨텍스트 배포가 중지되거나, 톰캣이 종료될때 이 인스턴스를 버릴때 실행되는 메서드.
		System.out.println("Filter : destory()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// httprequest 는 http프로토콜로 요청이들어올때를 의미.
		// 얘는 무조건 이 contextpath로 요청이들어올때 를 말함.
		// 따라서 메서드구분(get, post ) 이 필요없다.
		
		HttpServletRequest httpReq = (HttpServletRequest) request; // uri를 보려고 강제 형변환함.
		System.out.println("Filter : doFilter() : " + httpReq.getRequestURI());
		
		chain.doFilter(request, response);
		// chain.doFilter(httpReq, response);
		// 필터에서 거르고 뒤에 있는 필터로 넘길때 쓰이는 것. 마지막필터에서 chain.dofilter를 하면
		// 서블릿으로 넘어가게 됨. forward와 같음. 어디로넘기는지몰라도 넘기기만하면된다. 톰캣이 알아서넘겨줌.
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 최초배포 후 최초 요청시 실행.
		System.out.println("Filter : init()");

		// 
	}

}
