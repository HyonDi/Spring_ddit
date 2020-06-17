package com.bms.dao.company;

import java.util.List;

import com.bms.dto.company.CompanyVO;
import com.bms.request.paging.SearchCriteria;

public interface CompanyDao {
	
	int selectCompanyCriteriaTotalCount(SearchCriteria cri);

	List<CompanyVO> selectCompanyAll(SearchCriteria cri);
	
	CompanyVO selectCompanyByName(String company_charge_name);

}
