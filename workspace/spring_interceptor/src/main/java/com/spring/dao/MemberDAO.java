package com.spring.dao;

import java.sql.SQLException;

import com.spring.dto.MemberVO;

public interface MemberDAO {
	
	// 로그인할때, 등록할때 로그를 남길것임.
	public void insertMember(MemberVO member)throws SQLException;
	
	public MemberVO selectMember(String id)throws SQLException;
}
