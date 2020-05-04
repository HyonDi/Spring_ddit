package com.spring.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.request.SearchCriteria;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberActionController {
	
	@Autowired
	private MemberService memberService;
	public void setMemberSerivce(MemberService memberService) {
		this.memberService = memberService;
	}
	
	//@RequestMapping(value="list.do",method=RequestMethod.GET) // => 이렇게하면 Get방식만 골라 받는다.
	@RequestMapping("list.do") //=> 이렇게하면 get,post 둘 다 받는다.
	public String list(SearchCriteria cri, Model model) throws Exception{
		// void 로 함으로 이게 화면이라는것을 알려준다. url이랑 똑같이 화면 url준다는의미임.
		
		String url="member/list";
		
		// service에서 데이터를 받는다.
		Map<String, Object> dataMap = memberService.getMemberList(cri);
		
		// request가 없다.! 파라미턴에 "HttpServletRequest request" 추가.
		
		// request에심는다.
		/*request.setAttribute("pageMaker", (PageMaker)dataMap.get("pageMaker"));
		request.setAttribute("memberList", (List<MemberVO>)dataMap.get("memberList"));
		*/
		
		// 위 방법 말고. 파라미터에 모델을 받는다.(=>Model model 파라미터에 추가.) 하나씩 넣을때에는 
		/*model.addAttribute("pageMaker", (PageMaker)dataMap.get("pageMaker"));
		model.addAttribute("memberList", (List<MemberVO>)dataMap.get("memberList"));
		*/
		// 위에것을 한번에 넣을 때에는
		model.addAllAttributes(dataMap);
		return url;
	}
}
