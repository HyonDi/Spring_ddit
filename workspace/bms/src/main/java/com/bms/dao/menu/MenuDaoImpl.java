package com.bms.dao.menu;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dto.member.MemberVO;
import com.bms.dto.menu.MenuVO;

public class MenuDaoImpl implements MenuDao{
	
	@Autowired
	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<MenuVO> selectUnderMenu(String menu_up_code) throws SQLException {
		List<MenuVO> underMenuList = session.selectList("Menu-Mapper.selectUnderMenu",menu_up_code);
		return underMenuList;
	}



}
