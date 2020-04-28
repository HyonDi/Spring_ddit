package com.daejeon.dao;

import java.sql.SQLException;
import java.util.List;

import com.daejeon.dto.MemberVO;
import com.daejeon.request.SearchCriteria;


public interface MemberDAO {
	
	List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException;
	
	int selectMemberListCount(SearchCriteria cri) throws SQLException;
	
	MemberVO selectMemberById(String id) throws SQLException;
	
	void insertMember(MemberVO member) throws SQLException;
	
	void updateMember(MemberVO member) throws SQLException;
	
	void deleteMember(String id) throws SQLException;
	
	void disabledMember(String id) throws SQLException;
	
	void enabledMember(String id) throws SQLException;
	
	
}
