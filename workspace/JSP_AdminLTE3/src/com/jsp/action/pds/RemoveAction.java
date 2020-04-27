package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.PdsService;

public class RemoveAction implements Action {
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "pds/remove_success";
		String pno = request.getParameter("pno");
		
		//String id = request.getParameter("id");
		
		
		try {
			pdsService.remove(Integer.parseInt(pno));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			url = "pds/remove_fail";
			System.out.println("숫자바꾸기실패해서 에러");
		} catch (SQLException e) {
			e.printStackTrace();
			url = "pds/remove_fail";
		}
		
		
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
		
		return url;
	}

}
