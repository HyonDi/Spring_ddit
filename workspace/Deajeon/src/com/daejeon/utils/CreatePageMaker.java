package com.daejeon.utils;

import javax.servlet.http.HttpServletRequest;

import com.daejeon.request.PageMaker;
import com.daejeon.request.SearchCriteria;


public class CreatePageMaker {
	public static PageMaker make(HttpServletRequest request) throws Exception{ // static : 모두 받아서사용하니 인스턴스 만들필요없어서 붙인다.
		
		int page = Integer.parseInt(request.getParameter("page"));
		int perPageNum = Integer.parseInt(request.getParameter("perPageNum"));
		String searchType = request.getParameter(request.getParameter("searchType"));
		String keyword = request.getParameter(request.getParameter("keyword"));
		
		PageMaker pageMaker = new PageMaker();
		SearchCriteria cri = new SearchCriteria();
		
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		
		if(searchType !=null && keyword != null) {
			cri.setSearchType(searchType);
			cri.setKeyword(keyword);
		}
		
		pageMaker.setCri(cri);
		return pageMaker;
		
	}
}
