package com.bms.service.payment;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bms.dto.notice.NoticeVO;
import com.bms.dto.payment.PaymentReqVO;
import com.bms.request.paging.SearchCriteria;

public interface PaymentService {
	
	Map<String, Object> getPaymentAll(SearchCriteria cri) throws SQLException;
	
	List<PaymentReqVO> mobilePaymentList(String member_code) throws SQLException;

	PaymentReqVO mobilePaymentDetail(String payment_code) throws SQLException;

}
