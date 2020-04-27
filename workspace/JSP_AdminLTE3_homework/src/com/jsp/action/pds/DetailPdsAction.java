package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

public class DetailPdsAction implements Action {
	
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url="pds/detail";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		
		
		// 수정했는가?
		String modify_check = request.getParameter("check");
		
		
		
		PdsVO pds = null;
		try {
			// 증가
			if(modify_check.equals("modyfied")) { // 고쳤을 때 
				/*pds = boardService.getBoardForModify(pno);*/
				pds = pdsService.getPdsForModify(pno);
				System.out.println("수정했을때");
				
			}else if(modify_check.equals("list")) { // 안고쳤을 때 
				pds = pdsService.getPds(pno);
				System.out.println("수정 안했을때");
			}
			
			request.setAttribute("pds", pds);
			
		} catch(SQLException e) {
			e.printStackTrace();
			url="error/500_error";
		}
		
		return url;
	}

}
