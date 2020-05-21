package com.spring.service;

import java.sql.SQLException;

import com.spring.dto.MemberVO;

public interface MemberService {

	// 로그인할때, 등록할때 로그를 남길것임.
	public MemberVO getMember(String id)throws SQLException;
	public void regist(MemberVO member)throws SQLException;
}	
