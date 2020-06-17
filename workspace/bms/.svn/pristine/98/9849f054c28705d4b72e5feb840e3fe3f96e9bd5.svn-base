package com.bms.service.suggestion;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bms.dto.suggestion.SuggestionVO;
import com.bms.request.paging.SearchCriteria;

public interface SuggestionService {

	SuggestionVO getsuggestionBySno(String suggestion_code) throws SQLException;
	
	//모바일 메인 건의사항 목록 가져오기.
	List<SuggestionVO> getSuggestionMain() throws SQLException;

	Map<String, Object> getSuggestionAll(SearchCriteria cri);

	void mobileSuggestionDelete(String suggestion_code);

	void mobileSuggestionModify(SuggestionVO suggestion);

	void mobileSuggestionRegist(SuggestionVO suggestion) throws SQLException;

}
