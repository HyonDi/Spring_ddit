package com.bms.dao.community;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.community.CommunityVO;
import com.bms.dto.notice.NoticeVO;
import com.bms.request.paging.SearchCriteria;

public class CommunityDaoImpl implements CommunityDao {

	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<CommunityVO> selectCommunityMain() throws SQLException {
		List<CommunityVO> community = sqlSession.selectList("Community-Mapper.selectCommunityMain");
		return community;
	}
	@Override
	public List<NoticeVO> selectCommunityAll(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<NoticeVO> community = sqlSession.selectList("Community-Mapper.selectSearchCommunityList",cri,rowBounds);
		
		return community;
	}
	@Override
	public int selectCommunityCriteriaTotalCount(SearchCriteria cri) throws SQLException{
		int count = sqlSession.selectOne("Community-Mapper.selectSearchCommunityListCount",cri);
		return count;
	}
	@Override
	public CommunityVO selectCommunityByCno(String community_code) throws SQLException {
		CommunityVO community = sqlSession.selectOne("Community-Mapper.selectCommunityByCno", community_code);
		return community;
	}
	@Override
	public void mobileCommunityRegist(CommunityVO community) throws SQLException {
		sqlSession.update("Community-Mapper.mobileCommunityRegist", community);
	}
	
	@Override
	public void increaseViewCnt(String community_code) throws SQLException {
		sqlSession.update("Community-Mapper.increaseViewCnt",community_code);
	}
	@Override
	public void mobileCommunityDelete(String community_code) throws SQLException {
		sqlSession.delete("Community-Mapper.mobileCommunityDelete", community_code);
	}
	@Override
	public void mobileCommunityModify(CommunityVO community) throws SQLException {
		sqlSession.update("Community-Mapper.mobilecommunityModify", community);
	}
	
}
