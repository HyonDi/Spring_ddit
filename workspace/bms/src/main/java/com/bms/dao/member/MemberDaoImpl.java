package com.bms.dao.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.facility.ResponsibilityFacilityVO;
import com.bms.dto.member.CareerVO;
import com.bms.dto.member.MemberVO;
import com.bms.dto.member.OwnerVO;
import com.bms.dto.member.ResidentVO;
import com.bms.dto.member.SuperintendentVO;
import com.bms.dto.task.ResponsibilityTaskVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.request.reply.CommunityReplyRequest;


public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member = sqlSession.selectOne("Member-Mapper.selectMemberById", id);
		return member;
	}
	@Override
	public MemberVO selectMemberByPhone(String member_phone) throws SQLException {
		MemberVO member = sqlSession.selectOne("Member-Mapper.selectMemberByPhone", member_phone);
		return member;
	}
	@Override
	public String selectGetMemberId(MemberVO member) throws SQLException {
		String id = sqlSession.selectOne("Member-Mapper.selectGetMemberId", member);
		if(id == null) {
			System.out.println("해당하는 아이디가 없습니다.");
		}
		return id;
	}
	@Override
	public String selectGetMemberPassword(MemberVO member) throws SQLException {
		String pwd = sqlSession.selectOne("Member-Mapper.selectGetMemberPassword", member);
		if(pwd == null) {
			System.out.println("해당하는 아이디의 비밀번호가 없습니다.");
		}
		return pwd;
	}
	@Override
	public void changePassword(MemberVO member) throws SQLException {
		sqlSession.selectOne("Member-Mapper.changePassword", member);
		
	}
	@Override
	public String selectMemberNameByCode(String member_code) throws SQLException {
		String member = sqlSession.selectOne("Member-Mapper.selectMemberNameByCode", member_code);
		return member;
	}

	@Override
	public int selectPasswordUpdateChk(MemberVO member) throws SQLException {
		int chk = sqlSession.selectOne("Member-Mapper.selectPasswordUpdateChk", member);
		return chk;
	}
	
	
	// 06.11 강현지
	
	
	@Override
	public List<ResidentVO> selectResidentList(String member_up_code) throws SQLException {
		List<ResidentVO> residentList = sqlSession.selectList("Member-Mapper.selectResidentList",member_up_code);
		return residentList;
	}
	
	@Override
	public int ResidentCount(String member_up_code) throws SQLException {
		int cout = sqlSession.selectOne("Member-Mapper.ResidentCount",member_up_code);
		return cout;
	}
	@Override
	public List<SuperintendentVO> selectSuperintendentList(String member_code) throws SQLException {
		List<SuperintendentVO> SuperintendentList = sqlSession.selectList("Member-Mapper.selectSuperintendentList",member_code);
		return SuperintendentList;
	}
	
	@Override
	public int SuperintendentCount(String member_code) throws SQLException {
		int count = sqlSession.selectOne("Member-Mapper.SuperintendentCount",member_code);
		return count;
	}
	@Override
	public List<ResidentVO> selectSearchResidentList(String member_up_code) throws SQLException {
		List<ResidentVO> residentList = sqlSession.selectList("Member-Mapper.selectSearchResidentList",member_up_code);
		return residentList;
	}
	
	@Override
	public List<SuperintendentVO> selectSearchSuperintendentList(String member_up_code) throws SQLException {
		List<SuperintendentVO> superintendentList = 
						sqlSession.selectList("Member-Mapper.selectSearchSuperintendentList",member_up_code);
		return superintendentList;
	}
	
	@Override
	public ResidentVO selectResidentById(String member_id) throws SQLException {
		ResidentVO resident = sqlSession.selectOne("Member-Mapper.selectResidentById",member_id);
		return resident;
	}
	@Override
	public ResidentVO selectResidentByCode(String member_code) throws SQLException {
		ResidentVO resident = sqlSession.selectOne("Member-Mapper.selectResidentByCode",member_code);
		return resident;
	}
	@Override
	public SuperintendentVO selectSuperintendentById(String member_id) throws SQLException {
		SuperintendentVO superintendent = sqlSession.selectOne("Member-Mapper.selectSuperintendentById",member_id);
		return superintendent;
	}
	@Override
	public SuperintendentVO selectSuperintendentByCode(String member_code) throws SQLException {
		SuperintendentVO superintendent = sqlSession.selectOne("Member-Mapper.selectSuperintendentByCode",member_code);
		return superintendent;
	}
	@Override
	public void insertMember(MemberVO memberVO) throws SQLException {
		sqlSession.update("Member-Mapper.insertMember",memberVO);
	}
	@Override
	public void insertResident(ResidentVO resident) throws SQLException {
		sqlSession.update("Member-Mapper.insertResident",resident);
		
	}
	@Override
	public void insertSuperintendent(SuperintendentVO superintendent) throws SQLException {
		sqlSession.update("Member-Mapper.insertSuperintendent",superintendent);
		
	}
	@Override
	public void insertOwner(OwnerVO owner) throws SQLException {
		sqlSession.update("Member-Mapper.insertOwner",owner);
		
	}
	@Override
	public void updateMember(MemberVO member) throws SQLException {
		sqlSession.update("Member-Mapper.updateMember",member);
		
	}
	@Override
	public void updateResident(ResidentVO resident) throws SQLException {
		sqlSession.update("Member-Mapper.updateResident",resident);
		
	}
	@Override
	public void updateSuperintendent(SuperintendentVO superintendent) throws SQLException {
		sqlSession.update("Member-Mapper.updateSuperintendent",superintendent);
		
	}
	@Override
	public void updateOwner(OwnerVO owner) throws SQLException {
		sqlSession.update("Member-Mapper.updateOwner",owner);
		
	}
	@Override
	public void deleteMember(String member_code) throws SQLException {
		sqlSession.update("Member-Mapper.deleteMember",member_code);
		
	}
	@Override
	public void deleteResident(String member_code) throws SQLException {
		sqlSession.update("Member-Mapper.deleteResident",member_code);
		
	}
	@Override
	public void deleteSuperintendent(String member_code) throws SQLException {
		sqlSession.update("Member-Mapper.deleteSuperintendent",member_code);
		
	}
	@Override
	public void deleteOwner(String member_code) throws SQLException {
		sqlSession.update("Member-Mapper.deleteOwner",member_code);
		
	}
	@Override
	public void disableResident(String member_code) throws SQLException {
		sqlSession.update("Member-Mapper.disableResident",member_code);
		
	}
	@Override
	public void updateRecentLoginTime(String member_code) throws SQLException {
		sqlSession.update("Member-Mapper.updateRecentLoginTime",member_code);
		
	}
	@Override
	public int selectMemberSeqNext() throws SQLException {
		int seq = sqlSession.selectOne("Member-Mapper.selectMemberSeqNext");
		return seq;
	}
	@Override
	public int selectMemberSeqCurrnt() throws SQLException {
		int seq = sqlSession.selectOne("Member-Mapper.selectMemberSeqCurrnt");
		return seq;
	}
	@Override
	public List<CareerVO> selectCareer(String member_code) throws SQLException {
		List<CareerVO> career = sqlSession.selectList("Member-Mapper.selectCareer",member_code);
		return career;
	}
	@Override
	public List<ResponsibilityFacilityVO> selectResponsibilityFacility(String member_code) throws SQLException {
		List<ResponsibilityFacilityVO> responsibilityFacility = sqlSession.selectList("Member-Mapper.selectResponsibility_facility",member_code);
		return responsibilityFacility;
	}
	@Override
	public List<ResponsibilityTaskVO> selectResponsibilityTask(String member_code) throws SQLException {
		List<ResponsibilityTaskVO> responsibilityTask = sqlSession.selectList("Member-Mapper.selectResponsibility_task",member_code);
		return responsibilityTask;
	}
	@Override
	public int selectJournalCount(String member_code) throws SQLException {
		int count = sqlSession.selectOne("Member-Mapper.selectJournalCount",member_code);
		return count;
	}
	@Override
	public List<CommunityReplyRequest> selectCommunityReplyRequest(String member_code) throws SQLException {
		List<CommunityReplyRequest> replyReq = sqlSession.selectList("Member-Mapper.selectCommunityReplyRequest", member_code);
		return replyReq;
	}
	@Override
	public MemberVO selectMemberAllByCode(String member_code) throws SQLException {
		MemberVO member = sqlSession.selectOne("Member-Mapper.selectMemberAllByCode",member_code);
		return member;
	}
	
	@Override
	public List<ResidentVO> selectResidentListCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<ResidentVO> residentList = sqlSession.selectList("Member-Mapper.selectSearchResidentList",cri,rowBounds);
		return residentList;
	}
	@Override
	public int selectResidentCriteriaCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Member-Mapper.selectSearchResidentListCount",cri);
		return count;
	}
	
	
	@Override
	public List<SuperintendentVO> selectSuperintendentListCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<SuperintendentVO> superintendentList = sqlSession.selectList("Member-Mapper.selectSearchSuperintendentList", cri, rowBounds);
		
		return superintendentList;
	}
	
	
	@Override
	public int selectSuperintendentCriteriaCount(SearchCriteria cri) throws SQLException {
		int cnt = sqlSession.selectOne("Member-Mapper.selectSearchSuperintendentListCount", cri);
		return cnt;
	}
	



}
