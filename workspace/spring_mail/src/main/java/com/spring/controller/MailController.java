package com.spring.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mail.MimeAttachNotifier;
import com.spring.request.MailRequest;

@Controller
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private MimeAttachNotifier notifier;
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String mailGet() throws Exception{
		String url = "mail/mailForm";
		return url;
	}
																		// 한글파일명이 넘어올 수 있으니 작성.
	@RequestMapping(value="/send", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String mailPost(MailRequest mail, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) throws Exception {
																						// Redirect 시에 						
		String url = "redirect:/mail/success";// redirect 하는 이유 : forward하면 위험해. post인데 forward이면 새로고침했을 때 계속 동작한다.
											  // 따라서 Post했으면 redirect를 해서 request를 끊어야함.
		// <파일업로드
		MultipartFile attach = mail.getFile();
		
		String savePath = "";
		String uploadPath = "";
		
		// 파일 유무
		if(attach!=null && !attach.isEmpty()) {
			// 파일 크기
			if(attach.getSize() < 1024*1024*5) {
				// 파일 저장
				uploadPath=request.getSession().getServletContext().getRealPath("resources/mail_attach");
				File file = new File(uploadPath, attach.getOriginalFilename());
				
				if(!file.exists()) {
					file.mkdirs();
				}
				
				attach.transferTo(file);
				
				savePath=file.getAbsolutePath();
			}else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('용량초과 입니다!');</script>");
				out.println("<script>history.go(-1);</script>");
				
				return null;
			}
		}
		
		notifier.sendMail(mail, uploadPath);
		
		
		
		// 파일업로드>
		
		// 메일보내기위한 설정(mail sender)
		
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("receiver", mail.getReceiver());
		resultMap.put("sender", mail.getSender());
		resultMap.put("title", mail.getTitle());
		resultMap.put("content", mail.getContent());
		resultMap.put("uploadPath", savePath);
		
		// rttr.addAttribute : 파라미터로 붙어서 redirect. views>mail>success.jsp 에서 param.??? 으로 해야 받을 수 있음. 단점 : 주소줄로 이동함.
		// rttr.addFlashAttribute : request에 심어서 가는듯이.(실제로심어짐.) 주소로 이동하면 휘발된다(새로고침하면 날라감). forward처럼 파라미터를 넘길 수 있다. 단점 : 한번만사용가능.
		
		//rttr.addFlashAttribute("result", resultMap);
		rttr.addAllAttributes(resultMap); // redirect시 새로고침해도 데이터유지시키려면 주소줄이 더러워서 param으로 보내야한다.
		rttr.addFlashAttribute("msg","메일이 성공적으로 보내졌습니다."); // 한 번만 알림이뜨고 이후엔 지울거니까 flash로 add했음.
		
		return url;
	}
	
	@RequestMapping(value="/success")
	public void mailSuccess(/*HttpServletRequest request*/Model model) throws Exception{
		//System.out.println(request.getAttribute("result")); // null 나온다.반면 success쪽(jsp)에 requestScope으로 하면 찍힌다.
		
		//model.addAttribute("result",resultMap);
		
		//model.addAttribute("msg", "메일이 성공적으로 보내졌습니다."); // 여기서 넣으면 새로고침할때마다 계속알림뜬다.
		
	}
}
