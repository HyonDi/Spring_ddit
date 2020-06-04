package com.spring.service.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dao.menu.MenuDAO;
import com.spring.dto.MenuVO;

public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;
	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	
	@Override
	public List<MenuVO> getTopMenuList() throws SQLException {
			
		List<MenuVO> menus = menuDAO.selectMenuList();
		for(MenuVO menu: menus) {			
			List<MenuVO> subMenuList = menuDAO.selectSubMenuListByMcode(menu.getMCode());
			menu.setSubMenuCode(subMenuList);					
		}
		
		return menus;
	}

	@Override
	public List<MenuVO> getSubMenuList(String mCode) throws SQLException {
		List<MenuVO> subMenuList = menuDAO.selectSubMenuListByMcode(mCode);
		return subMenuList;
	}

}
