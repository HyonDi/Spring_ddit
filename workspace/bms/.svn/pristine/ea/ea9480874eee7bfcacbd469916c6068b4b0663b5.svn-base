package com.bms.dao.suggestion;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.suggestion.SuggestionVO;
import com.bms.request.paging.SearchCriteria;

public class SuggestionDaoImpl implements SuggestionDao{

	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override	
	public List<SuggestionVO> selectsuggestionAll(SearchCriteria cri) {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<SuggestionVO> suggestion = sqlSession.selectList("Suggestion-Mapper.selectSearchSuggestionList",cri,rowBounds);
		
		return suggestion;
	}
	
	@Override
	public SuggestionVO selectSuggestionBySno(String suggestion_code) {
		SuggestionVO suggestion = sqlSession.selectOne("Suggestion-Mapper.selectSuggestionBySno", suggestion_code);
		return suggestion;
	}
	
	@Override
	public int selectSuggestionCriteriaTotalCount(SearchCriteria cri) {
		int count = sqlSession.selectOne("Suggestion-Mapper.selectSearchSuggestionListCount",cri);
		return count;
	}

	@Override
	public List<SuggestionVO> getSuggestionMain() throws SQLException {
		List<SuggestionVO> suggestion = sqlSession.selectList("Suggestion-Mapper.selectSuggestionMain");
		return suggestion;
	}
	
	@Override
	public void increaseViewCnt(String suggestion_code) throws SQLException {
		sqlSession.update("Suggestion-Mapper.increaseViewCnt",suggestion_code);
	}

	@Override
	public void delSuggestion(String suggestion_code) {
		sqlSession.delete("Suggestion-Mapper.deleteSuggestion", suggestion_code);
	}

	@Override
	public void modSuggestion(SuggestionVO suggestion) {
		sqlSession.update("Suggestion-Mapper.modifySuggestion", suggestion);
	}

	@Override
	public void RegSuggestion(SuggestionVO suggestion) throws SQLException {
		sqlSession.update("Suggestion-Mapper.registSuggestion", suggestion);
	}
	
}
