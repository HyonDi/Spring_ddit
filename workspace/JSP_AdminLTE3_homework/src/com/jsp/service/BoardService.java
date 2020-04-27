package com.jsp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.jsp.dto.BoardVO;
import com.jsp.request.SearchCriteria;

public interface BoardService {
	
	// 목록조회	
	Map<String,Object> getBoardList(SearchCriteria cri)throws SQLException;
	
	// 상세보기
	BoardVO getBoard(int bno)throws SQLException;	
	BoardVO getBoardForModify(int bno)throws SQLException;
	
	// 전체리스트의갯수.(검색을하던안하던)
	int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException;
	
	// 등록
	void write(BoardVO board)throws SQLException;
		
	// 수정
	void modify(BoardVO board)throws SQLException;
	
	// 삭제
	void remove(int bno)throws SQLException;
	
	// viewcnt 증가 . 조회수증가.
	void increaseViewCnt(int bno) throws SQLException;

	// board_seq.nextval 가져오기. 이게왜필요??=>
	int selectBoardSeqNext() throws SQLException;
}




