package com.bms.dao.member;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.member.MemberVO;

public interface MemberDao {
	
	//로그인
	public MemberVO selectMemberById(String id)throws SQLException;
	

}
