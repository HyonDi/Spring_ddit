package com.bms.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sms/")
public class ExamTest {
	
	@RequestMapping(value="smsTest", method=RequestMethod.GET)
	public String getsms() throws Exception {
		String url = "/sms/smsTest";
		return url;
	}
	
	@RequestMapping(value="smsTest", method=RequestMethod.POST)
	public void postsms(String content, String to) throws Exception{
		System.out.println(content + ", " + to);
		ExampleSend.sendsms(to, content);
	}

}
