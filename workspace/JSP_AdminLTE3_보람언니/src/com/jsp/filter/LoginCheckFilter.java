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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;

//web.xml에 등록할거라 어노테이션 지움
public class LoginCheckFilter implements Filter {

	//로그인 체크를 제외시킬 url들을 담을 list
	private List<String> exURLs = new ArrayList<String>();
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("doFilter()");
		
		//브라우저의 request, response가 필요해서 HttpServlet 사용 (uri,session필요)
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		//로그인체크를 제외할 url 확인
		String reqUrl = httpReq.getRequestURI().substring(httpReq.getContextPath().length());
		
		//excludeCheck() : 요청이 들어온 url(reqUrl)이 로그인체크를 제외할 url이 맞는지 확인하는 메소드 (여기서 전역변수 사용)
		if(excludeCheck(reqUrl)) {
			//excludeCheck()에서 받은 값이 true면 다음 filter로 넘어간다
			chain.doFilter(request, response);
			return;
		}
		
		//제외할 url이 아닌 경우 session 확인
		HttpSession session = httpReq.getSession();
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		//login 확인
		if(loginUser==null) {
			//메시지를 띄우려면 jsp로 forward해야함.
			//새 창으로 작업중이었을때인지 부모창에서 작업중이었는지 알 수 없기때문에 어떻게 화면 전환할지 결정권을 jsp에게 넘긴다
			String url = "commons/loginCheck";
			/*if(reqUrl.equals("/")) {
				url = "redirect:/commons/login";
			}*/
			//httpReq, httpResp : ViewResolver가 사용하는게 Http라서 이걸로 보냄
			ViewResolver.view(httpReq, httpResp, url);
		}else {
			chain.doFilter(request, response);
		}
	}

	//doFilter는 init의 존재를 몰라ㅠㅠㅠㅠ 그래서 전역변수에 값을 넣어줘야함.
	//init -> doFilter 순서로 메서드가 실행됨
	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("FilterInit()");
		
		//web.xml에 설정한 exclude의 param을 가져온다
		String excludeURLNames = fConfig.getInitParameter("exclude");
		
		//param이 ','로 나뉘어져있기 때문에 tokenizer 사용해서 구분자 사용
		StringTokenizer st = new StringTokenizer(excludeURLNames, ",");
		
		while(st.hasMoreElements()) { //구분자를 제외하고 값을 꺼낸다(StringTokenizer()에서 false를 주고 hasMoreTokens()를 사용한 것과 같다) -> true를 써서 ','까지 뽑아낸다해도 hasMoreElements를 쓰면 쉼표가 잘리겠지?
			//전역변수인 exURLs list에 로그인체크를 제외할 url 넣기
			exURLs.add(st.nextToken());
		}
	}

	private boolean excludeCheck(String url) {
		//exURLs : 전역변수(로그인체크를 제외할 url이 들어있는 list)
		for(String exURL : exURLs) {
			if(url.contains(exURL)) { //요청받은 url과 로그인체크를 제외할 url이 일치하는 경우
				return true;
			}
		}
		return false; //요청받은 url과 로그인체크를 제외할 url이 일치하지 않는 경우
	}
}
