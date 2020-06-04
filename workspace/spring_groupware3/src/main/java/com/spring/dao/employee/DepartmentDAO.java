package com.spring.dao.employee;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.DepartmentVO;

public interface DepartmentDAO {

	
	List<DepartmentVO> selectDeptList()throws SQLException;
}
