package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	// RequestMapping 에 쓰는게 실제 경로인가보네. 그롬 Stringurl  은 하는역할이 뭐야
	@RequestMapping("/admin/main")
	public void adminMain() throws Exception{
		// 안에아무것도안써도돼요!!!!왜???
	}
	
	@RequestMapping("/commons/main")
	public String commonsMain() throws Exception{
		String url= "commons/main";
		return url;
	}
	@RequestMapping("/home/main")
	public String homeMain() throws Exception{
		String url= "home/main";
		return url;
	}
	@RequestMapping("/manager/main")
	public String managerMain() throws Exception{
		String url= "manager/main";
		return url;
	}
	@RequestMapping("/member/main")
	public String memberMain() throws Exception{
		String url= "member/main";
		return url;
	}
}
