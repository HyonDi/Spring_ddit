package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.request.SearchCriteria;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;

public class BoardListAction implements Action {

	// 의존주입위한코드.
	private BoardService boardService;// = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "board/list"; //webinf > views > board > list 를 dmlalgka.
		
		// 크리테리아만드는 데 필요한것.
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		// Search크리테리아를 만든다.
		SearchCriteria cri = new SearchCriteria();
		
		
		
		
		// 할당해줌. set. page가 String이라 exception(NumberFormatException) 넣어두었다.
		try {
			cri.setPage(Integer.parseInt(page));
			cri.setPerPageNum(Integer.parseInt(perPageNum));
		} catch(NumberFormatException e) {
			System.out.println("페이지 번호를 1로 세팅합니다.");
		}
		if(searchType != null && keyword != null) {		// keyword, searchType 없을때.
			cri.setSearchType(searchType);
			cri.setKeyword(keyword);
		}
		
	/*	System.out.println("cri : " + cri + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("boardService : " + boardService + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");*/
		
		// 수정했는지안했는지 체크를 위함.
		String modify_check = "수정안함";
		request.setAttribute("check",modify_check);
		
		
		try {
			// 서비스호출.
			Map<String, Object> dataMap = boardService.getBoardList(cri);
			
			// 서블릿이보내준 request에 심음. 호출 시 request의 주소를 준거라 하나만 값을바꿔도 그 속의값은 공유하고있다.
			request.setAttribute("dataMap", dataMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// 서블릿할때의 차이점이 이거하나!
		return url;
	}

}
