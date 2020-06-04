package com.spring.dao.employee;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.PositionVO;

public class PositionDAOImpl implements PositionDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<PositionVO> selectPositionList() throws SQLException {
		List<PositionVO> positionList = sqlSession.selectList("Position-Mapper.selectPositionList");
		return positionList;
	}

}
