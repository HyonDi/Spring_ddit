package com.bms.service.notice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bms.dao.notice.NoticeDao;
import com.bms.dto.notice.NoticeVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;

public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@Override
	public Map<String,Object> getNoticeAll(SearchCriteria cri) throws SQLException {
		
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<NoticeVO> noticeList=noticeDao.selectNoticeAll(cri);
		
		//전체 board 개수
		int totalCount=noticeDao.selectNoticeCriteriaTotalCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("noticeList", noticeList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public List<NoticeVO> getNoticeMain() throws SQLException {
		List<NoticeVO> notice = noticeDao.selectNoticeMain();
		return notice;
	}

	@Override
	public NoticeVO getnoticeByNno(String notice_code) throws SQLException {
		noticeDao.increaseViewCnt(notice_code);
		NoticeVO notice = noticeDao.selectNoticeByNno(notice_code);
		return notice;
	}

}
