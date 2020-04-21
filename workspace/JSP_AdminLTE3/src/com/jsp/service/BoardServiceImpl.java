package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsp.dao.BoardDAO;
import com.jsp.dto.BoardVO;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;

public class BoardServiceImpl implements BoardService {
	// 싱글톤패턴 구현 - 의존주입에서는 지운다. classForName으로 하기위해!
	private static BoardServiceImpl instance = new BoardServiceImpl();
	private BoardServiceImpl() {}
	public static BoardServiceImpl getInstance() {
		return instance;
	}

	
	// DAO 필요.
	private BoardDAO boardDAO;
	/* = MemberDAOImpl.getInstance();*/
	// 의존주입위해 주석.set메서드는 아래있었음.
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO=boardDAO;
	}
	
	@Override
	public Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException {
		// 1. boardList(기존에 하던것. 그냥데이터만넘기는것.
		List<BoardVO> boardList = boardDAO.selectBoardCriteria(cri);

		
		// 2. 페이지만들어서넘겨주기.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardDAO.selectBoardCriteriaTotalCount(cri));
		
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("boardList", boardList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public BoardVO getBoard(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		return board;
	}

	@Override
	public BoardVO getBoardForModify(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		return board;
	}

	@Override
	public void write(BoardVO board) throws SQLException {
		boardDAO.insertBoard(board);
		
	}

	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
		
	}

	@Override
	public void remove(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
		
	}


	
}
