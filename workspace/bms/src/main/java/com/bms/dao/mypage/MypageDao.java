package com.bms.dao.mypage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bms.dto.member.MemberVO;
import com.bms.dto.mypage.ContractVO;
import com.bms.dto.mypage.PaymentVO;
import com.bms.request.paging.SearchCriteria;

public interface MypageDao {
	//------------------------------------------------------개인정보 수정
	//id 받아서 member 조회
	MemberVO selectMemberById(String id) throws SQLException;
	
	// update member
	void updateMember(MemberVO member)throws SQLException;
	
	//id를 받아서 delete member
	void deleteMember(String id)throws SQLException;
	
	//패스워드 체크
	int passCheck(MemberVO member) throws Exception;
	
	//--------------------------------------------------------계약 조회
	
//	List<ContractVO> selectContractCriteriaByMemberCode(Map<String, Object> map) throws SQLException;
//	
//	int selectContractCriteriaTotalCountByMemberCode(Map<String, Object> map) throws SQLException;
	
	List<ContractVO> selectContractCriteria(SearchCriteria cri) throws SQLException;
	
	int selectContractCriteriaTotalCount(SearchCriteria cri) throws SQLException;
	
	//회원번호로 찾기
	ContractVO selectContractByMemberCode(int memberCode) throws SQLException;
	
	//계약게시판 번호로 찾기
	ContractVO selectContractByContractCode(String contractCode) throws SQLException;
	
	//insert
	void insertContract(ContractVO contract) throws SQLException;
	
	// update
	void updateContract(ContractVO contract)throws SQLException;
		
	//contractCode를 받아서 delete contract
	void deleteContract(String contractCode)throws SQLException;
	
	//contract_seq.nextval 가져오기
	int selectContractSeqNext() throws SQLException;
	
	//------------------------------------------------------- 납부 조회
	
	List<PaymentVO> selectPaymentCriteria(SearchCriteria cri) throws SQLException;
	
	int selectPaymentCriteriaTotalCount(SearchCriteria cri) throws SQLException;

	//계약게시판 번호로 찾기
	PaymentVO selectPaymentByPaymentCode(String paymentCode) throws SQLException;
	
	//insert
	void insertPayment(PaymentVO payment) throws SQLException;
	
	//payment_seq.nextval 가져오기
	int selectPaymentSeqNext() throws SQLException;

	
	
	
		
}
