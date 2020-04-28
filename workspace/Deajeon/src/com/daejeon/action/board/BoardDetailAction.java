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
import com.daejeon.request.SearchCriteria;
import com.daejeon.service.BoardService;
import com.daejeon.utils.CreatePageMaker;
import com.daejeon.utils.MakeFileName;

public class BoardDetailAction implements Action {
	
	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url="board/detail";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
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
		
		BoardVO board = null;
		try {
			// 증가
			if(modify_check.equals("modyfied")) { // 고쳤을 때 
				board = boardService.getBoardForModify(bno);
			}else if(modify_check.equals("list")) { // 안고쳤을 때 
				board = boardService.getBoard(bno);;
			}
			
			// OS 형식을 url 형식으로 바꿔주는 작업.
			List<AttachVO> renamedAttachList = MakeFileName.parseFileNameFromAttaches(board.getAttachList(), "\\$\\$");
			board.setAttachList(renamedAttachList);
			
			request.setAttribute("board", board); // request에 심는다 = attribute set함.
			
			PageMaker pageMaker = CreatePageMaker.make(request);//
			
			request.setAttribute("pageMaker", pageMaker);
		} catch(Exception e) {
			e.printStackTrace();
			url="error/500_error";
		}
		
		return url;
	}

}
