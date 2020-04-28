package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;
import com.jsp.service.PdsService;
import com.jsp.utils.CreatePageMaker;
import com.jsp.utils.MakeFileName;

public class DetailPdsAction implements Action {
	
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 화면결정.
		String url="pds/detail";
		
		
		
		
		// 파라미터받기. 파라미터로넘어오는건 모두  String
		int pno = Integer.parseInt(request.getParameter("pno"));
		String modify_check = request.getParameter("check");
		int page = Integer.parseInt(request.getParameter("page"));
		int perPageNum = Integer.parseInt(request.getParameter("perPageNum"));
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);
		
		
		
		PdsVO pds = null;
		try {
			// 증가
			if(modify_check.equals("modyfied")) { // 고쳤을 때 
				pds = pdsService.read(pno);
			}else if(modify_check.equals("list")) { // 안고쳤을 때 
				pds = pdsService.getPds(pno);
			}
			
			// OS 형식을 url 형식으로 바꿔주는 작업.
			List<AttachVO> renamedAttachList = MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
			pds.setAttachList(renamedAttachList);
			
			request.setAttribute("pds", pds); // request에 심는다 = attribute set함.
			
			PageMaker pageMaker = CreatePageMaker.make(request);//
			
			request.setAttribute("pageMaker", pageMaker);
		} catch(Exception e) {
			e.printStackTrace();
			url="error/500_error";
		}
		
		return url;
	}

}
