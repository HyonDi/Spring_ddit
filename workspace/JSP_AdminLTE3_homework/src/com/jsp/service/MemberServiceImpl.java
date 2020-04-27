package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;

public class MemberServiceImpl implements MemberService {

	// 싱글톤패턴 구현 - 의존주입에서는 지운다. classForName으로 하기위해!
/*	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberServiceImpl() {}
	public static MemberServiceImpl getInstance() {
		return instance;
	}*/
	
	// DAO 필요.
	private MemberDAO memberDAO;
	/* = MemberDAOImpl.getInstance();*/
	// 의존주입위해 주석.set메서드는 아래있었음.
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
	}
	
	
	
	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException {
		
		MemberVO member = memberDAO.selectMemberById(id); 
		// 여기가 null
		
		
		
		if(member == null) throw new NotFoundIDException();
		// throw 하면 여기서 메서드 끝난다. ( id가 없으면 여기서 메서드 끝남. )
		
		if(!pwd.equals(member.getPwd())) throw new InvalidPasswordException();
		// id는 존재, 비밀번호가 틀렸으면 여기서 메서드 끝난다.
		
		// return vo 하는 내용을 담으면 로그인성공시 세션에 바로 넣을 수 있을것 생각하기.
		
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> list = null;
		list = memberDAO.selectMemberList();
		return list;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);
	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		memberDAO.updateMember(member);
	}

	@Override
	public void remove(String id) throws SQLException {
		memberDAO.deleteMember(id);
	}
	@Override
	public void disabledMember(String id) throws SQLException {
		memberDAO.disabledMember(id);
	}
	@Override
	public void enabledMember(String id) throws SQLException {
		memberDAO.enabledMember(id);
	}
	@Override
	public Map<String, Object> getMemberList(SearchCriteria cri) throws SQLException {
		// 1. ListmemberVO(기존에 하던것. 그냥데이터만넘기는것.
		List<MemberVO> memberList = memberDAO.selectMemberList(cri);

		
		// 2. 페이지만들어서넘겨주기.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberDAO.selectMemberListCount(cri));
		
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("memberList", memberList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}
}
