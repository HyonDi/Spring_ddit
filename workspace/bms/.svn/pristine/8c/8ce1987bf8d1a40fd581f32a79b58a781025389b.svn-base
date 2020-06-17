package com.bms.dao.notice;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bms.dto.community.CommunityVO;
import com.bms.dto.notice.NoticeVO;
import com.bms.request.paging.SearchCriteria;

public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<NoticeVO> selectNoticeAll(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<NoticeVO> notice = sqlSession.selectList("Notice-Mapper.selectSearchNoticeList",cri,rowBounds);
		
		return notice;
	}

	@Override
	public int selectNoticeCriteriaTotalCount(SearchCriteria cri) {
		int count = sqlSession.selectOne("Notice-Mapper.selectSearchNoticeListCount",cri);
		return count;
	}

	@Override
	public List<NoticeVO> selectNoticeMain() throws SQLException {
		List<NoticeVO> notice = sqlSession.selectList("Notice-Mapper.selectNoticeMain");
		return notice;
	}

	@Override
	public NoticeVO selectNoticeByNno(String notice_code) throws SQLException {
		NoticeVO notice = sqlSession.selectOne("Notice-Mapper.selectNoticeByNno", notice_code);
		return notice;
	}
	
	@Override
	public void increaseViewCnt(String notice_code) throws SQLException {
		sqlSession.update("Notice-Mapper.increaseViewCnt",notice_code);
	}
	
	

}
