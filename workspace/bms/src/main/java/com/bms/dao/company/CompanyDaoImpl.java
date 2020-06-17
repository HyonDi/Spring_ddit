package com.bms.dao.company;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.company.CompanyVO;
import com.bms.dto.suggestion.SuggestionVO;
import com.bms.request.paging.SearchCriteria;

public class CompanyDaoImpl implements CompanyDao{
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int selectCompanyCriteriaTotalCount(SearchCriteria cri) {
		int count = sqlSession.selectOne("Company-Mapper.selectSearchCompanyListCount",cri);
		return count;
	}

	@Override
	public List<CompanyVO> selectCompanyAll(SearchCriteria cri) {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<CompanyVO> company = sqlSession.selectList("Company-Mapper.selectSearchCompanyList",cri,rowBounds);
		
		return company;
	}

	@Override
	public CompanyVO selectCompanyByName(String company_charge_name) {
		CompanyVO company = sqlSession.selectOne("Company-Mapper.selectCompanyByName",company_charge_name);
		return company;
	}

}
