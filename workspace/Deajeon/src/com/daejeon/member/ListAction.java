package com.daejeon.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daejeon.action.Action;
import com.daejeon.request.SearchCriteria;
import com.daejeon.service.MemberService;

public class ListAction implements Action {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="member/list";
		
		SearchCriteria cri = new SearchCriteria();
		
		try {
			int page = Integer.parseInt(request.getParameter("page"));
			int perPageNum = Integer.parseInt(request.getParameter("perPageNum"));
			cri.setPage(page);
			cri.setPerPageNum(perPageNum);
			
		} catch(NumberFormatException e) {
			System.out.println("페이지 번호가 누락으로 기본 1페이지로 세팅됩니다.");
		}
		
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		
		try {
			
			Map<String, Object> dataMap = memberService.getMemberList(cri);
			
			request.setAttribute("memberList", dataMap.get("memberList"));
			request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return url;
	}

}
