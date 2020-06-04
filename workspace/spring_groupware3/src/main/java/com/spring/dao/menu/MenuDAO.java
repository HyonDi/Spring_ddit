package com.spring.dao.menu;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.MenuVO;

public interface MenuDAO {
	
	List<MenuVO> selectMenuList()throws SQLException;
	
	List<MenuVO> selectSubMenuListByMcode(String mCode)throws SQLException;
}
