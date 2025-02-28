package com.bms.service.mypage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.mypage.MypageDao;
import com.bms.dto.member.MemberVO;
import com.bms.dto.mypage.ContractVO;
import com.bms.dto.mypage.PaymentVO;
import com.bms.request.paging.PageMaker;
import com.bms.request.paging.SearchCriteria;

public class MypageServiceImpl implements MypageService{

	//--------------------------------------개인정보 수정
	@Autowired
	private MypageDao mypageDao;
	public void setMypageDao(MypageDao mypageDao) {
		this.mypageDao = mypageDao;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		
		MemberVO member = mypageDao.selectMemberById(id);
		return member;
	}

	@Override
	public void modify(MemberVO member) throws SQLException {

		mypageDao.updateMember(member);
			
	}

	@Override
	public void remove(String id) throws SQLException {
		
		mypageDao.deleteMember(id);
		
	}

	@Override
	public int passCheck(MemberVO member) throws Exception {
		int result = mypageDao.passCheck(member);
		return result;
	}

	
	//--------------------------------------------계약

	@Override
	public ContractVO getContract(String contractCode) throws SQLException {
		ContractVO contract = mypageDao.selectContractByContractCode(contractCode);
		return contract;
	}

	@Override
	public ContractVO getContractForModify(String contractCode) throws SQLException {
		ContractVO contract = mypageDao.selectContractByContractCode(contractCode);
		return contract;
	}

	@Override
	public void write(ContractVO contract) throws SQLException {
		int constractCode = mypageDao.selectContractSeqNext();
		
		String constract_code = "CT" + constractCode;
		
		contract.setConstract_code(constract_code);
		
	}

	@Override
	public void modify(ContractVO contract) throws SQLException {
		mypageDao.updateContract(contract);
		
	}

	@Override
	public void removeContract(String contractCode) throws SQLException {
		mypageDao.deleteContract(contractCode);
		
	}
	
	@Override
	public Map<String, Object> getContractList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		
		
		List<ContractVO> constractList = mypageDao.selectContractCriteria(cri);
		
		int totalCount = mypageDao.selectContractCriteriaTotalCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("constractList", constractList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}
	
/*	@Override
	public Map<String, Object> getContractListByMemberCode(Map<String, Object> map) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<ContractVO> constractList = mypageDao.selectContractCriteriaByMemberCode(map);
		
		SearchCriteria cri = (SearchCriteria) map.get("search");
		System.out.println("서비스 : " + cri.toString());
		
		int totalCount = mypageDao.selectContractCriteriaTotalCountByMemberCode(map);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("constractList", constractList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}*/
	
	//-----------------------------------------------------납부
	
	@Override
	public Map<String, Object> getPaymentList(SearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
			
		List<PaymentVO> paymentList = mypageDao.selectPaymentCriteria(cri);
		
		int totalCount = mypageDao.selectPaymentCriteriaTotalCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("paymentList", paymentList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public PaymentVO getPayment(String paymentCode) throws SQLException {
		PaymentVO payment = mypageDao.selectPaymentByPaymentCode(paymentCode);
		return payment;
	}

	
	@Override
	public void regist(PaymentVO payment) throws SQLException {
		
		int paymentCode = mypageDao.selectPaymentSeqNext();
		
		String payment_code = "PM" + paymentCode;
		
		payment.setPayment_code(payment_code);
		
		mypageDao.insertPayment(payment);
		
	}

}
