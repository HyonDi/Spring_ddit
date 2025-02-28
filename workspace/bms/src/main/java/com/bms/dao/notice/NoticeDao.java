package com.bms.dao.notice;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.notice.NoticeVO;
import com.bms.request.paging.SearchCriteria;

public interface NoticeDao {
	
	//웹 공지사항 목록 가져오기.
	List<NoticeVO> selectNoticeAll(SearchCriteria cri) throws SQLException;

	//모바일 공지사항 목록 가져오기.
	List<NoticeVO> selectNoticeMain() throws SQLException;
	
	//페이징처리 전체 갯수.
	int selectNoticeCriteriaTotalCount(SearchCriteria cri);

	NoticeVO selectNoticeByNno(String notice_code) throws SQLException;
	
	// viewcnt 증가
	void increaseViewCnt(String notice_code) throws SQLException;

}
