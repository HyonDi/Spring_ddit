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


/*@WebFilter("/MemberDisabledFilter") 왜 지우냐면 우리는 web.xml로 통일시키기로함.*/
public class MemberDisabledFilter implements Filter {
	
	private ViewResolver viewResolver;
	
	private List<String> checkURLs=new ArrayList<String>();// 이 파일안에서만사용하니까 게터세터필요없음.
	
	//private Set<String> checkURLs=new HashSet<String>(); //set으로사용하는 경우도 있다.
	// 들어오는 uri가 고정적이지않아서 떼어내는부분이 수고스러워 이렇게하지않음. 딱 키워드만 들어올때는 set이좋다.
	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 강제형변환 문제되지 않는다.
		HttpServletRequest httpReq = (HttpServletRequest) request; // uri를 보려고 강제 형변환함.
		HttpServletResponse httpResp = (HttpServletResponse) response; 
		
		// 제외할 url확인
		//String reqUrl = httpReq.getRequestURI().substring(httpReq.getContextPath().length());// contextPath제외하고 뒷부분만 잘라본다.
		
		// uri 받아옴
		String uri = httpReq.getRequestURI();
		
		// 세션가져와서 로그인유저를 꺼내본다.
		MemberVO loginUser = (MemberVO)httpReq.getSession().getAttribute("loginUser");
		
		boolean check = loginUser!=null && loginUser.getEnabled()!=1;
		System.out.println("check : " + check);
		
		if(loginUser!=null && loginUser.getEnabled()!=1) {// 비활성화된 상태 - true
			for(String url : checkURLs) {
				
				System.out.println("uri.contains(url) : " + uri.contains(url));
				
				if(uri.contains(url)) {					// uri에 url이 있으면 필터링해야함.
					System.out.println("uri : " + uri);
					System.out.println("url : " + url);
					url="commons/checkDisabled";
					
					viewResolver.view(httpReq, httpResp, url);
					return;
				}
				request.setAttribute("url", url);//??
			}
			chain.doFilter(request, response);
		}else {// 활성화된회원
			chain.doFilter(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
		String paramValue = fConfig.getInitParameter("checkURL");
		StringTokenizer st = new StringTokenizer(paramValue,",");// 여기에 콤마찍고 true하나 더 넣으면 구분자까지 잘라준다.
		// iterator개념.
		
		while(st.hasMoreTokens()) {
			String urlkey = st.nextToken();
			checkURLs.add(urlkey);
		}
		
		
		
		// view Resolver
		String viewResolverType = fConfig.getInitParameter("viewResolver");
		try {
			Class<?> cls = Class.forName(viewResolverType);
			this.viewResolver = (ViewResolver) cls.newInstance();
			System.out.println("[MemberDisabledFilter]" + viewResolver + "가 준비되었습니다.");
				
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[MemberDisabledFilter]" + viewResolver + "가 준비되지 않았습니다.");
		}
		
	}
	
}
