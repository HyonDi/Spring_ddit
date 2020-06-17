package com.bms.dao.resident;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.member.ResidentVO;
import com.bms.request.paging.SearchCriteria;

public class ResidentDaoImple implements ResidentDao{
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int selectResidentCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Resident-Mapper.selectSearchResidentListCount",cri);
		return count;
	}
	@Override
	public List<ResidentVO> selectResidentAll(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<ResidentVO> resident = sqlSession.selectList("Resident-Mapper.selectSearchResidentList",cri,rowBounds);
		
		return resident;
	}
	@Override
	public ResidentVO selectResidentByCode(String member_code) throws SQLException {
		ResidentVO resident = sqlSession.selectOne("Resident-Mapper.selectResidentByCode", member_code);
		return resident;
	}

}
