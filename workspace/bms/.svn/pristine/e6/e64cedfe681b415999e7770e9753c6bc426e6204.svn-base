package com.bms.dao.suggestion;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.suggestion.SuggestionVO;
import com.bms.request.paging.SearchCriteria;

public interface SuggestionDao {
	
	//모바일 메인 건의사항 목록 가져오기.
	List<SuggestionVO> getSuggestionMain() throws SQLException;

	SuggestionVO selectSuggestionBySno(String suggestion_code);

	int selectSuggestionCriteriaTotalCount(SearchCriteria cri);

	List<SuggestionVO> selectsuggestionAll(SearchCriteria cri);
	
	// viewcnt 증가
	void increaseViewCnt(String suggestion_code) throws SQLException;

	void delSuggestion(String suggestion_code);

	void modSuggestion(SuggestionVO suggestion);

	void RegSuggestion(SuggestionVO suggestion) throws SQLException;

}
