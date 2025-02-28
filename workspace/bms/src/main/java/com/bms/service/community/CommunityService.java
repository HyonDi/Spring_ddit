package com.bms.service.community;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bms.dto.community.CommunityVO;
import com.bms.request.paging.SearchCriteria;

public interface CommunityService {
	
	//모바일 커뮤니티 목록 가져오기.
	Map<String, Object> getCommunityAll(SearchCriteria cri) throws SQLException;
	
	//모바일 메인 커뮤니티 목록 가져오기.
	List<CommunityVO> getCommunityMain() throws SQLException;
	
	//모바일 커뮤니티 상세정보 가져오기
	CommunityVO getCommunityByCno(String community_code) throws SQLException;

	void mobileCommunityRegist(CommunityVO community) throws SQLException;

	void mobileCommunityDelete(String community_code) throws SQLException;

	void mobileCommunityModify(CommunityVO community) throws SQLException;

	CommunityVO getCommunityByCnoNoCnt(String community_code) throws SQLException;

}
