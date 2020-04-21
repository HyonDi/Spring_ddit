package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.request.BoardRegistRequest;
import com.jsp.service.BoardServiceImpl;

public class BoardRegistAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 역할 : 가입처리 시키기.(redirect 해야하는데 이렇게안하고 윈도우 닫고(request죽음.) reload할것임.)
		// 그렇다면 여기에는 doGet실행시키는 메서드가 필요 없는가???
		// doGet(request, response);
		
		// 성공시 갈 곳.
		String url="board/regist_success"; // .jsp 적으면 안됨!
		
		//String bno = request.getParameter("bno");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
/*		String viewcnt = request.getParameter("viewcnt");
		String regDate = request.getParameter("regDate");
		String updatedate = request.getParameter("updatedate");*/
		
		//System.out.println("bno : " + bno + "!!!!!!!!!!!!!!!");
		BoardRegistRequest boardReq = new BoardRegistRequest(title, writer, content);
		
		BoardVO board = boardReq.toBoardVO();
		
		// redirect/forward로 화면을 내보내야하는 애야. 그래서
		try {
			BoardServiceImpl.getInstance().write(board);
		} catch (SQLException e) {
			e.printStackTrace();
			// 실패시!!
			url = "board/regist_fail";
		}
		
		return url;
	}

}
