package com.spring.controller;

import java.util.Map;

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

import com.spring.dto.MemberVO;
import com.spring.request.MemberRegistRequest;
import com.spring.request.PageMaker;
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
		
		String url="member/list.page";
		
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
		model.addAttribute("title","회원리스트");
		model.addAllAttributes(dataMap);
		return url;
	}
	
	
	
	
	@RequestMapping("regist.do")
	public String registForm() throws Exception{
		String url="member/regist.open";
		return url;
	}
	
	@RequestMapping("registSubmit.do")
	public String registPost(MemberRegistRequest registReq, SearchCriteria cri) throws Exception{
		String url="member/regist_success";
		
		MemberVO member = registReq.toMemberVO();
		
		try {
			memberService.regist(member);
		}catch(Exception e) {
			e.printStackTrace();
			url="member/regist_fail";
		}
		
		return url;
	}
	
	@RequestMapping("modify.do")
	public String modify(Model model,String id) throws Exception{
		String url = "member/modify.open";
		
		MemberVO member = memberService.getMember(id);
		
		model.addAttribute("member",member);
		
		return url;
	}
	
	@RequestMapping("modifySubmit.do")
	public String modifyPost(MemberRegistRequest request,SearchCriteria cri) throws Exception{
		String url = "member/modify_success";
		
		//url = url + PageMaker.makeQuery(cri);
		
		MemberVO member = request.toMemberVO();
		
		try {
			memberService.modify(member);;
		} catch(Exception e) {
			e.printStackTrace();
			url="board/modify_cancel";
		}
		
		return url;
	}
	
	@RequestMapping("remove.do")
	public String remove(String id) throws Exception{
		String url = "member/remove_success";
		try {
			memberService.remove(id);
		}catch(Exception e) {
			e.printStackTrace();
			url="member/remove_fail";
		}
		
		return url;
	}
	
	@RequestMapping("detail.do")
	public String detail(String id, Model model) throws Exception{
		String url = "member/detail.open";
		
		MemberVO member = memberService.getMember(id);
		
		model.addAttribute("member",member);
		
		return url;
		
	}
	
	@RequestMapping("checkPassword.do")
	@ResponseBody
	public ResponseEntity<String> checkPassword(HttpSession session, String pwd) throws Exception{
		ResponseEntity<String> entity = null;
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		// 여기 로그인하는거 만들고 더 작성해야함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		System.out.println("pwd : " + pwd + " 맨위");
		
		//if(pwd.equals(loginUser.getPwd())) {
		
		
		if(pwd.equals("mimi")) {	
			entity = new ResponseEntity<String>(HttpStatus.OK);
			System.out.println("pwd : " + pwd+ " 성공");
		}else {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println("pwd : " + pwd+ " 실패");
		}
		
		//model.addAttribute("entity",entity);
		
		return entity;
	}
	
	
}
