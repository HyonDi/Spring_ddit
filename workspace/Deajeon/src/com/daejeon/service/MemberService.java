package com.daejeon.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.daejeon.dto.MemberVO;
import com.daejeon.exception.InvalidPasswordException;
import com.daejeon.exception.NotFoundIDException;
import com.daejeon.request.SearchCriteria;

public interface MemberService {
	

	void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
	
	Map<String,Object> getMemberList(SearchCriteria cri) throws SQLException;
	
	MemberVO getMember(String id) throws SQLException;
	
	void regist(MemberVO member) throws SQLException;
	
	void modify(MemberVO member) throws SQLException;
	
	void remove(String id) throws SQLException;
	
	void disabledMember(String id) throws SQLException;
	
	void enabledMember(String id) throws SQLException;
	
	
	
	
	
}
