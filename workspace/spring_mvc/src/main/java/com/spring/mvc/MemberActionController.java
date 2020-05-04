package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.request.member.RegistMemberRequest;

@Controller
// "/member" <- 시작 url
@RequestMapping("/member/*")
public class MemberActionController {

	//url 지정 : HandlerMapper가 관할
	@RequestMapping(value="regist", method=RequestMethod.GET)
	// return type은 ViewName이라 String : viewResolver가 관할
	// --------> return type void : url을 지정해주지 않아도 handler adoptor가 request를 받았던 url로 dispatcher(servlet)에게 건네줌
	public void regist_GET() throws Exception {
		/*String url = "member/regist";
		return url;*/
	}

	
	@RequestMapping(value="regist", method=RequestMethod.POST)
	//@RequestParam(value="password")String pwd -> request에서 받는 변수 이름과 같아야 하는데 다른 경우 @RequestParam을 이용해 연결해줄 수 있다. 
	//이걸 Request 클래스에서도 활용할 수 있다
	//@RequestParam(defaultValue="대전광역시") -> address값이 없으면 "대전광역시"로 값 넣어줘
	//@RequestParam(required=true)String authority -> 값이 null이면 터짐
	public String regist_POST(RegistMemberRequest registReq, @RequestParam(required=true)String authority,
			@RequestParam(defaultValue="대전광역시")String address, String id, @RequestParam(value="password")String pwd, 
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		String url = "redirect:https://www.ddit.or.kr";
		
		System.out.println(registReq);
		System.out.println("id : " + id + " password : " + pwd);
		System.out.println("request : " + request);
		System.out.println("response : " + response);
		System.out.println("session : " + session);
		//System.out.println("ctx : " + request.getServletContext());
		
		System.out.println("address : " + address);
		System.out.println("authority : " + authority);
		
		/**
		 * getParameter 안하고 밑에 소스만 쓸 수 있게 됨
		 */
		// memberVO member = registReq.toMemberVO();
		// try{
		// 		memberService.regist(member);
		// }catch(SQLException e){
		//		url = "error/500_error";
		// }
		
		return url;
	}
	
}
