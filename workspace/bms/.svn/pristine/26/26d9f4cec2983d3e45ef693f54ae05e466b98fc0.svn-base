package com.bms.dao.constract;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.constract.ConstractReqVO;
import com.bms.request.paging.SearchCriteria;

public class ConstractDaoImpl implements ConstractDao{

	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<ConstractReqVO> selectConstractAll(SearchCriteria cri) throws SQLException {
		cri.setPerPageNum(50);
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<ConstractReqVO> constract = sqlSession.selectList("ConstractReq-Mapper.selectSearchConstractList",cri,rowBounds);
		
		return constract;
	}

	@Override
	public int selectConstractCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("ConstractReq-Mapper.selectSearchConstractListCount",cri);
		return count;
	}

	@Override
	public ConstractReqVO mobileConstractDetail(String constract_code) throws SQLException {
		ConstractReqVO constract = sqlSession.selectOne("ConstractReq-Mapper.mobileConstractList", constract_code);
		return constract;
	}

}
