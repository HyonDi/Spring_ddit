package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/commons/*")
public class CommonsActionController {
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	// 로그인
	// 다중매핑:localhos/mvc만쳐도 login화면이나오게.혹은 그냥 / 만해도 로그인화면나오게하기위함.
	// @RequestMapping("/commons/*") 를 주석한다. 배열사용.
	
	//@RequestMapping(value= {"/", "/commons/loginForm.do"})
	@RequestMapping("loginForm.do")
	public String loginForm() {
		String url = "commons/loginForm";
		return url;
	}
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String loginPost(String id, String pwd, HttpServletRequest request, HttpSession session) {
		//String url = "redirect:"+request.getContextPath()+"/member/list.do";
		String url = "redirect:/member/list.do";
		// resolver는 / 주면 앞에 자동으로 contextPath붙여준다.
		
		// 메세지가있다면 지운다.
		
		
		String message=null;
		try {
			memberService.login(id, pwd);
			
			MemberVO loginUser = memberService.getMember(id);
			
			// 필터를안넣어서 여기서 유효성검사하는것으로 대체하는 내용.
			if(loginUser.getEnabled()==0) {// 사용정지
				message="사용 정지된 아이디로 이용이 제한됩니다.";
				url="redirect:/commons/loginFrom.do";
			}else {// 사용 가능. 세션유지 6분으로했다. tomcat 은 30분최대.
				session.setAttribute("loginUser", loginUser);
				session.setMaxInactiveInterval(60*6);
			}
			
			
		}catch(NotFoundIDException e) {
			e.printStackTrace();
			message="아이디가 존재하지 않습니다.";
			url="redirect:login";
		}catch(InvalidPasswordException e) {
			e.printStackTrace();
			message="패스워드가 일치하지 않습니다.";
			url="redirect:login";
		}catch(SQLException e) {
			e.printStackTrace();
			message="시스템장애로 로그인이 불가합니다.";
			url="redirect:login";
		}
		
		session.setAttribute("msg", message);
		session.setAttribute("id", id);
		
		return url;
	}
}
