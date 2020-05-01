package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dao.BoardDAO;
import com.spring.dao.ReplyDAO;
import com.spring.dto.BoardVO;
import com.spring.request.PageMaker;
import com.spring.request.SearchCriteria;

public class BoardServiceImpl implements BoardService {
	// 싱글톤패턴 구현 - 의존주입에서는 지운다. classForName으로 하기위해!
/*	private static BoardServiceImpl instance;// = new BoardServiceImpl();
	private BoardServiceImpl() {}
	public static BoardServiceImpl getInstance() {
		return instance;
	}*/
	
	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
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
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<BoardVO> boardList=boardDAO.selectBoardCriteria(cri);
		
		//전체 board 개수
		int totalCount=boardDAO.selectBoardCriteriaTotalCount(cri);
		
		// db하중을 줄이기위함. 무조건 join X. 리스트 하나씩 꺼내서 cnt넣어준다.
		for(BoardVO board : boardList) {
			int replycnt=replyDAO.countReply(board.getBno());
			board.setReplycnt(replycnt);
		}
		
		// 2. 페이지만들어서넘겨주기.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		
		
		dataMap.put("boardList", boardList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public BoardVO getBoard(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
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
		int seq = boardDAO.selectBoardSeqNext();
		board.setBno(seq);
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

	@Override
	public int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int cnt = boardDAO.selectBoardCriteriaTotalCount(cri);
		return cnt;
	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
		
	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		int seq = boardDAO.selectBoardSeqNext();
		return seq;
	}


	
}
