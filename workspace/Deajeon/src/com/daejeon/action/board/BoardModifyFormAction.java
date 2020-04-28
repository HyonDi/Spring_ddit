package com.daejeon.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daejeon.action.Action;
import com.daejeon.dto.AttachVO;
import com.daejeon.dto.BoardVO;
import com.daejeon.request.PageMaker;
import com.daejeon.service.BoardService;
import com.daejeon.utils.CreatePageMaker;
import com.daejeon.utils.MakeFileName;

public class BoardModifyFormAction implements Action {
	
	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url="board/modify";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String modify_check = request.getParameter("check");
		
		
		BoardVO board = null;
		try {
			board = boardService.getBoardForModify(bno);
			
			
			// OS 형식을 url 형식으로 바꿔주는 작업. 여기선 url형식을 다시 os형식으로바꿔야하는거 아냐?
			List<AttachVO> renamedAttachList = MakeFileName.parseFileNameFromAttaches(board.getAttachList(), "\\$\\$");
			board.setAttachList(renamedAttachList);
			
			PageMaker pageMaker = CreatePageMaker.make(request);
			
			request.setAttribute("pageMaker", pageMaker);
			request.setAttribute("board", board); // request에 심는다 = attribute set함.
		} catch(Exception e) {
			e.printStackTrace();
			url="error/500_error";
		}
		
		return url;
	}

}
