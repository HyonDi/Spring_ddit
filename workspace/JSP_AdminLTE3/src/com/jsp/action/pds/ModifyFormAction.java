package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.BoardVO;
import com.jsp.dto.PdsVO;
import com.jsp.request.PageMaker;
import com.jsp.service.PdsService;
import com.jsp.utils.CreatePageMaker;
import com.jsp.utils.MakeFileName;

public class ModifyFormAction implements Action {
	
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	String url = "pds/modify";
		
		
		try {
			int pno = Integer.parseInt(request.getParameter("pno"));
			
			PdsVO pds = pdsService.getPdsForModify(pno);
			request.setAttribute("pds", pds);
			
		} catch(Exception e) {
			e.printStackTrace();
			url = "error/500_error";
		}
		
		return url;*/
		//
		// 화면결정.
		String url="pds/modify";
		
		// 파라미터받기. 파라미터로넘어오는건 모두  String
		int pno = Integer.parseInt(request.getParameter("pno"));
		String modify_check = request.getParameter("check");
		
		
		PdsVO pds = null;
		try {
			pds = pdsService.getPdsForModify(pno);
			
			
			// OS 형식을 url 형식으로 바꿔주는 작업. 여기선 url형식을 다시 os형식으로바꿔야하는거 아냐?
			List<AttachVO> renamedAttachList = MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
			pds.setAttachList(renamedAttachList);
			
			PageMaker pageMaker = CreatePageMaker.make(request);
			
			request.setAttribute("pageMaker", pageMaker);
			request.setAttribute("pds", pds); // request에 심는다 = attribute set함.
		} catch(Exception e) {
			e.printStackTrace();
			url="error/500_error";
		}
		
		return url;
		//
	}

}
