package com.bms.controller.suggestion;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.member.MemberVO;
import com.bms.dto.reply.ReplyVO;
import com.bms.dto.suggestion.SuggestionVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.service.member.MemberService;
import com.bms.service.reply.ReplyService;
import com.bms.service.suggestion.SuggestionService;

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {
	
	@Autowired
	private SuggestionService suggestionService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping("mobileList")
	public ModelAndView MobilesuggestionList(SearchCriteria cri, ModelAndView mnv, String chk) throws SQLException {
		String url = "mobile/suggestionList_resident";
		
		if(chk.equals("admin")) {
			url = "mobile/suggestionList_superintendent";
		}else if(chk.equals("mem")){
			url = "mobile/suggestionList_resident";
		}
		
		Map<String, Object> dataMap = suggestionService.getSuggestionAll(cri);
		
		mnv.setViewName(url);
		mnv.addAllObjects(dataMap);
		
		return mnv;
	}
	
	@RequestMapping(value="mobileDetail",method=RequestMethod.GET)
	public ModelAndView MobilesuggestionDetail(HttpSession session, ModelAndView mnv, String suggestion_code, String chk, String chk2) throws SQLException {
		String url = "mobile/suggestionDetail_resident";
		
		if(chk.equals("dt") && chk2.equals("mem")) {
			url = "mobile/suggestionDetail_resident";
		}else if(chk.equals("dt") && chk2.equals("admin")) {
			url = "mobile/suggestionDetail_superintendent";
		}else if(chk.equals("dc") && chk2.equals("admin")) {
			url = "mobile/suggestionDetail_superintendent2";
		}else if(chk.equals("dc") && chk2.equals("mem")){
			url = "mobile/suggestionDetail_resident";
		}
		
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		SuggestionVO suggestion = suggestionService.getsuggestionBySno(suggestion_code);
		
		String member_code = suggestion.getMember_code();
		
		String member_name = memberService.getMemberNameByCode(member_code);
		
		String board_code = suggestion_code;
		
		ReplyVO reply = null;
		
		if(board_code == null) {
			System.out.println("널이야");
			mnv.addObject("reply", "널");
		}else {
			reply = replyService.mobileReply(board_code);
			mnv.addObject("reply", reply);
		}
		
		
		mnv.setViewName(url);
		mnv.addObject("suggestion", suggestion);
		mnv.addObject("member_name", member_name);
		mnv.addObject("loginUser", loginUser);
		
		return mnv;
	}
	
	@RequestMapping("suggestion_mod")
	@ResponseBody
	public ResponseEntity<String> suggestionModify(String suggestion_code, String suggestion_title, String suggestion_contents) throws Exception {
		ResponseEntity<String> entity = null;
		
		SuggestionVO suggestion = new SuggestionVO();
		suggestion.setSuggestion_code(suggestion_code);
		suggestion.setSuggestion_title(suggestion_title);
		suggestion.setSuggestion_contents(suggestion_contents);
		
		try {
			suggestionService.mobileSuggestionModify(suggestion);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("mobileRegist")
	public ModelAndView suggestionRegist(HttpSession session, ModelAndView mnv) throws Exception{
		String url = "mobile/suggestionRegist_resident";
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		mnv.setViewName(url);
		mnv.addObject("loginUser", loginUser);
		
		return mnv;
	}
	
	@RequestMapping("mobileRegistAdd")
	@ResponseBody
	public ResponseEntity<String> suggestionRegistAdd(String member_code, String suggestion_contents, String suggestion_title) throws Exception{
		ResponseEntity<String> entity = null;
		
		SuggestionVO suggestion = new SuggestionVO();
		suggestion.setMember_code(member_code);
		suggestion.setSuggestion_contents(suggestion_contents);
		suggestion.setSuggestion_title(suggestion_title);
		
		try {
			suggestionService.mobileSuggestionRegist(suggestion);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("suggestion_del")
	@ResponseBody
	public ResponseEntity<String> suggestionDelete(String suggestion_code) throws Exception {
		ResponseEntity<String> entity = null;
		
		try {
			suggestionService.mobileSuggestionDelete(suggestion_code);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("reply")
	@ResponseBody
	public ResponseEntity<String> mobileReply(HttpSession session, String replyText, String suggestion_code, String board_sort_code, String reply_code) throws Exception{
		ResponseEntity<String> entity = null;
		String result = "";
		
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		String member_code = member.getMember_code();
		String reply_contents = replyText;
		String board_code = suggestion_code;
		
		ReplyVO reply = new ReplyVO();
		reply.setReply_code(reply_code);
		reply.setMember_code(member_code);
		reply.setReply_contents(reply_contents);
		reply.setBoard_code(board_code);
		reply.setBoard_sort_code(board_sort_code);
		
		try {
			replyService.mobileReplyWrite(reply);
			
			ReplyVO replys = replyService.mobileReply(board_code);
			result = replys.getReply_code();
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("replyDel")
	@ResponseBody
	public ResponseEntity<String> mobileReplyDel(String reply_code) throws Exception{
		ResponseEntity<String> entity = null;
		
		try {
			replyService.mobileReplyDelete(reply_code);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("replyModify")
	@ResponseBody
	public ResponseEntity<String> mobileReplyModify(HttpSession session, String replyText, String suggestion_code, String board_sort_code, String reply_code) throws Exception{
		ResponseEntity<String> entity = null;
		String result = "";
		
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		String member_code = member.getMember_code();
		String reply_contents = replyText;
		String board_code = suggestion_code;
		
		ReplyVO reply = new ReplyVO();
		reply.setMember_code(member_code);
		reply.setReply_code(reply_code);
		reply.setReply_contents(reply_contents);
		reply.setBoard_code(board_code);
		reply.setBoard_sort_code(board_sort_code);
		
		try {
			replyService.mobileReplyModify(reply);
			
			result = "SUCCESS";
			
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}

}
