package com.bms.controller.mypage;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.dto.member.MemberVO;
import com.bms.service.mypage.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	
	private MypageService mypageService;
	
	@RequestMapping(value="personal_information_modification/resident", method=RequestMethod.GET)
	public String personal_information_modificationGET(String id, Model model) throws Exception {
		String url = "mypage/personal_information_modification.resident";
		
		Map<String, Object> dataMap = mypageService.getMember(id);
		
		MemberVO member = (MemberVO) dataMap.get("member");

		model.addAllAttributes(dataMap);
		
		return url;
	}

}
