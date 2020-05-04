package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.BoardVO;
import com.spring.request.BoardRegistRequest;
import com.spring.request.SearchCriteria;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardActionController {

	@Autowired
	private BoardService boardService;
	public void setBoardSerivce(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("list.do")
	public String list(SearchCriteria cri, Model model) throws Exception{
		String url = "board/list";
		
		Map<String, Object> dataMap = boardService.getBoardList(cri);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	@RequestMapping("registForm.do")
	public String registForm() throws Exception{
		String url = "board/registBoard";
		return url;
	}
	
	@RequestMapping("regist.do") // 열 곳.??
	public String registPost(BoardRegistRequest registReq, SearchCriteria cri) throws Exception{
		String url = "board/regist_success"; // 완료 후 갈곳.??
		
		//PageMaker pageMaker = new PageMaker(); // 얜 왜계속나오지 받았으니까 그냥 넘기면 되는 것 아닌가?
		//pageMaker.getCri(); // 비어있는거 꺼내서 뭐해??
		
		
		BoardVO board = registReq.toBoardVO();
		board.setWriter("mimi");
		
		try {
			boardService.write(board);
		} catch(Exception e) {
			e.printStackTrace();
			url = "board/regist_fail";
		}
		
		return url;
	}
	
	@RequestMapping("detail.do")
	public String detail(Model model, SearchCriteria cri, int bno) throws Exception {
		String url = "board/detailBoard";
		
		System.out.println("bno : " + bno);
		
		BoardVO board = boardService.getBoard(bno);
		
		model.addAttribute("board",board);
		//model.addAllAttributes(board);
		
		return url;
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyPost(Model model, SearchCriteria cri, int bno) throws Exception {
		String url = "board/modifyBoard";
		System.out.println("bno : " + bno);
		
		BoardVO board = boardService.getBoard(bno);
		
		model.addAttribute("board",board);
		return url;
	}
	
	@RequestMapping("modify.do")
	public String modify(BoardRegistRequest registReq, SearchCriteria cri) throws Exception{
		BoardVO board = registReq.toBoardVO();
		String url = "board/modify_success";
		
		try {
			boardService.modify(board);
			
 		} catch(Exception e) {
 			e.printStackTrace();
 			url = "board/modify_fail";
 		}
		
		return url;
	}
	
	@RequestMapping("")
	
	
}
