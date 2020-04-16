package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	
	// 팩토리를 가져온다.(sqlSessionFactory)
	private SqlSessionFactory slqSessionFactory;
	/* = OracleMyBatisSqlSessionFactoryBuilder.getSqlSessionFactory();*/
	//의존주입위해 주석함. 따라서 셋메서드도 필요하다
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionfactory) {
		this.slqSessionFactory = sqlSessionfactory;
	}
	
	
	// 싱글톤패턴 -> if null 그부분 안넣어도되는걸까?? 의존주입위해 지운다.
/*	private static MemberDAOImpl instance = new MemberDAOImpl();
	//private MemberDAOImpl() {}
	
	public MemberDAOImpl getInstance() {
		return instance;
	}*/
	
	
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		SqlSession session = slqSessionFactory.openSession();
		// openSession 의 파라미터로 true를 주면 auto commit 하게됨.
		
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList", null);
		// null 준이유는 있는데 파라미터 안준건지, 없어서 안준건지 명시적으로 확인시키려고.
		
		session.close();
		// 세션을 메서드마다 열고 닫아서 독립적으로 사용할 수 있음.
		
		return memberList;
	}

	@Override
	public int selectMemberListCount() throws SQLException {
		int count = 0;
		SqlSession session = slqSessionFactory.openSession();
		
		try {
			count = session.selectOne("Member-Mapper.selectMemberListCount", null);
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return count;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		SqlSession session = slqSessionFactory.openSession();
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", id);
		session.close();
		
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		// transaction 생각해서. 
		// openSession 기본값은 false.(자동커밋X)
		// 메서드가 close될때 진행했던 sql문을 커밋을 해야함. 그래서 true를 줬다.(select문은 commit할 필요 없음.)
		
		SqlSession session = slqSessionFactory.openSession(true);
		session.update("Member-Mapper.insertMember", member);
		session.close();
		
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		SqlSession session = slqSessionFactory.openSession(true);
		session.update("Member-Mapper.updateMember", member);
		session.close();
		
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		SqlSession session = slqSessionFactory.openSession(true);
		session.update("Member-Mapper.deleteMember", id);
		session.close();
		
	}
	@Override
	public void disabledMember(String id) throws SQLException {
		SqlSession session = slqSessionFactory.openSession(true);
		session.update("Member-Mapper.disabledMember", id);
		session.close();
	}
	@Override
	public void enabledMember(String id) throws SQLException {
		SqlSession session = slqSessionFactory.openSession(true);
		session.update("Member-Mapper.enabledMember", id);
		session.close();
	}

}
