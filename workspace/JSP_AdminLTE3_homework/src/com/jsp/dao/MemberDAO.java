package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;

/**
 * 규격을 만든다. 여기에 없는 메서드는 구현체(다오임플)에 있어도 실행할 수 없음.
 * 시그니쳐 생성 = 리턴타입, 이름, 이런거
 * @author PC-16
 *
 */
public interface MemberDAO {
	
	// dao는 매퍼에서 작성한 쿼리문 이상이 필요. service에서 호출해야해.
	// 쿼리문하나에 dao를 하나씩 박는다. 1쿼리 = 1메서드(이상)
		
	// 서비스는 기능단위로 작성해야함. 1기능 = 1메서드(이상)
	// dao를 고려하지않고 고객에게 서비스 할 내용을 작성한다.
	
	
	
	
	
	// 회원 리스트
	List<MemberVO> selectMemberList() throws SQLException;
	List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException;// 오버로딩
	
	// 전체 회원 리스트 개수
	int selectMemberListCount() throws SQLException;
	
	// 검색 결과의 전체 리스트 개수
	int selectMemberListCount(SearchCriteria cri) throws SQLException;// 얘도 오버로딩?
	
	
	// 회원 정보 조회
	MemberVO selectMemberById(String id) throws SQLException;
	
	// 회원 정보 추가
	void insertMember(MemberVO member) throws SQLException;
	
	// 회원 정보 수정
	void updateMember(MemberVO member) throws SQLException;
	
	// 회원 정보 삭제
	void deleteMember(String id) throws SQLException;
	
	// 회원 정지
	void disabledMember(String id) throws SQLException;
	
	// 정지회원 활성화
	void enabledMember(String id) throws SQLException;
	
	
}
