package com.daejeon.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daejeon.dao.AttachDAO;
import com.daejeon.dao.BoardDAO;
import com.daejeon.dao.ReplyDAO;
import com.daejeon.dto.AttachVO;
import com.daejeon.dto.BoardVO;
import com.daejeon.request.PageMaker;
import com.daejeon.request.SearchCriteria;

public class BoardServiceImpl implements BoardService {

	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO=boardDAO;
	}
	
	private AttachDAO attachDAO;
	public void setAttachDAO(AttachDAO attachDAO) {
		this.attachDAO = attachDAO;
	}
	
	@Override
	public Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException {
		
		List<BoardVO> boardList=boardDAO.selectSearchBoardList(cri);

		int totalCount=boardDAO.selectSearchBoardListCount(cri);
		
		for(BoardVO board : boardList) {
			int replycnt=replyDAO.countReply(board.getBno());
			board.setReplycnt(replycnt);
			
			int attachcnt=attachDAO.getAttachCntByBno(board.getBno());
			board.setAttachcnt(attachcnt);
		}
		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		Map<String,Object> dataMap=new HashMap<String,Object>();
		dataMap.put("boardList", boardList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public BoardVO getBoard(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
		
		BoardVO board = boardDAO.selectBoardByBno(bno);
		List<AttachVO> attachList=attachDAO.selectAttachesByBno(bno);
		board.setAttachList(attachList);
		return board;
	}

	@Override
	public BoardVO getBoardForModify(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		List<AttachVO> attachList = attachDAO.selectAttachesByBno(bno);
		board.setAttachList(attachList);
		return board;
	}

	@Override
	public void write(BoardVO board) throws SQLException {
		int seq = boardDAO.selectBoardSeqNext();
		board.setBno(seq);
		boardDAO.insertBoard(board);
		
		for(AttachVO attach:board.getAttachList()) {
			attach.setBno(seq);
			attach.setAttacher(board.getWriter());
			attachDAO.insertAttach(attach);
		}
	}

	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
		for(AttachVO attach:board.getAttachList()) {
			attach.setBno(board.getBno());
			attach.setAttacher(board.getWriter());
			attachDAO.insertAttach(attach);
		}
		
	}

	@Override
	public void remove(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
		
	}

	@Override
	public int getBoardListCount(SearchCriteria cri) throws SQLException {
		int cnt = boardDAO.selectSearchBoardListCount(cri);
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
