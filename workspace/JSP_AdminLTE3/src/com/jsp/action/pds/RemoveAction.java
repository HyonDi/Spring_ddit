package com.jsp.action.pds;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.request.PageMaker;
import com.jsp.service.PdsService;
import com.jsp.utils.CreatePageMaker;

public class RemoveAction implements Action {
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
/*		String url = "pds/remove_success";
		String pno = request.getParameter("pno");
		
		//String id = request.getParameter("id");
		
		
		try {
			pdsService.remove(Integer.parseInt(pno));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			url = "pds/remove_fail";
			System.out.println("숫자바꾸기실패해서 에러. pno 가 null인가봐");
		} catch (SQLException e) {
			e.printStackTrace();
			url = "pds/remove_fail";
		}*/
		
		
		/*if(loginUser.getId().equals(id)) { // 로그인한 사람 id 같을 시.
			url="member/remove_denied";
		}else {
			
			try {
				memberService.remove(id);
			} catch (SQLException e) {
				e.printStackTrace();
				url = "member/remove_fail";
			}
		}*/
		
		
		String url = "pds/remove_success";
		int pno = Integer.parseInt(request.getParameter("pno"));

		
		
		// pno에 대한 attachList 확보
		List<AttachVO> attachList = null;
		try {
			attachList = pdsService.getPds(pno).getAttachList();

			// 각 attachlist 를 이용 파일을 삭제.
			if(attachList != null) {
				for (AttachVO attach : attachList) {
					String storedFilePath = attach.getUploadPath() + File.separator
							+ attach.getFileName();
					File file = new File(storedFilePath);
					if (file.exists()) {
						file.delete();
					}
	
				}
			}
			//DB 내용 삭제
			pdsService.remove(pno);
			
			PageMaker pageMaker = CreatePageMaker.make(request);
			request.setAttribute("pageMaker", pageMaker);
		} catch (Exception e1) {
			url="error/500";
			e1.printStackTrace();
		}

		return url;
	}

}
