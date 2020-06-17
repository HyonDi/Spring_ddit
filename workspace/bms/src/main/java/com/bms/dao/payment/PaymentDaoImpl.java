package com.bms.dao.payment;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.notice.NoticeVO;
import com.bms.dto.payment.PaymentReqVO;
import com.bms.request.paging.SearchCriteria;

public class PaymentDaoImpl implements PaymentDao{
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<PaymentReqVO> mobilePaymentList(String member_code) throws SQLException {
		List<PaymentReqVO> payment = sqlSession.selectList("PaymentReq-Mapper.mobilePaymentList",member_code);
		return payment;
	}

	@Override
	public List<PaymentReqVO> selectPaymentAll(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<PaymentReqVO> payment = sqlSession.selectList("PaymentReq-Mapper.selectSearchPaymentList",cri,rowBounds);
		
		return payment;
	}

	@Override
	public int selectPaymentCriteriaTotalCount(SearchCriteria cri) {
		int count = sqlSession.selectOne("PaymentReq-Mapper.selectSearchPaymentListCount",cri);
		return count;
	}

	@Override
	public PaymentReqVO selectPaymentAll(String payment_code) throws SQLException {
		PaymentReqVO payment = sqlSession.selectOne("PaymentReq-Mapper.mobilePaymentList",payment_code);
		return payment;
	}
	

}
