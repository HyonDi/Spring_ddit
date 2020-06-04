package com.spring.controller.board;

import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.EmployeeVO;
import com.spring.dto.NoticeAttachVO;
import com.spring.dto.NoticeVO;
import com.spring.request.Criteria;
import com.spring.service.board.NoticeService;
import com.spring.utils.MediaUtils;

@Controller
@RequestMapping("/board/notice/*")
public class NoticeBoardController{
	
	@Autowired
	private NoticeService nService;
	
	@Autowired
	private String uploadPath;	
	

	@RequestMapping("list")
	public ModelAndView noticeList(Criteria cri,ModelAndView modelnView) 
							 		throws SQLException{
		
		String url="board/notice/notice_list";
		
		Map<String,Object> dataMap = nService.getNoticeList(cri);		
		
		List<ColName> colNames = new ArrayList<ColName>();
		String[] colNameArr = {"","번&nbsp;호","제&nbsp;목","작성일","작성자","첨&nbsp;부","조회수"};
		String[] colWidthArr = {"4","10","46","10","10","10","10"};
		for(int i=0;i<colNameArr.length;i++) {
			colNames.add(new ColName(colNameArr[i],colWidthArr[i]));
		}
		
		dataMap.put("colNames", colNames);
		
		modelnView.addAllObjects(dataMap);
		modelnView.setViewName(url);
		
		return modelnView;		
	}
	
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public void noticeRegist(NoticeVO notice,HttpServletResponse response)throws Exception{
		String url="redirect:list";
		
		nService.regist(notice);
			
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("window.opener.location.href='/board/notice/list';window.close();");
		out.println("</script>");	
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(int nno, Model model) throws Exception {
		
		String url="board/notice/notice_detail";
		
		NoticeVO notice = nService.read(nno);

		model.addAttribute("notice", notice);
		
		return url;
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public void remove(int nno, HttpServletResponse response) throws Exception {
				
		nService.remove(nno);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("window.opener.location.reload();window.close();");
		out.println("</script>");
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify(int nno, Model model) throws Exception {
		
		String url="board/notice/notice_modify";
		
		NoticeVO notice = nService.getNotice(nno);
		model.addAttribute("notice", notice);
		
		return url;
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public void modifyPOST(String oldAttach,
							 NoticeVO notice,
							 HttpSession session,
							 HttpServletResponse response) throws Exception {
		
		EmployeeVO loginUser = (EmployeeVO)session.getAttribute("loginUser");
		int loginUser_id_length=("/"+loginUser.getId()).length();
		
		if(oldAttach!=null && !oldAttach.isEmpty()){
			String[] fileNames = oldAttach.split(",");
			for (String fileName : fileNames) {
				String formatName = 
						fileName.substring(fileName.lastIndexOf(".") + 1);
				MediaType mType = MediaUtils.getMediaType(formatName);
	
				if (mType != null) {
					String front = fileName.substring(0, 12+loginUser_id_length);
					String end = fileName.substring(14+loginUser_id_length);
					new File(uploadPath + (front + end)
							.replace('/', File.separatorChar)).delete();
				}
				new File(uploadPath + fileName.replace('/', File.separatorChar))
				.delete();
			}
		}
		
		nService.modify(notice);
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("window.opener.location.reload();");
		out.println("location.href='detail?nno="+notice.getNno()+"';");
		out.println("</script>");	
	}
	
	@RequestMapping(value="getAttach/{nno}",method=RequestMethod.GET)	
	@ResponseBody
	public List<NoticeAttachVO> getAttach(@PathVariable("nno")int nno)
									throws Exception{
		NoticeVO notice=nService.getNotice(nno);
		List<NoticeAttachVO> attachList=notice.getAttachList();
		return attachList;
	}
	
	
}





