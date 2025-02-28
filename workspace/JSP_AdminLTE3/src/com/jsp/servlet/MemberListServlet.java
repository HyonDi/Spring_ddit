package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;


//@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이징하는게 이해가 안되면 listener 를 먼저 공부하렴.
		
		
		String url = "member/list";// 그냥 list로 쓰면 안되는것??
		
		
		SearchCriteria cri = new SearchCriteria();
		
		try {
			int page = Integer.parseInt(request.getParameter("page"));// 어디서나온애들??
			int perPageNum = Integer.parseInt(request.getParameter("perPageNum"));
			cri.setPage(page);
			cri.setPerPageNum(perPageNum);
			
		} catch(NumberFormatException e) {
			System.out.println("페이지 번호가 누락으로 기본 1페이지로 세팅됩니다.");
		}
		
		String searchType = request.getParameter("searchType");// 어떻게가져오는거야
		String keyword = request.getParameter("keyword");
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		MemberService service = MemberServiceImpl.getInstance();
		
		try {
			
			Map<String, Object> dataMap = service.getMemberList(cri);
			
			request.setAttribute("memberList", dataMap.get("memberList"));// 이건어떻게가져오는거야
			request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		ViewResolver.view(request, response, url);
		
//		String url="member/list";//forward 입니다. 왜냐면 request를 가져가야하기때문에.
//		
//		
//	 	// 필터로 보냅니다. 서블릿마다 작성해야하는내용.(리퀘스트올때마다 작성해야하는 내용.)
//	 	/* HttpSession session = request.getSession();
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
//		if(loginUser == null) { // 세션이 없으면 다시 로그인페이지로 이동한다.
//			
//			url="redirect:/commons/login"; // redirect로 이동함. (세션이 끊겨서 가져갈 리퀘스트가 없기때문.)
//			
//			ViewResolver.view(request, response, url);
//			
//			return;
//		}*/
//		//-- 요기까지 필터로
//		
//		try {
//			/*List<MemberVO> memberList = MemberServiceImpl.getInstance().getMemberList();
//			
//			request.setAttribute("memberList", memberList); // 에러가 안나서 List를 심음.*/			
//			
//			Map<String,Object> dataMap = 
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//			url="error/500_error";
//			request.setAttribute("exception", e); // 에러가 터져서 에러를 심음.
//		}
//		
//		ViewResolver.view(request, response, url);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // 요거로 인해서 이 서블릿은 get과 post를 구분하지 않고 모두 get으로 한다.
		// 이유는 처리할게 없기때문! 리스트만 보여주는거니까!
	}

}
