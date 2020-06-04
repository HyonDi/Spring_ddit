package com.spring.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.PdsShareVO;

public interface PdsShareDAO {
	
	
	List<PdsShareVO> selectPdsShareListByPno(int pno)throws SQLException;
	void insertPdsShare(PdsShareVO psv)throws SQLException;
	void deletePdsShare(int pno)throws SQLException;
	
}
