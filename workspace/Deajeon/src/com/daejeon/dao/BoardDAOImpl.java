package com.daejeon.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.daejeon.dto.BoardVO;
import com.daejeon.request.SearchCriteria;


public class BoardDAOImpl implements BoardDAO {
	
	private SqlSessionFactory sessionFactory;
	public void setSessionFactory(SqlSessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}
	

	@Override
	public List<BoardVO> selectSearchBoardList(SearchCriteria cri) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<BoardVO> boardList = null;
		
		boardList = session.selectList("Board-Mapper.selectSearchBoardList",cri,rowBounds);
		session.close();
		return boardList;
	}

	@Override
	public int selectSearchBoardListCount(SearchCriteria cri) throws SQLException {
		int count = 0;
		SqlSession session = sessionFactory.openSession();
		count = session.selectOne("Board-Mapper.selectSearchBoardListCount",cri);
		
		session.close();
		return count;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		BoardVO board = session.selectOne("Board-Mapper.selectBoardByBno",bno);
		session.close();
		
		return board;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		session.update("Board-Mapper.insertBoard", board);
		session.close();

	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		session.update("Board-Mapper.updateBoard", board);
		session.close();

	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		session.update("Board-Mapper.deleteBoard", bno);
		session.close();

	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		session.update("Board-Mapper.increaseViewCnt", bno);
		session.close();

	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		int boardSeqNext = 0;
		SqlSession session = sessionFactory.openSession();
		boardSeqNext = session.selectOne("Board-Mapper.selectBoardSeqNext");
		
		session.close();
		return boardSeqNext;
	}

}
