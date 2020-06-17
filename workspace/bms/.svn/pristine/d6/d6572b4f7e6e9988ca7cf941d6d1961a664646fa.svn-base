package com.bms.dao.constract;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.constract.ConstractReqVO;
import com.bms.request.paging.SearchCriteria;

public interface ConstractDao {

	List<ConstractReqVO> selectConstractAll(SearchCriteria cri) throws SQLException;

	int selectConstractCriteriaTotalCount(SearchCriteria cri) throws SQLException;

	ConstractReqVO mobileConstractDetail(String constract_code) throws SQLException;
	
}
