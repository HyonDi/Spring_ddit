package com.bms.dao.mypage;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.bms.dto.member.MemberVO;

public class MypageDaoImpl implements MypageDao{
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}



	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		
		MemberVO member = sqlSession.selectOne("Mypage-Mapper.selectMemberById", id);
		
		return member;
	}

}
