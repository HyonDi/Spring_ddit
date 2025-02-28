package com.groupware.service.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.groupware.dao.board.NoticeAttachDAO;
import com.groupware.dao.board.NoticeDAO;
import com.groupware.dto.NoticeAttachVO;
import com.groupware.dto.NoticeVO;
import com.groupware.request.PageMaker;
import com.groupware.request.SearchCriteria;

public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO=noticeDAO;		
	}
	
	@Autowired
	private NoticeAttachDAO attachDAO;
	public void setNoticeAttachDAO(NoticeAttachDAO attachDAO) {
		this.attachDAO=attachDAO;
	}

	@Override
	public Map<String,Object> getNoticeList(SearchCriteria cri) throws SQLException {
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(cri);
		List<NoticeVO> pointNoticeList = getPointNoticeList(cri);
	
		for(NoticeVO notice : noticeList) {
			List<NoticeAttachVO> attachList=attachDAO.selectAttachesByNno(notice.getNno());
			notice.setAttachList(attachList);
		}
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(noticeDAO.selectSearchNoticeListCount(cri));
		
		Map<String,Object> dataMap = new HashMap<String,Object>();
		dataMap.put("noticeList", noticeList);
		dataMap.put("pointNoticeList", pointNoticeList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public  List<NoticeVO> getPointNoticeList(SearchCriteria cri) throws SQLException {
		List<NoticeVO> noticeList = noticeDAO.selectPointNoticeList(cri);
		
		for(NoticeVO notice : noticeList) {
			List<NoticeAttachVO> attachList=attachDAO.selectAttachesByNno(notice.getNno());
			notice.setAttachList(attachList);
		}
		
		return noticeList;
	}

	@Override
	public NoticeVO getNotice(int nno) throws SQLException {
		NoticeVO notice = noticeDAO.selectNoticeByNno(nno);
		
		List<NoticeAttachVO> attachList=attachDAO.selectAttachesByNno(nno);
		notice.setAttachList(attachList);
		
		return notice;
	}

	@Override
	public void regist(NoticeVO notice) throws SQLException {
		
		int nno = noticeDAO.selectNoticeSeqNext();
		notice.setNno(nno);
		
		noticeDAO.insertNotice(notice);
		if(notice.getAttachList()!=null) {
			for(NoticeAttachVO attach:notice.getAttachList()) {
				attach.setNno(nno);
				attach.setAttacher(notice.getWriter());
				
				attachDAO.insertAttach(attach);
			}
		}
	}

	@Override
	public void modify(NoticeVO notice) throws SQLException {
		noticeDAO.updateNotice(notice);		
		
		attachDAO.deleteAllAttach(notice.getNno());
		if(notice.getAttachList()!=null) {
			for(NoticeAttachVO attach:notice.getAttachList()) {
				attach.setNno(notice.getNno());
				attach.setAttacher(notice.getWriter());
				
				attachDAO.insertAttach(attach);
			}
		}
	}

	@Override
	public void remove(int nno) throws SQLException {
		noticeDAO.deleteNotice(nno);
	}

	@Override
	public NoticeVO read(int nno) throws SQLException {
		NoticeVO notice=noticeDAO.selectNoticeByNno(nno);
		List<NoticeAttachVO> attachList=attachDAO.selectAttachesByNno(nno);
		notice.setAttachList(attachList);
		noticeDAO.increaseViewCnt(nno);
		
		return notice;
	}

}
