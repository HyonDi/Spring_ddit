package com.daejeon.dao;

import java.sql.SQLException;
import java.util.List;

import com.daejeon.dto.AttachVO;

public interface AttachDAO {
	
	public List<AttachVO> selectAttachesByBno(int bno)throws SQLException;
	public AttachVO selectAttachByAno(int ano)throws SQLException;
	
	public void insertAttach(AttachVO attach) throws SQLException;

	public void deleteAttach(int ano) throws SQLException;

	public void deleteAllAttach(int bno)throws SQLException;
	
	public int getAttachCntByBno(int bno) throws SQLException;
}






