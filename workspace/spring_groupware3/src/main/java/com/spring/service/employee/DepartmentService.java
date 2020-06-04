package com.spring.service.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.spring.dto.DepartmentVO;
import com.spring.dto.DynatreeVO;

public interface DepartmentService {

	
	List<DepartmentVO> getDeptList()throws SQLException;
	
	List<DynatreeVO> getDynaTree(String key)throws SQLException;
}
