package com.spring.service.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.spring.dto.MenuVO;

public interface MenuService {
	
	
	List<MenuVO> getTopMenuList()throws SQLException;
	
	List<MenuVO> getSubMenuList(String mCode)throws SQLException;
	
}
