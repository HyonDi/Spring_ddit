package com.bms.dao.payment;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.notice.NoticeVO;
import com.bms.dto.payment.PaymentReqVO;
import com.bms.request.paging.SearchCriteria;

public interface PaymentDao {
	
	List<PaymentReqVO> selectPaymentAll(SearchCriteria cri) throws SQLException;

	int selectPaymentCriteriaTotalCount(SearchCriteria cri);
	
	List<PaymentReqVO> mobilePaymentList(String member_code) throws SQLException;

	PaymentReqVO selectPaymentAll(String payment_code) throws SQLException;

}
