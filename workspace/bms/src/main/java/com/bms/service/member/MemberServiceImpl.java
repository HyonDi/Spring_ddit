package com.bms.service.member;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.member.MemberDao;
import com.bms.dto.facility.ResponsibilityFacilityVO;
import com.bms.dto.item.ItemVO;
import com.bms.dto.member.CareerVO;
import com.bms.dto.member.MemberVO;
import com.bms.dto.member.OwnerVO;
import com.bms.dto.member.ResidentVO;
import com.bms.dto.member.SuperintendentVO;
import com.bms.dto.task.ResponsibilityTaskVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;
import com.bms.request.reply.CommunityReplyRequest;


public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public void login(String id, String pwd) throws SQLException {	
		memberDao.selectMemberById(id);
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDao.selectMemberById(id);
		return member;
	}

	@Override
	public MemberVO getPhoneCheckMember(String member_phone) throws SQLException {
		MemberVO member = memberDao.selectMemberByPhone(member_phone);
		return member;
	}

	@Override
	public String getMemberId(MemberVO member) throws SQLException {
		String id = memberDao.selectGetMemberId(member);
		return id;
	}

	

	@Override
	public String getMemberPassword(MemberVO member) throws SQLException, MessagingException, UnsupportedEncodingException{
		String pwd = memberDao.selectGetMemberPassword(member);
		
		return pwd;
	}

	@Override
	public void changePassword(MemberVO member) throws SQLException {
		memberDao.changePassword(member);
	}

	@Override
	public int selectPasswordUpdateChk(MemberVO member) throws SQLException {
		int chk = memberDao.selectPasswordUpdateChk(member);
		return chk;
	}

	@Override
	public String getMemberNameByCode(String member_code) throws SQLException {
		String member = memberDao.selectMemberNameByCode(member_code);
		return member;
	}
	
	
	// 06.11 강현지

	
	@Override
	public List<ResidentVO> selectResidentList(String member_up_code) throws SQLException {
		return memberDao.selectResidentList(member_up_code);
	}

	@Override
	public int ResidentCount(String member_up_code) throws SQLException {
		int count = memberDao.ResidentCount(member_up_code);
		return count;
	}

	//관리인 조회
	@Override
	public List<SuperintendentVO> selectSuperintendentList(String member_code) throws SQLException {
		return memberDao.selectSuperintendentList(member_code);
	}

	//관리인 인원수 조회
	@Override
	public int SuperintendentCount(String member_code) throws SQLException {
		int count = memberDao.SuperintendentCount(member_code);
		return count;
	}

	@Override
	public List<ResidentVO> selectSearchResidentList(String member_up_code) throws SQLException {
		List<ResidentVO> residentList = memberDao.selectSearchResidentList(member_up_code);
		return residentList;
	}

	@Override
	public List<SuperintendentVO> selectSearchSuperintendentList(String member_up_code) throws SQLException {
		List<SuperintendentVO> superintendentList = memberDao.selectSearchSuperintendentList(member_up_code);
		return superintendentList;
	}

	@Override
	public ResidentVO selectResidentById(String member_id) throws SQLException {
		ResidentVO resident = memberDao.selectResidentById(member_id);
		return resident;
	}

	@Override
	public ResidentVO selectResidentByCode(String member_code) throws SQLException {
		ResidentVO resident = memberDao.selectResidentByCode(member_code);
		return resident;
	}

	@Override
	public SuperintendentVO selectSuperintendentById(String member_id) throws SQLException {
		SuperintendentVO superintendent = memberDao.selectSuperintendentById(member_id);
		return superintendent;
	}

	@Override
	public SuperintendentVO selectSuperintendentByCode(String member_code) throws SQLException {
		SuperintendentVO superintendent = memberDao.selectSuperintendentByCode(member_code);
		return superintendent;
	}

	int memberSeq =0;
	@Override
	public void insertMember(MemberVO memberVO) throws SQLException {
		memberSeq = memberDao.selectMemberSeqNext();
		
		String memberCode = "mem" + memberSeq;
		memberVO.setMember_code(memberCode);
		
		memberDao.insertMember(memberVO);
		/*return memberVO;*/
	}

	@Override
	public void insertResident(ResidentVO resident) throws SQLException {
		String memberCode = "mem" + memberSeq;
		resident.setMember_code(memberCode);
		memberDao.insertResident(resident);
		
	}

	@Override
	public void insertSuperintendent(SuperintendentVO superintendent) throws SQLException {
		
		String memberCode = "mem" + memberSeq;
		superintendent.setMember_code(memberCode);
		memberDao.insertSuperintendent(superintendent);
		
	}

	@Override
	public void insertOwner(OwnerVO owner) throws SQLException {
		memberDao.insertOwner(owner);
		
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		memberDao.updateMember(member);
		
	}

	@Override
	public void updateResident(ResidentVO resident) throws SQLException {
		memberDao.updateResident(resident);
		
	}

	@Override
	public void updateSuperintendent(SuperintendentVO superintendent) throws SQLException {
		memberDao.updateSuperintendent(superintendent);
		
	}

	@Override
	public void updateOwner(OwnerVO owner) throws SQLException {
		memberDao.updateOwner(owner);
		
	}

	@Override
	public void deleteMember(String member_code) throws SQLException {
		memberDao.deleteMember(member_code);
		
	}

	@Override
	public void deleteResident(String member_code) throws SQLException {
		memberDao.deleteResident(member_code);
		
	}

	@Override
	public void deleteSuperintendent(String member_code) throws SQLException {
		memberDao.deleteSuperintendent(member_code);
		
	}

	@Override
	public void deleteOwner(String member_code) throws SQLException {
		memberDao.deleteOwner(member_code);
		
	}

	@Override
	public void disableResident(String member_code) throws SQLException {
		memberDao.disableResident(member_code);
		
	}

	@Override
	public void updateRecentLoginTime(String member_code) throws SQLException {
		memberDao.updateRecentLoginTime(member_code);
		
	}

	@Override
	public int selectMemberSeqNext() throws SQLException {
		int seq = memberDao.selectMemberSeqNext();
		return seq;
	}
	
	@Override
	public int selectMemberSeqCurrnt() throws SQLException {
		int seq = memberDao.selectMemberSeqCurrnt();
		return seq;
	}

	@Override
	public List<CareerVO> selectCareer(String member_code) throws SQLException {
		List<CareerVO> career = memberDao.selectCareer(member_code);
		return career;
	}

	@Override
	public List<ResponsibilityFacilityVO> selectResponsibilityFacility(String member_code) throws SQLException {
		List<ResponsibilityFacilityVO> responsibilityFacility = memberDao.selectResponsibilityFacility(member_code);
		return responsibilityFacility;
	}

	@Override
	public List<ResponsibilityTaskVO> selectResponsibilityTask(String member_code) throws SQLException {
		List<ResponsibilityTaskVO> responsibilityTask = memberDao.selectResponsibilityTask(member_code);
		return responsibilityTask;
	}

	@Override
	public int selectJournalCount(String member_code) throws SQLException {
		int count = memberDao.selectJournalCount(member_code);
		return count;
	}

	@Override
	public List<CommunityReplyRequest> selectCommunityReplyRequest(String member_code) throws SQLException {
		List<CommunityReplyRequest> replyReq = memberDao.selectCommunityReplyRequest(member_code);
		return replyReq;
	}

	@Override
	public MemberVO getMemberAllByCode(String member_code) throws SQLException {
		MemberVO member = memberDao.selectMemberAllByCode(member_code);
		return member;
	}

	@Override
	public Map<String, Object> getResidentList(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<ResidentVO> residentList=memberDao.selectResidentListCriteria(cri);
		
		//전체 board 개수
		int totalCount=memberDao.selectResidentCriteriaCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("residentList", residentList);
		dataMap.put("pageMaker",pageMaker);
		
		
		return dataMap;
	}

	@Override
	public Map<String, Object> getSuperintendentList(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<SuperintendentVO> superintendentList=memberDao.selectSuperintendentListCriteria(cri);
		
		//전체 board 개수
		int totalCount=memberDao.selectSuperintendentCriteriaCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("superintendentList", superintendentList);
		dataMap.put("pageMaker",pageMaker);
		
		
		return dataMap;
	}
}
