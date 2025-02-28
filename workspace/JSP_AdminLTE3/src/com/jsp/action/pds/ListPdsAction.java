package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.request.SearchCriteria;
import com.jsp.service.PdsService;

public class ListPdsAction implements Action {

	// 
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "pds/list";
		
		String page=request.getParameter("page");
		String perPageNum=request.getParameter("perPageNum");
		String searchType=request.getParameter("searchType");
		String keyword=request.getParameter("keyword");
		
		
		//  위에거담는 그릇이 searchCriteria 임.
		SearchCriteria cri = new SearchCriteria();
		
		// 파라미터 담는다. (setmethod)
		try {
			cri.setPage(Integer.parseInt(page));
			cri.setPerPageNum(Integer.parseInt(perPageNum));
			
		} catch(NumberFormatException e) {
			System.out.println("페이지 번호를 1로 세팅합니다.");
		}
		
		if(searchType!=null && keyword!=null) {
			cri.setSearchType(searchType);
			cri.setKeyword(keyword);
		}
	
		
		try {
			Map<String,Object> dataMap=pdsService.getList(cri);// getList 리턴이 Map.
			request.setAttribute("dataMap", dataMap);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		return url;
	}

}
