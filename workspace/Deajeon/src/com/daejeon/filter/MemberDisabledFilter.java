package com.daejeon.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daejeon.dispatcher.ViewResolver;
import com.daejeon.dto.MemberVO;



public class MemberDisabledFilter implements Filter {
	
	private ViewResolver viewResolver;
	
	private List<String> checkURLs=new ArrayList<String>();
	

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response; 
		

		String uri = httpReq.getRequestURI();
		
		MemberVO loginUser = (MemberVO)httpReq.getSession().getAttribute("loginUser");
		
		boolean check = loginUser!=null && loginUser.getEnabled()!=1;
		System.out.println("check : " + check);
		
		if(loginUser!=null && loginUser.getEnabled()!=1) {// 비활성화된 상태 - true
			for(String url : checkURLs) {
				
				System.out.println("uri.contains(url) : " + uri.contains(url));
				
				if(uri.contains(url)) {					
					System.out.println("uri : " + uri);
					System.out.println("url : " + url);
					url="commons/checkDisabled";
					
					viewResolver.view(httpReq, httpResp, url);
					return;
				}
				request.setAttribute("url", url);
			}
			chain.doFilter(request, response);
		}else {
			chain.doFilter(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
		String paramValue = fConfig.getInitParameter("checkURL");
		StringTokenizer st = new StringTokenizer(paramValue,",");
		
		while(st.hasMoreTokens()) {
			String urlkey = st.nextToken();
			checkURLs.add(urlkey);
		}
		
		
		
		String viewResolverType = fConfig.getInitParameter("viewResolver");
		try {
			Class<?> cls = Class.forName(viewResolverType);
			this.viewResolver = (ViewResolver) cls.newInstance();
			System.out.println("O[MemberDisabledFilter]" + viewResolver + "가 준비되었습니다.");
				
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("X[MemberDisabledFilter]" + viewResolver + "가 준비되지 않았습니다.");
		}
		
	}
	
}
