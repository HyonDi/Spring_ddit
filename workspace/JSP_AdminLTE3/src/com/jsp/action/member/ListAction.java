package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dispatcher.ViewResolver;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class ListAction implements Action {
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		
		//MemberService service = MemberServiceImpl.getInstance();
		
		try {
			
			Map<String, Object> dataMap = memberService.getMemberList(cri);
			
			request.setAttribute("memberList", dataMap.get("memberList"));// 이건어떻게가져오는거야
			request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return url;
	}

}
