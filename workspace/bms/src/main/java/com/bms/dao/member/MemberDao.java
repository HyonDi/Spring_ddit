package com.bms.dao.member;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.facility.ResponsibilityFacilityVO;
import com.bms.dto.member.CareerVO;
import com.bms.dto.member.MemberVO;
import com.bms.dto.member.OwnerVO;
import com.bms.dto.member.ResidentVO;
import com.bms.dto.member.SuperintendentVO;
import com.bms.dto.task.ResponsibilityTaskVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.request.reply.CommunityReplyRequest;

public interface MemberDao {
	
	//로그인
	public MemberVO selectMemberById(String id)throws SQLException;

	//모바일 지문인증 로그인 체크
	public MemberVO selectMemberByPhone(String member_phone) throws SQLException;
	
	//아이디 찾기
	public String selectGetMemberId(MemberVO member) throws SQLException;
	
	//비밀번호찾기
	public String selectGetMemberPassword(MemberVO member) throws SQLException;
	
	//비밀번호 변경
	public void changePassword(MemberVO member)throws SQLException;
	
	//모바일 맴버 code를 통한 member_name 조회
	String selectMemberNameByCode(String member_code) throws SQLException;
	
	public int selectPasswordUpdateChk(MemberVO member) throws SQLException;
	
	// 06.11 강현지
	
	//입주자 리스트
	List<ResidentVO> selectResidentList(String member_up_code)throws SQLException;
	List<ResidentVO> selectResidentListCriteria(SearchCriteria cri)throws SQLException;
	int selectResidentCriteriaCount(SearchCriteria cri)throws SQLException;
	
	// 입주자 수
	int ResidentCount(String member_up_code)throws SQLException;
	
	// 관리인 리스트
	List<SuperintendentVO> selectSuperintendentList(String member_up_code)throws SQLException;
	// 관리인 리스트 검색
	List<SuperintendentVO> selectSuperintendentListCriteria(SearchCriteria cri)throws SQLException;
	int selectSuperintendentCriteriaCount(SearchCriteria cri)throws SQLException;
	
	// 관리인 수
	int SuperintendentCount(String member_up_code)throws SQLException;
	
	// 검색 결과의 전체 리스트 개수
	//int selectEmployeeListCount(SearchCriteria ci)throws SQLException; 
	
	// 검색 입주자리스트
	List<ResidentVO> selectSearchResidentList(String member_up_code)throws SQLException;
	
	// 검색 관리인리스트
	List<SuperintendentVO> selectSearchSuperintendentList(String member_up_code)throws SQLException;
	
	// 입주자 한 명 select /id로
	ResidentVO selectResidentById(String member_id) throws SQLException;
	
	// 입주자 한 명 select  /code로
	ResidentVO selectResidentByCode(String member_code) throws SQLException;
	
	// 관리인 한 명 select /id로
	SuperintendentVO selectSuperintendentById(String member_id) throws SQLException;
	
	// 관리인 한 명 select /code로
	SuperintendentVO selectSuperintendentByCode(String member_code) throws SQLException;
	
	// 회원 공통 등록
	void insertMember(MemberVO memberVO)throws SQLException;
	
	// 입주자 등록
	void insertResident(ResidentVO resident) throws SQLException;
	
	// 관리인 등록
	void insertSuperintendent(SuperintendentVO superintendent) throws SQLException;
	
	// 건물주 등록
	void insertOwner(OwnerVO owner) throws SQLException;
	
	// 회원 공통 수정
	void updateMember(MemberVO member) throws SQLException;
	
	// 입주자 수정
	void updateResident(ResidentVO resident) throws SQLException;
	
	// 관리인 수정
	void updateSuperintendent(SuperintendentVO superintendent) throws SQLException;
	
	// 건물주 수정
	void updateOwner(OwnerVO owner) throws SQLException;
	
	// 회원 공통 삭제
	void deleteMember(String member_code) throws SQLException;
	
	// 입주자 삭제
	void deleteResident(String member_code) throws SQLException;
	
	// 관리인 삭제
	void deleteSuperintendent(String member_code) throws SQLException;
	
	// 건물주 삭제
	void deleteOwner(String member_code) throws SQLException;
	
	// 입주자 활성화 여부 변경
	void disableResident(String member_code) throws SQLException;
	
	// 로그인 시간 변경
	void updateRecentLoginTime(String member_code) throws SQLException;
	
	// 멤버 시퀀스 조회
	int selectMemberSeqNext() throws SQLException;
	
	// 멤버 시퀀스 조회
	int selectMemberSeqCurrnt() throws SQLException;
	
	// 관리인 경력사항
	List<CareerVO> selectCareer(String member_code) throws SQLException;
	// 관리인 담당 시설
	List<ResponsibilityFacilityVO> selectResponsibilityFacility(String member_code) throws SQLException;
	// 관리인 담당 업무
	List<ResponsibilityTaskVO> selectResponsibilityTask(String member_code) throws SQLException;
	// 작성한 일지 수
	int selectJournalCount(String member_code) throws SQLException;

	public List<CommunityReplyRequest> selectCommunityReplyRequest(String member_code) throws SQLException;

	public MemberVO selectMemberAllByCode(String member_code) throws SQLException;
		
}
