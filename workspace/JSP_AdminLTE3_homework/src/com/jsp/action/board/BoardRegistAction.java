package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.request.BoardRegistRequest;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;

public class BoardRegistAction implements Action {
	
	private BoardService boardService;// = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// 성공시 갈 곳.
		String url="board/regist_success"; // .jsp 적으면 안됨!
		
		/*int boardseqNext = 0;
		try {
			// 다음 시퀀스번호 받아온다.
			boardseqNext = boardService.selectBoardSeqNext();
		} catch(SQLException e) {
			e.printStackTrace();
			url = "board/regist_fail";
		}
		*/
//		int bno = boardseqNext;
		
		String bno = "1"; // 일단 1넣어놓는다.
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
/*		String viewcnt = request.getParameter("viewcnt");
		String regDate = request.getParameter("regDate");
		String updatedate = request.getParameter("updatedate");*/
		
		//System.out.println("bno : " + bno + "!!!!!!!!!!!!!!!");
		BoardRegistRequest boardReq = new BoardRegistRequest(bno,title, writer, content);
		
		BoardVO board = boardReq.toBoardVO();
		
		// redirect/forward로 화면을 내보내야하는 애야. 그래서
		
		try {
			boardService.write(board);
		} catch (SQLException e) {
			e.printStackTrace();
			// 실패시!!
			url = "board/regist_fail";
		}
		
		return url;
	}

}
