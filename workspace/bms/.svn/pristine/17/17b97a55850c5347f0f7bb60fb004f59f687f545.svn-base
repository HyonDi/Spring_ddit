package com.bms.service.menu;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bms.dao.member.MemberDao;
import com.bms.dao.menu.MenuDao;
import com.bms.dto.member.MemberVO;
import com.bms.dto.menu.MenuVO;

public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDao menuDao;
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}


	@Override
	public List<MenuVO> selectUnderMenu(String menu_up_code) throws SQLException {
		List<MenuVO> underMenuList = menuDao.selectUnderMenu(menu_up_code);
		return underMenuList;
	}

}
