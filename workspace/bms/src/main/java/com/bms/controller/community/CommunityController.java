package com.bms.controller.community;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.community.CommunityVO;
import com.bms.dto.member.MemberVO;
import com.bms.dto.member.ResidentVO;
import com.bms.dto.reply.ReplyVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.request.reply.CommunityReplyRequest;
import com.bms.service.community.CommunityService;
import com.bms.service.member.MemberService;
import com.bms.service.reply.ReplyService;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private String memberPicturePath;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/picture/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> getPicture(@PathVariable("id") String member_code) throws Exception{
		
		MemberVO member = memberService.getMemberAllByCode(member_code);
		
		String picture = member.getMember_picture();
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		String savePath = memberPicturePath + File.separator + member.getMember_code();
		System.out.println(savePath);
		
		in = new FileInputStream(savePath + File.separator + picture);
		
		try {
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),HttpStatus.CREATED);
		} catch(IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}finally {
			if(in != null)in.close();
		}
		
		return entity;
	}
	
	@RequestMapping("mobileList")
	public ModelAndView MobilecommunityList(SearchCriteria cri, ModelAndView mnv) throws SQLException {
		String url = "mobile/communityList_resident";
		
		Map<String, Object> dataMap = communityService.getCommunityAll(cri);
		
		mnv.setViewName(url);
		mnv.addAllObjects(dataMap);
		
		return mnv;
	}
	
	@RequestMapping(value="mobileDetail",method=RequestMethod.GET)
	public ModelAndView MobileCommunityDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelAndView mnv, String community_code, String chk) throws SQLException {
		String url = "mobile/communityDetail_resident";
		
		if(chk.equals("dt")) {
			url = "mobile/communityDetail_resident2";
		}
		
		Cookie[] getCookie = request.getCookies(); // 모든 쿠키 가져오기
		
		MemberVO loginUser = null;
		CommunityVO community = null;

		int cookieFind = -1;
		
		if(getCookie != null){ // 만약 쿠키가 없으면 쿠키 생성
			
			for(int i=0; i<getCookie.length; i++){
				if(getCookie[i].getName().equals(community_code)){
					   cookieFind = i;
					   break;
				}
			}
			
		}
		
		if(cookieFind == -1) {
			System.out.println("쿠키업다");
			Cookie setCookie = new Cookie(community_code, community_code); // 쿠키 이름을 name으로 생성
			setCookie.setMaxAge(60*60*24); // 기간을 하루로 지정(60초 * 60분 * 24시간)
			response.addCookie(setCookie); // response에 Cookie 추가
			//로그인정보
			loginUser = (MemberVO) session.getAttribute("loginUser");
			community = communityService.getCommunityByCno(community_code);
		}else {
			System.out.println("쿠키있다.");
			//로그인정보
			loginUser = (MemberVO) session.getAttribute("loginUser");
			community = communityService.getCommunityByCnoNoCnt(community_code);
		}
		
		mnv.setViewName(url);
		
		//댓글
		String board_code = community.getCommunity_code();
		System.out.println("보드코드 : " + board_code);
		List<ReplyVO> reply = null;
		int replyCnt = 0;
		List<CommunityReplyRequest> replyUp = null;
		try {
			reply = replyService.mobileReplyList(board_code);
			replyCnt = replyService.mobileReplyCnt(board_code);
			replyUp = replyService.mobileReplyUpCode();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

		//회원정보
		String member_code = community.getMember_code();
		String member_name = memberService.getMemberNameByCode(member_code);
		
		
		mnv.addObject("community", community);
		mnv.addObject("member_name", member_name);
		mnv.addObject("loginUser", loginUser);
		mnv.addObject("reply", reply);
		mnv.addObject("replyCnt",replyCnt);
		mnv.addObject("replyUp", replyUp);
		
		return mnv;
	}
	
	@RequestMapping("mobileRegist")
	public ModelAndView MobileCommuityRegist(ModelAndView mnv, HttpSession session) throws SQLException{
		String url = "mobile/communityRegist_resident";
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		mnv.addObject("loginUser", loginUser);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="mobileRegistAdd", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> MobileCommunityAdd(String member_code, String community_contents, String community_title) throws SQLException{
		ResponseEntity<String> entity = null;
		
		CommunityVO community = new CommunityVO();
		community.setMember_code(member_code);
		community.setCommunity_contents(community_contents);
		community.setCommunity_title(community_title);
		
		System.out.println(community.toString());
		
		try {
			communityService.mobileCommunityRegist(community);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("replyRegist")
	@ResponseBody
	public ResponseEntity<String> mobileReplyRegist(HttpSession session, String board_sort_code, String board_code, String reply_contents) throws Exception{
		ResponseEntity<String> entity = null;
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String member_code = loginUser.getMember_code();
		
		ReplyVO reply = new ReplyVO();
		reply.setBoard_code(board_code);
		reply.setBoard_sort_code(board_sort_code);
		reply.setMember_code(member_code);
		reply.setReply_contents(reply_contents);
		
		try {
			replyService.mobilReplyRegist(reply);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("community_del")
	@ResponseBody
	public ResponseEntity<String> communityDelete(String community_code) throws Exception {
		ResponseEntity<String> entity = null;
		
		try {
			communityService.mobileCommunityDelete(community_code);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("community_mod")
	@ResponseBody
	public ResponseEntity<String> communityModify(String community_code, String community_title, String community_contents) throws Exception {
		ResponseEntity<String> entity = null;
		
		CommunityVO community = new CommunityVO();
		community.setCommunity_code(community_code);
		community.setCommunity_title(community_title);
		community.setCommunity_contents(community_contents);
		
		try {
			communityService.mobileCommunityModify(community);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("replyDel")
	@ResponseBody
	public ResponseEntity<String> replyDel(String reply_code) throws Exception{
		ResponseEntity<String> entity = null;
		
		try {
			replyService.mobileReplyDelete(reply_code);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("replyMod")
	@ResponseBody
	public ResponseEntity<String> replyMod(String reply_code, String reply_contents) throws Exception{
		ResponseEntity<String> entity = null;
		
		System.out.println("리플라이코드 : " + reply_code);
		System.out.println("리플라이내용 : " + reply_contents);
		
		ReplyVO reply = new ReplyVO();
		reply.setReply_code(reply_code);
		reply.setReply_contents(reply_contents);
		
		System.out.println(reply.toString());
		
		try {
			replyService.mobileReplyModify(reply);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("replyResRegist")
	@ResponseBody
	public ResponseEntity<String> replyResRegist(HttpSession session, String board_sort_code, String board_code, String reply_contents, String reply_up_code) throws Exception{
		ResponseEntity<String> entity = null;
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String member_code = loginUser.getMember_code();
		
		ReplyVO reply = new ReplyVO();
		reply.setBoard_code(board_code);
		reply.setBoard_sort_code(board_sort_code);
		reply.setReply_up_code(reply_up_code);
		reply.setMember_code(member_code);
		reply.setReply_contents(reply_contents);
		
		try {
			replyService.mobilReplyResRegist(reply);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	

}
