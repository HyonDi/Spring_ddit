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

public class RegistPdsAction implements Action {
	
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url="pds/regist_success";
		
		String pno = "1"; // 일단 1넣어놓는다.
		
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println("title : " + title);
		
		PdsRegistRequest pdsReq = new PdsRegistRequest(pno,title, writer, content);
		
		PdsVO pds = pdsReq.toPdsVO();
		
		
		try {
			pdsService.regist(pds);
		} catch (SQLException e) {
			e.printStackTrace();
			// 실패시!!
			url = "pds/regist_fail";
		}
		
		return url;
	}

}
