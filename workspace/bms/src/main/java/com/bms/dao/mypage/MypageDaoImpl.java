package com.bms.dao.mypage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.member.MemberVO;
import com.bms.dto.mypage.ContractVO;
import com.bms.dto.mypage.PaymentVO;
import com.bms.request.paging.SearchCriteria;

public class MypageDaoImpl implements MypageDao{
	
	//------------------개인정보 수정---------------------------------
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		
		MemberVO member = sqlSession.selectOne("Mypage-Mapper.selectMemberById", id);
		
		return member;
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		
		sqlSession.update("Mypage-Mapper.updateMemberResident", member);
		
	}



	@Override
	public void deleteMember(String id) throws SQLException {
		
		sqlSession.update("Mypage-Mapper.deleteMember", id);
		
	}

	@Override
	public int passCheck(MemberVO member) throws Exception {
		int result = sqlSession.selectOne("Mypage-Mapper.passCheck", member);
		
		return result;
	}

	
	//----------------------------계약--------------------------------------------------- 
	
	@Override
	public List<ContractVO> selectContractCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<ContractVO> ContractList 
					= sqlSession.selectList("Mypage-Mapper.selectSearchContractList", cri, rowBounds);
		
		return ContractList;
	}

	
	/*@Override
	public List<ContractVO> selectContractCriteriaByMemberCode(Map<String, Object> map) throws SQLException {
		

		SearchCriteria cri = (SearchCriteria) map.get("search");
		System.out.println(cri.toString());
		
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
	
		List<ContractVO> ContractList 
					= sqlSession.selectList("Mypage-Mapper.selectSearchContractListByMemberCode", map, rowBounds);
		
		System.out.println(ContractList.toString());
		
		return ContractList;
	}
	*/
/*	@Override
	public int selectContractCriteriaTotalCountByMemberCode(Map<String, Object> map) throws SQLException {

		int count = sqlSession.selectOne("Mypage-Mapper.selectSearchContractListCountByMemberCode",map);
		
		return count;
	}*/
	
	@Override
	public int selectContractCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Mypage-Mapper.selectSearchContractListCount", cri);
		
		return count;
	}


	@Override
	public ContractVO selectContractByContractCode(String contractCode) throws SQLException {
			ContractVO contractCC =
					sqlSession.selectOne("Mypage-Mapper.SelectContractListByConstractCode", contractCode);
		return contractCC;
	}

	@Override
	public ContractVO selectContractByMemberCode(int memberCode) throws SQLException {
		ContractVO contractMC =
				sqlSession.selectOne("Mypage-Mapper.SelectContractListByConstractCode", memberCode);
	return contractMC;
	}
	
	
	@Override
	public void insertContract(ContractVO contract) throws SQLException {
		sqlSession.update("Mypage-Mapper.insertContract", contract);
		
	}
	
	@Override
	public void updateContract(ContractVO contract) throws SQLException {
		sqlSession.update("Mypage-Mapper.updateContract", contract);
		
	}

	@Override
	public void deleteContract(String contractCode) throws SQLException {
		sqlSession.update("Mypage-Mapper.deleteContract", contractCode);
		
	}

	@Override
	public int selectContractSeqNext() throws SQLException {
		int seq_num = 
				sqlSession.selectOne("Mypage-Mapper.selectContractSeqNext");
		return seq_num;
	}

	
	//--------------------------------------------------------------------납부 조회
	
	@Override
	public List<PaymentVO> selectPaymentCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<PaymentVO> ContractList 
					= sqlSession.selectList("MypagePayment-Mapper.selectSearchPaymentList", cri, rowBounds);
		
		return ContractList;
	}

	@Override
	public int selectPaymentCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		
		int count = sqlSession.selectOne("MypagePayment-Mapper.selectSearchPaymentListCount", cri);
		
		return count;
	}

	@Override
	public PaymentVO selectPaymentByPaymentCode(String paymentCode) throws SQLException {
		PaymentVO paymentCC =
				sqlSession.selectOne("MypagePayment-Mapper.SelectPaymentListByPaymentCode", paymentCode);
	return paymentCC;
	}

	@Override
	public int selectPaymentSeqNext() throws SQLException {
		int seq_num = 
				sqlSession.selectOne("MypagePayment-Mapper.selectPaymentSeqNext");
		return seq_num;
	}

	@Override
	public void insertPayment(PaymentVO payment) throws SQLException {
		sqlSession.update("MypagePayment-Mapper.insertPayment", payment);
		
	}


	


	
}
