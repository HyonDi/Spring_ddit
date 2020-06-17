package com.bms.dao.manager;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.manager.ManagerVO;
import com.bms.dto.member.ResidentVO;
import com.bms.request.paging.SearchCriteria;

public class ManagerDaoImpl implements ManagerDao{
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int selectManagerCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Manager-Mapper.selectSearchManagerListCount",cri);
		return count;
	}
	@Override
	public List<ManagerVO> selectManagerAll(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<ManagerVO> resident = sqlSession.selectList("Manager-Mapper.selectSearchManagerList",cri,rowBounds);
		
		return resident;
	}
	@Override
	public ManagerVO selectManagerByCode(String member_code) throws SQLException {
		ManagerVO manager = sqlSession.selectOne("Manager-Mapper.selectManagerByCode", member_code);
		return manager;
	}
	
	

}
