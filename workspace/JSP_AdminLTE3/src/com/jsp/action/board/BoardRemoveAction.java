package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.BoardService;

public class BoardRemoveAction implements Action{
	
	// 의존주입위한코드.
	private BoardService boardService;// = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
		
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");*/
		
		String bno = request.getParameter("bno");
		
		//String id = request.getParameter("id");
		
		String url = "board/remove_success";
		
		try {
			boardService.remove(Integer.parseInt(bno));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			url = "board/remove_fail";
			System.out.println("숫자바꾸기실패해서 에러");
		} catch (SQLException e) {
			e.printStackTrace();
			url = "board/remove_fail";
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
		
		//ViewResolver.view(request, response, url);
		return url;
	}

}
