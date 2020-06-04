package com.spring.dao.employee;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.PositionVO;

public interface PositionDAO {

	
	List<PositionVO> selectPositionList()throws SQLException;
	
}
