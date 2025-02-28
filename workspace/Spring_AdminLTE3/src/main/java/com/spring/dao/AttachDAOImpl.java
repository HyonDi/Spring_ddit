package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.AttachVO;

public class AttachDAOImpl implements AttachDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertAttach(AttachVO attach) throws SQLException {
		sqlSession.update("Attach-Mapper.insertAttach",attach);
	}

	@Override
	public void deleteAttach(int ano) throws SQLException {
		sqlSession.update("Attach-Mapper.deleteAttach",ano);		
		
	}

	@Override
	public List<AttachVO> selectAttachesByPno(int pno) throws SQLException {
		List<AttachVO> attachList=sqlSession.selectList("Attach-Mapper.selectAttachByPno",pno);
		return attachList;
	}

	@Override
	public void deleteAllAttach(int pno) throws SQLException {
		sqlSession.update("Attach-Mapper.deleteAllAttach",pno);		
	}
	@Override
	public AttachVO selectAttachByAno(int ano) throws SQLException {
		
		AttachVO attach=(AttachVO)sqlSession.selectOne("Attach-Mapper.selectAttachByAno",ano);
		// 형변환 selectOne 자동으로 해줌.따라서 (AttachVO) 안써도 됨. (T 써있으면 자동형변환해주나봐.) 마이바티스 3.0.1버전은 자동형변환안해줌.
		return attach;
	}

}
