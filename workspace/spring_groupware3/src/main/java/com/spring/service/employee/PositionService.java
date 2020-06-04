package com.spring.service.employee;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.PositionVO;

public interface PositionService {

	List<PositionVO> getPosotionList()throws SQLException;
	
}
