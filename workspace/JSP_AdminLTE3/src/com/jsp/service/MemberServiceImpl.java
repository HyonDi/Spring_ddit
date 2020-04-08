package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;

public class MemberServiceImpl implements MemberService {

	// 싱글톤패턴 구현
	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberServiceImpl() {}
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	
	// DAO 필요.
	private MemberDAO memberDAO = MemberDAOImpl.getInstance();
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
	}
	
	
	
	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException {
		MemberVO member = memberDAO.selectMemberById(id);
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

}
