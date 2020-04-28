package com.daejeon.dao;

import java.sql.SQLException;
import java.util.List;

import com.daejeon.dto.ReplyVO;
import com.daejeon.request.SearchCriteria;

public interface ReplyDAO {
	
	void insertReply(ReplyVO reply)throws SQLException;
	void updateReply(ReplyVO reply)throws SQLException;
	void deleteReply(int rno)throws SQLException;
	
	int selectReplySeqNextValue() throws SQLException;
	List<ReplyVO> selectReplyListPage(int bno,SearchCriteria cri) throws SQLException;
	int countReply(int bno) throws SQLException;
}





