package com.bms.dao.mypage;

import java.sql.SQLException;

import com.bms.dto.member.MemberVO;

public interface MypageDao {

	MemberVO selectMemberById(String id) throws SQLException;
}
