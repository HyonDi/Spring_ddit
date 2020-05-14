package com.groupware.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.dto.MenuVO;
import com.groupware.service.menu.MenuService;

@Controller
public class CommonController {
	
	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String mainGet(Model model, String mCode) throws Exception{
		model.addAttribute("mCode", mCode);
		return "main";
	}
	
	
	// Rest방식
	@RequestMapping("/commons/topMenuHql")
	@ResponseBody
	public ResponseEntity<Map<String, List<MenuVO>>> getMenu(HttpSession session) throws Exception{
		
		// List로넘기면 배열형태로온다. 데이터넘기기 불편함.
		// 따라서 애시당초 Map으로넘기면 json형태로오고 추가적인데이터를넣어 넘기기 편리. Map사용이유가 json으로받기위해서임.
		ResponseEntity<Map<String, List<MenuVO>>> result = null;
		
		Map<String, List<MenuVO>> menuMap = new HashMap<String, List<MenuVO>>();
		
		List<MenuVO> menuList = menuService.getTopMenuList();
		
		menuMap.put("subMenuCode", menuList);
		result = new ResponseEntity<Map<String, List<MenuVO>>>(menuMap, HttpStatus.OK);
		
		return result;
		
	}
	
	@RequestMapping("/commons/subMenuHql")
	public String getsubMenu(@RequestParam(defaultValue="MENU00") String mCode, Model model) throws Exception{
		String url = "commons/subMenu";
		List<MenuVO> menuList = menuService.getSubMenuList(mCode);// mCode없으면 defaule가 Home. 서브메뉴리스트를 만들어서 화면(commons/subMenu)에넘긴다.
		model.addAttribute("subMenuList", menuList);
		
		return url;
	}
	
	/* restful방식으로되어있는것들은 security에서 빼줘야한다고? 안그러면 success가 로그인화면을 받아서 작동멈춤. */
	
}
