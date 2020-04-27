package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;

public class BoardDetailAction implements Action {
	
	
	
	// 의존주입위한코드.
	private BoardService boardService;// = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
		
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 여기에 조회수 증가 1시키기.
		// 수정이후엔 ,,,?
		
		String url = "board/detailBoard";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		
		
		// 수정했는가?
		String modify_check = request.getParameter("check");
		
		
		
		BoardVO board = null;
		try {
			// 증가
			if(modify_check.equals("modyfied")) { // 고쳤을 때 
				board = boardService.getBoardForModify(bno);
				
			}else if(modify_check.equals("list")) { // 안고쳤을 때 
				board = boardService.getBoard(bno);
			}
			
			request.setAttribute("board", board);
			
		} catch(SQLException e) {
			e.printStackTrace();
			url="error/500_error";
		}
		
		return url;
	}

}
