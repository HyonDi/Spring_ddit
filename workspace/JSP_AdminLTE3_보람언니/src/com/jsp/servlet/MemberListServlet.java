package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dispatcher.ViewResolver;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

//@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/list";
		
		SearchCriteria cri = new SearchCriteria();
		
		try {
			int page = Integer.parseInt(request.getParameter("page"));
			int perPageNum = Integer.parseInt(request.getParameter("perPageNum"));
			cri.setPage(page);
			cri.setPerPageNum(perPageNum);
		}catch(NumberFormatException e) { //처음 list 화면 불러올때 무조건 exception 터짐
			System.out.println("페이지 번호가 누락으로 기본 1페이지로 세팅됩니다.");
		}
		
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		MemberService service = MemberServiceImpl.getInstance();
		
		try {
		
			Map<String, Object> dataMap = service.getMemberList(cri);
			
			request.setAttribute("memberList", dataMap.get("memberList"));
			request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ViewResolver.view(request, response, url);
		
		/*String url = "member/list";
		
		//필터(리퀘스트 올때마다 하는것) - 필터 따로 만들어서 주석처리
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser == null) {
			url = "redirect:/commons/login";
			ViewResolver.view(request, response, url);
			return;
		}
		//
		
		try {
			List<MemberVO> memberList = MemberServiceImpl.getInstance().getMemberList();
			request.setAttribute("memberList", memberList);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
			request.setAttribute("exception", e);
		}
		
		ViewResolver.view(request, response, url);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
