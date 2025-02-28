package com.bms.controller.commons;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.member.MemberVO;
import com.bms.request.mail.MailRequest;
import com.bms.request.member.FindIdRequest;
import com.bms.request.member.FindPasswordRequest;
import com.bms.service.member.MemberService;
import com.bms.util.MailHandler;
import com.bms.util.MailSender;


@Controller
@RequestMapping("/commons")
public class CommonsController {
	
	@Autowired
	private MailSender emailSender;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginGET(HttpServletRequest request) {
		String url = "/commons/login";
		
		Device device = DeviceUtils.getCurrentDevice(request);
		
		  String deviceType = "";
		  if (device.isNormal()) {
		    deviceType  = "일반";
		    url = "commons/login";
		  } else if (device.isMobile()) {
		    deviceType  = "모바일";
		    url = "mobile/login";
		  } else if (device.isTablet()) {
		    deviceType  = "태블릿";
		    url = "mobile/login";
		  }
		
		  System.out.println(deviceType);
		  
		return url;
	}
	
	@RequestMapping(value="loginPost", method=RequestMethod.POST)
	public String loginPOST(String id, String pwd, HttpServletRequest request, HttpSession session)throws Exception{
		String url = "";
		Device device = DeviceUtils.getCurrentDevice(request);
		
		 String deviceType = "";
		
		try {
			memberService.login(id, pwd);
			
			MemberVO loginUser = memberService.getMember(id);
			
			session.setMaxInactiveInterval(60*10);
			session.setAttribute("loginUser", loginUser);
			
			if(loginUser.getMember_authority().equals("owner")) {
				if(device.isMobile()) {
					url = "redirect:/mobile/main_superintendent";
				}else {
					url = "redirect:/main/main_owner";					
				}
			}else if(loginUser.getMember_authority().equals("manager")) {
				if(device.isMobile()) {
					url = "redirect:/mobile/main_superintendent";
				}else {
					url = "redirect:/main/main_superintendent";
				}
			}else {
				if(device.isMobile()) {
					url = "redirect:/mobile/main_resident";
				}else {
					url = "redirect:/main/main_resident";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	
	@RequestMapping(value="/fingerLogin", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<MemberVO> fingerLogin(String member_phone) throws Exception{
		ResponseEntity<MemberVO> mobileUser = null;
		
		MemberVO member = null;
		
		try {
			member = memberService.getPhoneCheckMember(member_phone);
			mobileUser = new ResponseEntity<MemberVO>(member, HttpStatus.OK);
		}catch(SQLException e) {
			mobileUser = new ResponseEntity<MemberVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return mobileUser;
	}
	
	@RequestMapping(value="/mobileLogin", method=RequestMethod.GET)
	public String mobileLogin(String id, String pwd, HttpSession session) throws Exception{
		System.out.println("지문인식 로그인 테스트 : " + id + "," + pwd);
		String url = "";
		
		try {
			memberService.login(id, pwd);
			
			MemberVO loginUser = memberService.getMember(id);
			
			session.setMaxInactiveInterval(60*10);
			session.setAttribute("loginUser", loginUser);
			
			if(loginUser.getMember_authority().equals("owner")) {
				url = "redirect:/mobile/main_superintendent";
			}else if(loginUser.getMember_authority().equals("manager")) {
				url = "redirect:/mobile/main_superintendent";
			}else {
				url = "redirect:/mobile/main_resident";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request) throws Exception {
		String url = "redirect:" + request.getContextPath() + "/commons/login";
		
		request.getSession().invalidate();
		
		return url;
	}
	
	@RequestMapping(value="/findId" ,method=RequestMethod.POST)
	public String findId(FindIdRequest fiq, MailRequest mrq, HttpServletResponse response) throws Exception{
		String url = "mail/mail_success";
		try {
			MemberVO member = fiq.findIdVO();
			
			String USEREMAIL =  member.getMember_email();
			String USERNAME =  member.getMember_name();
			String USERPHONE = member.getMember_phone();
			String ID = memberService.getMemberId(member);
			ID = ID.substring(0,4) + "*****";
			mrq.setContent("[회원님의 아이디는 "+ID+" 입니다.]"); // 이메일로 보낼 메시지
			mrq.setReceiver(USEREMAIL); // 받는이의 이메일 주소
			mrq.setTitle("[" + USERNAME + "님의 요청하신 ID입니다.]"); // 이메일로 보낼 제목
			emailSender.SendEmail(mrq);
			
		}catch(Exception e) {
			url="/mail/mail_fail";
		}
		
		return url;
	}
	
	@RequestMapping(value="findPassword", method=RequestMethod.POST)
	public String findPassword(FindPasswordRequest fpr, MailRequest mrq, HttpServletRequest request, HttpServletResponse response) {
		String url = "mail/findPassMail_success";
		try {
			MemberVO member = fpr.findPassword();
			String member_id = member.getMember_id();
			String userName = member.getMember_name();
			String email = member.getMember_email();
			int member_pwdupdatechk = memberService.selectPasswordUpdateChk(member);
			
			String userPwd = memberService.getMemberPassword(member);
			request.setAttribute("member_id", member_id);
			request.setAttribute("member", member);
			request.setAttribute("member_pwdupdatechk", member_pwdupdatechk);
			System.out.println(member_pwdupdatechk);
			System.out.println(email);
			System.out.println(member.toString());
			
			MailHandler sendMail = new MailHandler(mailSender);
			sendMail.setSubject("[B.M.S 비밀번호변경]"); 
			sendMail.setText( 
					"<p>[비밀번호를 변경하시려면 아래 링크를 클릭해주세요]</p>" +
					"<a href='http://192.168.205.29:80/commons/passwordChange?member_id=" + member_id +
					"' onclick='window.open(this.href, '_blank', width='600', height='400'); return false;'>비밀번호변경</a>");
			sendMail.setFrom("yohch4243@gmail.com", "운영자"); // 보낸이
			sendMail.setTo(member.getMember_email()); // 받는이
			sendMail.send();
			
		} catch (Exception e) {
			e.printStackTrace();
			url="mail/findPassMail_fail";
		}
		return url;
	}
	
	@RequestMapping(value="passwordChange", method=RequestMethod.GET)
	public ModelAndView passChangeGET(HttpServletRequest request, String member_id, ModelAndView mnv, int member_pwdupdatechk)throws Exception{
		String url = "member/changePwd";
		
		String id = member_id;
		int chk = member_pwdupdatechk;
		
		if(chk == 2) {
			url ="member/changePwdForm_fail";
		}
		/*member = memberService.getMember(id);*/ 
		
		System.out.println(id);
		System.out.println(chk);
		
		mnv.setViewName(url);
		mnv.addObject("id", id);
		mnv.addObject("member_pwdupdatechk", chk);
		
		return mnv;
	}
	
	@RequestMapping(value="passwordChange", method=RequestMethod.POST)
	public ModelAndView passChangePOST(HttpServletRequest request, @RequestParam("member_pwdchk") String member_pwdchk, @RequestParam("member_pwd") String member_pwd, @RequestParam("id") String id, ModelAndView mnv) throws Exception{
		String url = "/member/pwdChange_success";
		
		/*System.out.println("아이디 : " + id + ", " + "패스워드 : " + member_pwd + ", " + member_pwdchk);*/
		
		MemberVO member = new MemberVO();
		int chk = member.getMember_pwdupdatechk();
		member.setMember_id(id);
		if(member_pwd.equals(member_pwdchk)) {
			member.setMember_pwd(member_pwd);
			memberService.changePassword(member);
			
		}else {
			url="/member/pwdChange_fail";
		}
		mnv.addObject("member_pwdupdatechk", chk);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="weblogout")
	public String weblogout(HttpServletRequest request) throws Exception {
		String url = "redirect:/commons/login";
		
		request.getSession().invalidate();
		
		return url;
	}
}
