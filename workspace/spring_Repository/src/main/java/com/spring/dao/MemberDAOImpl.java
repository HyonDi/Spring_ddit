package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.spring.dto.MemberVO;
import com.spring.request.SearchCriteria;


public class MemberDAOImpl implements MemberDAO {
	
	// 주입시의 reflection때문에
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// sqlSessionTemplate이 transaction이용해서 session을 자동으로 열고 닫아준다.
	
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		List<MemberVO> memberList = sqlSession.selectList("Member-Mapper.selectMemberList", null);
		return memberList;
	}
	
	@Override
	public List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MemberVO> memberList = null;
		
		memberList = sqlSession.selectList("Member-Mapper.selectSearchMemberList", cri, rowBounds);
		return memberList;
	}
	
	@Override
	public int selectMemberListCount() throws SQLException {
		int cnt = sqlSession.selectOne("Member-Mapper.selectMemberListCount",null);
		return cnt;
	}
	
	@Override
	public int selectMemberListCount(SearchCriteria cri) throws SQLException {
		int cnt = sqlSession.selectOne("Member-Mapper.selectSearchMemberListCount",cri);
		return cnt;
	}
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO vo = sqlSession.selectOne("Member-Mapper.selectMemberById",id);
		return vo;
	}
	@Override
	public void insertMember(MemberVO member) throws SQLException {
		sqlSession.update("Member-Mapper.insertMember",member);
		
	}
	@Override
	public void updateMember(MemberVO member) throws SQLException {
		sqlSession.update("Member-Mapper.updateMember", member);
	}
	@Override
	public void deleteMember(String id) throws SQLException {
		sqlSession.update("Member-Mapper.deleteMember",id);
	}
	@Override
	public void disabledMember(String id) throws SQLException {
		sqlSession.update("Member-Mapper.disabledMember",id);
	}
	@Override
	public void enabledMember(String id) throws SQLException {
		sqlSession.update("Member-Mapper.enabledMember",id);
	}

}
