package com.bms.service.menu;

import java.sql.SQLException;
import java.util.List;

import com.bms.dto.member.MemberVO;
import com.bms.dto.menu.MenuVO;

public interface MenuService {
	
	// 하위 메뉴 출력
		public List<MenuVO> selectUnderMenu(String menu_up_code) throws SQLException;

}
