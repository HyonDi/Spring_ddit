package com.spring.controller.board;

import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.EmployeeVO;
import com.spring.dto.NoticeAttachVO;
import com.spring.dto.PdsAttachVO;
import com.spring.dto.PdsShareVO;
import com.spring.dto.PdsVO;
import com.spring.request.Criteria;
import com.spring.request.RegistPdsRequest;
import com.spring.service.board.PdsService;
import com.spring.utils.MediaUtils;

@Controller
@RequestMapping("/board/pds/*")
public class PdsBoardController{
	
	@Autowired
	private PdsService pService;
	
	@Autowired
	private String uploadPath;
	


	@RequestMapping("list")
	public ModelAndView pdsList(Criteria cri, HttpSession session,
								ModelAndView modelnView) 
							 		throws SQLException{
		
		String url="board/pds/pds_list";
		
		EmployeeVO loginUser = (EmployeeVO)session.getAttribute("loginUser");
		Map<String,Object> dataMap = pService.getList(cri,loginUser);		
				
		List<ColName> colNames = new ArrayList<ColName>();
		String[] colNameArr = {"번&nbsp;호","제&nbsp;목","작성일","작성자","첨&nbsp;부","조회수"};
		String[] colWidthArr = {"","40","","","5",""};
		for(int i=0;i<colNameArr.length;i++) {
			colNames.add(new ColName(colNameArr[i],colWidthArr[i]));
		}
		
		dataMap.put("colNames", colNames);
		modelnView.addAllObjects(dataMap);
		modelnView.setViewName(url);
		
		
		return modelnView;		
	}
	
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public void pdsRegist(RegistPdsRequest pdsRegistReq
						  ,HttpSession session
						  ,HttpServletResponse response)throws Exception{
		
		PdsVO pds = pdsRegistReq.toPdsVO();
		
		EmployeeVO loginUser = (EmployeeVO)session.getAttribute("loginUser");
		
		pds.getPdsShareList().add(new PdsShareVO(0,"P",loginUser.getId(),loginUser.getName()));  // pno : 0 은 임시...서비스에서 변경됨
		
		pService.regist(pds);		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("window.opener.location.href='/board/pds/list';window.close();");
		out.println("</script>");	
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(int pno, HttpSession session, Model model) throws Exception {
		
		String url="board/pds/pds_detail";
		
		PdsVO pds = pService.read(pno);		
				
		model.addAttribute("pds", pds);
		
		return url;
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public void remove(int nno, HttpServletResponse response) throws Exception {
				
		pService.remove(nno);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("window.opener.location.reload();window.close();");
		out.println("</script>");
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify(int nno, Model model) throws Exception {
		
		String url="board/pds/pds_modify";
		
		//PdsVO pds = pService.getpds(nno);
		//model.addAttribute("pds", pds);
		
		return url;
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public void modifyPOST(String oldAttach,
							 PdsVO pds,
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
		
		pService.modify(pds);
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("window.opener.location.reload();");
		//out.println("location.href='detail?nno="+pds.getNno()+"';");
		out.println("</script>");	
	}
	
	@RequestMapping(value="getAttach/{pno}",method=RequestMethod.GET)	
	@ResponseBody
	public List<PdsAttachVO> getAttach(@PathVariable("pno")int pno)
									throws Exception{
		PdsVO pds=pService.getPds(pno);
		List<PdsAttachVO> attachList=pds.getAttachList();
		return attachList;
	}
	
	
}





