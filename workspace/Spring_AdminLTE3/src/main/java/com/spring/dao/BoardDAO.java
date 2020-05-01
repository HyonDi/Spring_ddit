package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.BoardVO;
import com.spring.request.SearchCriteria;

public interface BoardDAO {
	// 이거바탕으로  query 작성하기.
	
	// 게시판검색 혹은 게시판리스트가져오기
	List<BoardVO> selectBoardCriteria(SearchCriteria cri) throws SQLException;

	// 전체리스트의갯수.(검색을하던안하던)
	int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException;

	// 상세보기
	BoardVO selectBoardByBno(int bno) throws SQLException;

	// 등록
	void insertBoard(BoardVO board) throws SQLException;

	// 수정
	void updateBoard(BoardVO board) throws SQLException;

	// 삭제
	void deleteBoard(int bno) throws SQLException;

	// viewcnt 증가 . 조회수증가.
	void increaseViewCnt(int bno) throws SQLException;

	// board_seq.nextval 가져오기. 이게왜필요??=>
	int selectBoardSeqNext() throws SQLException;

}
