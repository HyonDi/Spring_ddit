package com.spring.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.ReplyVO;
import com.spring.request.DeleteReplyRequest;
import com.spring.request.ModifyReplyRequest;
import com.spring.request.PageMaker;
import com.spring.request.RegistReplyRequest;
import com.spring.request.SearchCriteria;
import com.spring.service.MemberService;
import com.spring.service.ReplyService;

@Controller
@RequestMapping("/replies/*")
public class ReplyActionController {
	
	@Autowired
	private ReplyService replyService;
	public void setReplyService(ReplyService replyServcie) {
		this.replyService = replyServcie;
	}
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("list.do")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> list(int bno, SearchCriteria cri) throws Exception{
		
		ResponseEntity<Map<String,Object>> entity = null;
		
		try {
			//if(true) throw new SQLException("예외처리 테스트");
			
			Map<String, Object> dataMap = replyService.getReplyList(bno, cri);
			entity = new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return entity;
	}
	
	@RequestMapping("regist.do")
	@ResponseBody
	public ResponseEntity<Integer> regist(@RequestBody RegistReplyRequest registReq) throws Exception{
	//public String regist(@RequestBody RegistReplyRequest registReq) throws Exception{
		// ResponseEntity<Integer> : realEndPage만 내보내면되기때문에 integer
		
		//String result="";
		ResponseEntity<Integer> entity = null;
		
		ReplyVO reply = registReq.toReplyVO();
		reply.setReplyer("mimi");
		try {
			replyService.registReply(reply);
			
			// 에러내기위함
			//int k = 1/0;
			// 혹은
			//if(true)throw new SQLException();
			//
			
			Map<String,Object> dataMap = replyService.getReplyList(registReq.getBno(), new SearchCriteria());
			PageMaker pageMaker = (PageMaker)dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();
			
			//dataMap.put("realEndPage", pageMaker.getRealEndPage());
			
			// result = "SUCCESS," + realEndPage;
			entity = new ResponseEntity<Integer>(realEndPage,HttpStatus.OK);// SUCCESS는 어딜간거지
			// 결과와 응답코드를 같이보낸다? 마라미터 중 realEndPage은 Integer타입. 뒤에붙은 httpStatus.OK는 응답코드임(OK는 응답코드 200이다.)
			
		} catch(SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
			// 파라미터하나일경우 응답코드만 적는다. 만들다 에러났으니 줄 realEndPage이 없다.
			// httpstatus.internal_server_error 은 500에러.
			
		}
		
		return entity;
	}
	
	@RequestMapping("modify.do")
	@ResponseBody
	public ResponseEntity<String> modify(@RequestBody ModifyReplyRequest modifyReq) throws Exception{
		ResponseEntity<String> entity = null;
		
		ReplyVO reply = modifyReq.toReplyVO();
		
		//String result="";
		
		try {
			replyService.modifyReply(reply);
		
			entity = new ResponseEntity<String>(HttpStatus.OK);
		} catch(SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("remove.do")
	@ResponseBody
	public ResponseEntity<Integer> remove(@RequestBody DeleteReplyRequest removeReq) throws Exception{
		ResponseEntity<Integer> entity = null;
		
		try {
			replyService.removeReply(removeReq.getRno());
			
			//SearchCriteria cri = new SearchCriteria();
			
			Map<String, Object> dataMap = replyService.getReplyList(removeReq.getBno(), new SearchCriteria());
			PageMaker pageMaker = (PageMaker)dataMap.get("pageMaker");
			int page = removeReq.getPage();
			int realEndPage=pageMaker.getRealEndPage();
			if(page>realEndPage) {page = realEndPage;}
			
			entity = new ResponseEntity<Integer>(page,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
}
