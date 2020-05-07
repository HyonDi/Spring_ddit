package com.spring.filter;

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
import javax.servlet.http.HttpSession;

import com.spring.dto.MemberVO;


// @WebFilter("/LoginCheckFilter") web.xml에 등록할거야
public class LoginCheckFilter implements Filter {
//	private ViewResolver viewResolver;
	
	private List<String> exURLs=new ArrayList<String>(); 
	// 전역변수로 선언! init이 실행되며 이 속에 값을 넣어줄것이고, dofilter를 실행하기전 요청온 url이 exurls에 들어있는지 체크 한 후
	// exurl에 들어있다면 필터링을 하지 않을것이다.
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 강제형변환 문제되지 않는다.
		HttpServletRequest httpReq = (HttpServletRequest) request; // uri를 보려고 강제 형변환함.
		HttpServletResponse httpResp = (HttpServletResponse) response; 
		
		// 제외할 url확인
		String reqUrl = httpReq.getRequestURI().substring(httpReq.getContextPath().length());// contextPath제외하고 뒷부분만 잘라본다.
		
		if(excludeCheck(reqUrl)) {// reqUrl이  excludeurl중 하나라도 포함이 되는지 체크. 포함이 되면 여기서 return함.
			chain.doFilter(request, response);
			// 요기 null
			
			return;
		}
		
		// 세션가져와서 로그인유저를 꺼내본다.
		HttpSession session = httpReq.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		
		// login 확인(null check)
		if(loginUser==null) { //  비 로그인 상태
			
			String url="commons/loginCheck";
			
			if(reqUrl.equals("/")) {
				url = "loginForm.do";
				httpResp.sendRedirect(url);
			}//???????????????????????????????????????????????????????????????????????????
			
			//ViewResolver.view(httpReq, httpResp, url);// 주의!httpReq, httpResp 가 파라미터임!!!!
//			viewResolver.view(httpReq, httpResp, url);
			// initparam 에 심어야한다.
		}else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// web.xml에 있는 내용을 가져올 수 있다.
		
		//-<init-param>
		//-<param-name>exclude</param-name>
		//-<param-value>resources,commons,.jsp</param-value>
		//-</init-param>
		// 요것.
		
		
		String excludeURLNames=fConfig.getInitParameter("exclude");
		// getinitParam 으로 <param-name> 을 적으면 <param-value> 들이 String으로 줄줄가져와진다.
		StringTokenizer st = new StringTokenizer(excludeURLNames,",");// ,을 구분자로 나눠서
		while(st.hasMoreTokens()) {
			// hasmoretoken 은 delimiter를 포함한것.(뒤에 true를 안주면 token이나 elements나 똑같음.)
			// hasMoreElements 은 delimiter 를 제외한것.
			exURLs.add(st.nextToken());// 전역변수인 List exURLs 속에 집어넣어둔다.
		}
		System.out.println(exURLs);
		
		
		
		
//		// view Resolver
//		String viewResolverType = fConfig.getInitParameter("viewResolver");
//		try {
//			Class<?> cls = Class.forName(viewResolverType);
//			this.viewResolver = (ViewResolver) cls.newInstance();
//			System.out.println("[LoginCheckFilter]" + viewResolver + "가 준비되었습니다.");
//				
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("[LoginCheckFilter]" + viewResolver + "가 준비되지 않았습니다.");
//		}
	}

	private boolean excludeCheck(String url) {
		for(String exURL:exURLs) {
			if(url.contains(exURL)) {
				return true;
			}
		}
		return false;
	}
	
	
}
