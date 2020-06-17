package com.bms.service.payment;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.payment.PaymentDao;
import com.bms.dto.notice.NoticeVO;
import com.bms.dto.payment.PaymentReqVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;

public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentDao paymentDao;
	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}
	
	@Override
	public List<PaymentReqVO> mobilePaymentList(String member_code) throws SQLException {
		List<PaymentReqVO> payment = paymentDao.mobilePaymentList(member_code);
		return payment;
	}

	@Override
	public Map<String, Object> getPaymentAll(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<PaymentReqVO> paymentList=paymentDao.selectPaymentAll(cri);
		
		//전체 board 개수
		int totalCount=paymentDao.selectPaymentCriteriaTotalCount(cri);
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("paymentList", paymentList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public PaymentReqVO mobilePaymentDetail(String payment_code) throws SQLException {
		PaymentReqVO payment = paymentDao.selectPaymentAll(payment_code);
		return payment;
	}
	  
}
