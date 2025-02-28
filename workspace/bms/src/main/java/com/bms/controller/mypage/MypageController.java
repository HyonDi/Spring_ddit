package com.bms.controller.mypage;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.member.MemberVO;
import com.bms.dto.menu.MenuVO;
import com.bms.request.mypage.MypageModifyRequest;
import com.bms.service.menu.MenuService;
import com.bms.service.mypage.MypageService;


@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	
	@Autowired
	private MypageService mypageService;
	
	@Autowired
	private MenuService menuService;
	
	
	@RequestMapping(value="personal_information_modification/superintendent", method=RequestMethod.GET)
	public ModelAndView personal_information_modificationSuperintendentGET(HttpServletRequest request, ModelAndView mnv) throws Exception {
	
		String url = "mypage/personal_information_modification.manager";
		
		
		List<MenuVO> menuList5 = null;
		List<MenuVO> menuList6 = null;
		List<MenuVO> menuList7 = null;
		List<MenuVO> menuList8 = null;
		
		menuList5 = menuService.selectUnderMenu("MENU05");
		menuList6 = menuService.selectUnderMenu("MENU06");
		menuList7 = menuService.selectUnderMenu("MENU07");
		menuList8 = menuService.selectUnderMenu("MENU08");
		
		mnv.addObject("menuList5", menuList5);
		mnv.addObject("menuList6", menuList6);
		mnv.addObject("menuList7", menuList7);
		mnv.addObject("menuList8", menuList8);

		mnv.setViewName(url);
		
		return mnv;

	}
	
		
	@RequestMapping(value="/personal_information_modification/superintendent/test", method=RequestMethod.GET)
	public String personal_information_modificationSuperintendentGetPage(HttpServletRequest request, String id, Model model)throws Exception{
		String url = "mypage/personal_information_modificationManager";
		
		MemberVO member = null;
		
		try {
			
			HttpSession session = request.getSession();
			MemberVO membervo = (MemberVO) session.getAttribute("loginUser");
			
			member = mypageService.getMember(membervo.getMember_id());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("member",member);
		
		return url;
	}
	
	@RequestMapping(value="/personal_information_modification/manager/test", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> personal_information_modificationSuperPOST(MypageModifyRequest MyModifyReq,
																	    HttpServletResponse response ) throws Exception {		
		ResponseEntity<String> entity = null;	
		String result = "SUCCESS";	
		MemberVO member = MyModifyReq.toMemberVO();	
		
		try {
			
			mypageService.modify(member);
			
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
			
		}catch(Exception e) {
			result = "FAIL";
			entity = new ResponseEntity<String>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;

	}
	
	@RequestMapping(value="/personal_information_remove/manager/test")
	@ResponseBody
	public String  personal_informationSuper_remove(String member_id, HttpSession session, ModelAndView mnv) throws Exception{

		MemberVO member = mypageService.getMember(member_id);
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
			if(loginUser.getMember_id().equals(member.getMember_id())) {
				mypageService.remove(member_id);
				session.invalidate();
			}

			
		return "SUCCESS";

	}
	
	
	//--------------------------------------------------------------------------입주자
	//메뉴 -> 개인정보 수정
	@RequestMapping(value="/personal_information_modification/resident", method=RequestMethod.GET)
	public ModelAndView personal_information_modificationResidentGET(HttpServletRequest request, ModelAndView mnv) throws Exception {
		String url = "mypage/personal_information_modification.resident";
		
		List<MenuVO> menuList9 = null;
		List<MenuVO> menuList10 = null;
		List<MenuVO> menuList11 = null;
		
		try{
			menuList9 = menuService.selectUnderMenu("MENU09");
			menuList10 = menuService.selectUnderMenu("MENU10");
			menuList11 = menuService.selectUnderMenu("MENU11");
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		mnv.addObject("menuList9", menuList9);
		mnv.addObject("menuList10", menuList10);
		mnv.addObject("menuList11", menuList11);
		
		mnv.setViewName(url);
		
		return mnv;

	}
	
	
	
	@RequestMapping(value="/personal_information_modification/resident/test", method=RequestMethod.GET)
	public String personal_information_modificationGetPage(HttpServletRequest request, String id, Model model)throws Exception{
		String url = "mypage/personal_information_modification";
		
		MemberVO member = null;
		
		try {
			
			HttpSession session = request.getSession();
			MemberVO membervo = (MemberVO) session.getAttribute("loginUser");
			
			member = mypageService.getMember(membervo.getMember_id());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("member",member);
		
		return url;
	}
	
	
	
	@RequestMapping(value="/personal_information_modification/resident/test", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> personal_information_modificationPOST(MypageModifyRequest MyModifyReq,
																	    HttpServletResponse response ) throws Exception {		
		ResponseEntity<String> entity = null;	
		String result = "SUCCESS";	
		MemberVO member = MyModifyReq.toMemberVO();	
		
		try {
			
			mypageService.modify(member);
			
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
			
		}catch(Exception e) {
			result = "FAIL";
			entity = new ResponseEntity<String>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;

	}
	
	@RequestMapping(value="/personal_information_remove/resident/test")
	@ResponseBody
	public String  personal_information_remove(String member_id, HttpSession session, ModelAndView mnv) throws Exception{

		MemberVO member = mypageService.getMember(member_id);
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
			if(loginUser.getMember_id().equals(member.getMember_id())) {
				mypageService.remove(member_id);
				session.invalidate();
			}

			
		return "SUCCESS";

	}
		
	@RequestMapping(value="/personal_information_modification/checkId", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Boolean>> checkId(HttpServletRequest request, HttpServletResponse response, String id)throws Exception{
		
		ResponseEntity<Map<String, Boolean>> entity = null;
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		
		try {
			MemberVO member = (MemberVO) mypageService.getMember(id);
			if(member != null) {
				result.put("result", false);
			}else {
				result.put("result", true);
			}
			entity = new ResponseEntity<Map<String, Boolean>>(result, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<Map<String, Boolean>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
		
	}

	@RequestMapping(value="/personal_information_modification/checkPass", method= RequestMethod.POST)
	@ResponseBody
	public int passCheck(MemberVO member) throws Exception{
		int result = mypageService.passCheck(member);
		
		return result;
	}
	


	@RequestMapping(value="/personal_information_modification/mobile/mypage_resident", method=RequestMethod.GET)
	public String mobileResidentMypage(HttpServletRequest request, Model model)throws Exception{
		String url = "mobile/mypage";
		return url;
	}
	
	@RequestMapping(value="/personal_information_modification/mobile/mypage_resident2", method=RequestMethod.GET)
	public String mobileResidentMypage2(HttpServletRequest request, Model model)throws Exception{
		String url = "mobile/mypage2";
		
		MemberVO member = null;
		
		try {
			
			HttpSession session = request.getSession();
			MemberVO membervo = (MemberVO) session.getAttribute("loginUser");
			
			member = mypageService.getMember(membervo.getMember_id());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("member",member);
		
		return url;
	}
	
	@RequestMapping(value="/personal_information_modification/mobile/mypage_resident3", method=RequestMethod.GET)
	public String mobileResidentMypage3(HttpServletRequest request, Model model)throws Exception{
		String url = "mobile/mypage3";
		
		MemberVO member = null;
		
		try {
			
			HttpSession session = request.getSession();
			MemberVO membervo = (MemberVO) session.getAttribute("loginUser");
			
			member = mypageService.getMember(membervo.getMember_id());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("member",member);
		
		return url;
	}

}
