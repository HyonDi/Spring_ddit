package com.bms.service.manager;

import java.sql.SQLException;
import java.util.Map;

import com.bms.dto.manager.ManagerVO;
import com.bms.request.paging.SearchCriteria;

public interface ManagerService {

	Map<String, Object> getManagerAll(SearchCriteria cri) throws SQLException;
	
	ManagerVO getManagerByCode(String member_code) throws SQLException;
	
}
