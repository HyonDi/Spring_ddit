package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.PdsVO;
import com.jsp.request.PdsRegistRequest;
import com.jsp.service.PdsService;

public class ModifyAction implements Action {
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 성공시 갈 곳.
		String url="pds/modify_success";
		
		String pno = request.getParameter("pno");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		PdsRegistRequest pdsReq = new PdsRegistRequest(pno, title, writer, content);
		
		PdsVO pds = pdsReq.toPdsVO();
//				String modify_check = "수정함";
		
//				request.setAttribute("pds",pds);
		
		
		// redirect/forward로 화면을 내보내야하는 애야. 그래서
		try {
			pdsService.modify(pds);
			
		} catch (SQLException e) {
			e.printStackTrace();
			// 실패시!!
			url = "pds/modify_fail";
			
		}
		
		return url;
	}

}
