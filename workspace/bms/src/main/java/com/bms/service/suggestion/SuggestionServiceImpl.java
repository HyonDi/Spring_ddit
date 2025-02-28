package com.bms.service.suggestion;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.suggestion.SuggestionDao;
import com.bms.dto.notice.NoticeVO;
import com.bms.dto.suggestion.SuggestionVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;

public class SuggestionServiceImpl implements SuggestionService{

	@Autowired
	private SuggestionDao suggestionDao;
	public void setSuggestionDao(SuggestionDao suggestionDao) {
		this.suggestionDao = suggestionDao;
	}
	
	@Override
	public Map<String, Object> getSuggestionAll(SearchCriteria cri) {
		
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<SuggestionVO> suggestionList=suggestionDao.selectsuggestionAll(cri);
		
		//전체 board 개수
		int totalCount=suggestionDao.selectSuggestionCriteriaTotalCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("suggestionList", suggestionList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}
	
	@Override
	public SuggestionVO getsuggestionBySno(String suggestion_code) throws SQLException {
		suggestionDao.increaseViewCnt(suggestion_code);
		SuggestionVO suggestion = suggestionDao.selectSuggestionBySno(suggestion_code);
		return suggestion;
	}

	@Override
	public List<SuggestionVO> getSuggestionMain() throws SQLException {
		List<SuggestionVO> suggestion = suggestionDao.getSuggestionMain();
		return suggestion;
	}

	@Override
	public void mobileSuggestionDelete(String suggestion_code) {
		suggestionDao.delSuggestion(suggestion_code);
		
	}

	@Override
	public void mobileSuggestionModify(SuggestionVO suggestion) {
		suggestionDao.modSuggestion(suggestion);
	}

	@Override
	public void mobileSuggestionRegist(SuggestionVO suggestion) throws SQLException {
		suggestionDao.RegSuggestion(suggestion);
	}
	
}
