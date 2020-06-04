package com.bms.dao.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.member.MemberVO;

public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", id);
		return member;
	}



}
