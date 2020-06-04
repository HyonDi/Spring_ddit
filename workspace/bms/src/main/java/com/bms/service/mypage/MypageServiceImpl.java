package com.bms.service.mypage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.bms.dao.mypage.MypageDao;
import com.bms.dto.member.MemberVO;

public class MypageServiceImpl implements MypageService{
	
	private MypageDao mypageDao;
	public void setMypageDao(MypageDao mypageDao) {
		this.mypageDao = mypageDao;
	}



	@Override
	public Map<String, Object> getMember(String id) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		MemberVO member = mypageDao.selectMemberById(id);
		
		dataMap.put("member", member);
				
		
		return dataMap;
	}

}
