package com.bms.controller.main;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.menu.MenuVO;
import com.bms.service.menu.MenuService;


@Controller
@RequestMapping("/main")
public class MainContoller {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/main_owner", method=RequestMethod.GET)
	public ModelAndView getMain_owner(ModelAndView mnv) throws Exception {
		String url = "main/main_owner.main";

		List<MenuVO> menuList1 = null;
		List<MenuVO> menuList2 = null;
		List<MenuVO> menuList3 = null;
		List<MenuVO> menuList4 = null;
		
		try {
			
			menuList1 = menuService.selectUnderMenu("MENU01");
			menuList2 = menuService.selectUnderMenu("MENU02");
			menuList3 = menuService.selectUnderMenu("MENU03");
			menuList4 = menuService.selectUnderMenu("MENU04");
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}

		mnv.addObject("menuList1", menuList1);
		mnv.addObject("menuList2", menuList2);
		mnv.addObject("menuList3", menuList3);
		mnv.addObject("menuList4", menuList4);
		mnv.setViewName(url);
		
		
		return mnv;
		
	}
	
	@RequestMapping(value="/main_superintendent", method=RequestMethod.GET)
	public ModelAndView getMain_sueprintendent(ModelAndView mnv) throws Exception {
		
		String url = "main/main_superintendent.main";
		List<MenuVO> menuList5 = menuService.selectUnderMenu("MENU05");
		List<MenuVO> menuList6 = menuService.selectUnderMenu("MENU06");
		List<MenuVO> menuList7 = menuService.selectUnderMenu("MENU07");
		List<MenuVO> menuList8 = menuService.selectUnderMenu("MENU08");

		mnv.addObject("menuList5", menuList5);
		mnv.addObject("menuList6", menuList6);
		mnv.addObject("menuList7", menuList7);
		mnv.addObject("menuList8", menuList8);
		mnv.setViewName(url);
		
		return mnv;

	}
	
	@RequestMapping(value="/main_resident", method=RequestMethod.GET)
	public ModelAndView getMain_resident(ModelAndView mnv) throws Exception {
		String url = "main/main_resident.main";
		List<MenuVO> menuList9 = menuService.selectUnderMenu("MENU09");
		List<MenuVO> menuList10 = menuService.selectUnderMenu("MENU10");
		List<MenuVO> menuList11 = menuService.selectUnderMenu("MENU11");

		mnv.addObject("menuList9", menuList9);
		mnv.addObject("menuList10", menuList10);
		mnv.addObject("menuList11", menuList11);
		mnv.setViewName(url);
		
		return mnv;

	}
	
}
