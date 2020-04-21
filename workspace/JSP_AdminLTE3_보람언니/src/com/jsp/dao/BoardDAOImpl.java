package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dto.BoardVO;
import com.jsp.request.SearchCriteria;

public class BoardDAOImpl implements BoardDAO {

	//SqlSessionFactory
	private SqlSessionFactory sessionFactory;
	/*= OracleMyBatisSqlSessionFactoryBuilder.getSqlSessionFactory();*/
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
	@Override
	public List<BoardVO> selectBoardCriteria(SearchCriteria cri) throws SQLException {
		SqlSession session = sessionFactory.openSession(); //openSession() : 기본값 false(셀렉트문이기때문에 오토커밋안함)
		
		int offset = cri.getPageStartRowNum(); //offset : 기준 (한 페이지의 첫 글번호)
		int limit = cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset, limit); //매퍼에 얘를 보내면 정해준 개수만큼 데이터를 알아서 잘라 보내줌
		
		List<BoardVO> boardList = session.selectList("Board-Mapper.selectBoardCriteria", cri, rowBounds);
		session.close();
		
		return boardList;
	}

	@Override
	public int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count = 0;
		SqlSession session = sessionFactory.openSession(true);
		count = session.selectOne("Board-Mapper.selectBoardCriteriaTotalCount", cri);
		session.close();
		return count;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession(); //openSession() : 기본값 false(셀렉트문이기때문에 오토커밋안함)
		BoardVO board = session.selectOne("Board-Mapper.selectBoardByBno", bno);
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

}
