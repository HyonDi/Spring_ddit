package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;

public class MemberDAOImpl implements MemberDAO {

	/*// listener 사용하기 위해 싱글톤 주석
	private static MemberDAOImpl instance = new MemberDAOImpl();
	private MemberDAOImpl() {}
	public static MemberDAOImpl getInstance() {
		return instance;
	}*/
	
	//SqlSessionFactory
	private SqlSessionFactory sessionFactory;
	/*= OracleMyBatisSqlSessionFactoryBuilder.getSqlSessionFactory();*/
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		//메서드마다 독립적인 세션을 가진다
		SqlSession session = sessionFactory.openSession(); //openSession() : 기본값 false(셀렉트문이기때문에 오토커밋안함)
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList", null); //null : 넘어가는 파라미터가 없다고 명시적으로 보여주기위해 작성
		session.close();
		return memberList;
	}

	@Override
	public int selectMemberListCount() throws SQLException {
		int count = 0;
		SqlSession session = sessionFactory.openSession();
		count = session.selectOne("Member-Mapper.selectMemberListCount", null);
		session.close();
		return count;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", id);
		session.close();
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		SqlSession session = sessionFactory.openSession(true); //true를 주면 오토커밋됨(세션을 클로즈할때 커밋시킴)
		session.update("Member-Mapper.insertMember", member);
		session.close();
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		SqlSession session = sessionFactory.openSession(true); //true를 주면 오토커밋됨(세션을 클로즈할때 커밋시킴)
		session.update("Member-Mapper.updateMember", member);
		session.close();
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		SqlSession session = sessionFactory.openSession(true); //true를 주면 오토커밋됨(세션을 클로즈할때 커밋시킴)
		session.update("Member-Mapper.deleteMember", id);
		session.close();
	}
	@Override
	public void disabledMember(String id) throws SQLException {
		SqlSession sesssion = sessionFactory.openSession(true);
		sesssion.update("Member-Mapper.disabledMember", id);
		sesssion.close();
	}
	@Override
	public void enabledMember(String id) throws SQLException {
		SqlSession sesssion = sessionFactory.openSession(true);
		sesssion.update("Member-Mapper.enabledMember", id);
		sesssion.close();
	}

	@Override
	public List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException {
		SqlSession sesssion = sessionFactory.openSession();
		
		int offset = cri.getPageStartRowNum(); //offset : 기준 (한 페이지의 첫 글번호)
		int limit = cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset, limit); //매퍼에 얘를 보내면 정해준 개수만큼 데이터를 알아서 잘라 보내줌
		
		List<MemberVO> memberList = null;
		
		memberList = sesssion.selectList("Member-Mapper.selectSearchMemberList", cri, rowBounds);
		
		sesssion.close();
		return memberList;
	}

	@Override
	public int selectMemberListCount(SearchCriteria cri) throws SQLException {
		int count = 0;
		
		SqlSession sesssion = sessionFactory.openSession(true);
		
		count = sesssion.selectOne("Member-Mapper.selectSearchMemberListCount", cri);
		
		sesssion.close();
		return count;
	}

}
