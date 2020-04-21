package com.jsp.filter;

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

import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;

//@WebFilter("/MemberDisabledFilter")
public class MemberDisabledFilter implements Filter {

	//uri 값이 일정하면 set을 사용해도 좋지만 uri 뒤에 붙는 쿼리 스트링때문에 list로 결정
	private List<String> checkURLs = new ArrayList<String>();
		
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//막을 것 : 등록, 수정, 삭제, 활성화
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		
		String uri = httpReq.getRequestURI();
		
		//HttpSession session = httpReq.getSession();
		MemberVO loginUser = (MemberVO) httpReq.getSession().getAttribute("loginUser");

		//loginUser != null : 로그인체크 형이 로그인 화면에서는 체크를 안하기때문에 로그인화면 제외해야함
		if(loginUser != null && loginUser.getEnabled() != 1) {
			for(String url : checkURLs) {
				if(uri.contains(url)) { //url : 필터 먹일 주소 / uri : 사용자의 요청 주소 -> url이 uri에 포함되어있는가? 
					url = "commons/memberDisabled";
					ViewResolver.view(httpReq, httpRes, url);
					return;
				}
			}
		}

		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String paramValue = fConfig.getInitParameter("checkURL");
		
		StringTokenizer st = new StringTokenizer(paramValue, ",");
		
		while(st.hasMoreTokens()) {
			String urlkey = st.nextToken();
			checkURLs.add(urlkey);
		}
	}
	
}
