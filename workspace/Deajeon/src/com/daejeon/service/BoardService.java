package com.daejeon.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.daejeon.dto.BoardVO;
import com.daejeon.request.SearchCriteria;


public interface BoardService {
	
	Map<String,Object> getBoardList(SearchCriteria cri)throws SQLException;
	
	int getBoardListCount(SearchCriteria cri) throws SQLException;

	BoardVO getBoard(int bno)throws SQLException;	
	
	BoardVO getBoardForModify(int bno)throws SQLException;
	
	void write(BoardVO board)throws SQLException;
		
	void modify(BoardVO board)throws SQLException;
	
	void remove(int bno)throws SQLException;
	
	void increaseViewCnt(int bno) throws SQLException;

	int selectBoardSeqNext() throws SQLException;
}




