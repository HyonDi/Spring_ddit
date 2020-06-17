package com.bms.service.company;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.company.CompanyDao;
import com.bms.dto.company.CompanyVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;

public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao companyDao;
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	
	@Override
	public Map<String, Object> getCompanyAll(SearchCriteria cri) {

		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<CompanyVO> companyList=companyDao.selectCompanyAll(cri);
		
		//전체 board 개수
		int totalCount=companyDao.selectCompanyCriteriaTotalCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("companyList", companyList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
		
	}

	@Override
	public CompanyVO getCompnyByName(String company_charge_name) throws SQLException {
		CompanyVO company = companyDao.selectCompanyByName(company_charge_name);
		return company;
	}

}
