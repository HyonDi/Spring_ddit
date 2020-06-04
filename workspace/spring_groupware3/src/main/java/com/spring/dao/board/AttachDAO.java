package com.spring.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.PdsAttachVO;

public interface AttachDAO {
	
	public List<PdsAttachVO> selectAttachesByPno(int pno)throws SQLException;
	public PdsAttachVO selectAttachByAno(int ano)throws SQLException;
	
	public void insertAttach(PdsAttachVO attach) throws SQLException;

	public void deleteAttach(int ano) throws SQLException;

	public void deleteAllAttach(int pno)throws SQLException;
}






