package com.spring.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.request.SearchCriteria;

public interface MemberService {
	
	// dao는 매퍼에서 작성한 쿼리문 이상이 필요. service에서 호출해야해.
	// 쿼리문하나에 dao를 하나씩 박는다. 1쿼리 = 1메서드(이상)
	
	// 서비스는 기능단위로 작성해야함. 1기능 = 1메서드(이상)
	// dao를 고려하지않고 고객에게 서비스 할 내용을 작성한다.
	
	
	// 로그인
	void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
	
	// 회원리스트 조회
	List<MemberVO> getMemberList() throws SQLException;
	// 이때엔 오버로딩해야함.같은기능인데 파라미터가 다르니까.(리턴타입달라도 오버로딩성립합니당)
	Map<String,Object> getMemberList(SearchCriteria cri) throws SQLException;
	// 맵인이유는?? 크리테리아받고 페이지메이킹을 만들어서 줘야함. jsp가 꺼내가기 쉽게하기위함입니다. 
	// memberList, criteria 두개를 넣어놔야하는데 구분하기 쉬우니까. 
	
	
	// 회원정보 조회
	MemberVO getMember(String id) throws SQLException;
	
	
	
	
	
	// 회원 등록
	void regist(MemberVO member) throws SQLException;
	
	// 회원 수정
	void modify(MemberVO member) throws SQLException;
	
	// 회원 삭제
	void remove(String id) throws SQLException;
	
	// 회원 정지
	void disabledMember(String id) throws SQLException;
	
	// 정지회원 활성화
	void enabledMember(String id) throws SQLException;
	
	
	
	
	
}
