package com.bms.dao.resident;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.member.ResidentVO;
import com.bms.request.paging.SearchCriteria;

public interface ResidentDao {

	int selectResidentCriteriaTotalCount(SearchCriteria cri) throws SQLException;

	List<ResidentVO> selectResidentAll(SearchCriteria cri) throws SQLException;

	ResidentVO selectResidentByCode(String member_code) throws SQLException;
	
}
