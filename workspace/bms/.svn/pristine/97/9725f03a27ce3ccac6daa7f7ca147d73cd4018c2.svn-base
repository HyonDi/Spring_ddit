package com.bms.dao.manager;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.manager.ManagerVO;
import com.bms.request.paging.SearchCriteria;

public interface ManagerDao {
	
	int selectManagerCriteriaTotalCount(SearchCriteria cri) throws SQLException;

	List<ManagerVO> selectManagerAll(SearchCriteria cri) throws SQLException;

	ManagerVO selectManagerByCode(String member_code) throws SQLException;

}
