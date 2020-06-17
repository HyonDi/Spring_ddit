package com.bms.controller.mypage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.member.MemberVO;
import com.bms.dto.menu.MenuVO;
import com.bms.dto.mypage.PaymentVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.service.menu.MenuService;
import com.bms.service.mypage.MypageService;

@Controller
@RequestMapping("/contract_payment")
public class ownerManagmentController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MypageService mypageService;
	
	@Resource(name="paymentPicturePath")
	private String picturePath;
	
	String fileName;
	
	
	//----------------------------계약
	
	@RequestMapping(value="/contract_management/owner", method=RequestMethod.GET)
	public ModelAndView contract_managementOwnerGETPage(HttpServletRequest request, ModelAndView mnv) throws Exception {
		String url = "contract_payment/contract_management.owner";		
		
		List<MenuVO> menuList1 = null;
		List<MenuVO> menuList2 = null;
		List<MenuVO> menuList3 = null;
		List<MenuVO> menuList4 = null;

		try{
			menuList1 = menuService.selectUnderMenu("MENU01");
			menuList2 = menuService.selectUnderMenu("MENU02");
			menuList3 = menuService.selectUnderMenu("MENU03");
			menuList4 = menuService.selectUnderMenu("MENU04");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		mnv.addObject("menuList1", menuList1);
		mnv.addObject("menuList2", menuList2);
		mnv.addObject("menuList3", menuList3);
		mnv.addObject("menuList4", menuList4);

		mnv.setViewName(url);
		
		return mnv;
	}
	
	
	@RequestMapping("/contract_management/owner/test")
	public ModelAndView contract_managementGET(SearchCriteria cri, ModelAndView mnv, HttpSession session) throws Exception {
		String url = "contract_payment/contract_management";

		MemberVO member =  (MemberVO) session.getAttribute("loginUser");
		
		

		Map<String, Object> dataMap = mypageService.getContractList(cri);
		
		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	
	//----------------------------납부
	
	@RequestMapping(value="/payment_management/owner", method=RequestMethod.GET)
	public ModelAndView payment_managementOwnerGETPage(HttpServletRequest request, ModelAndView mnv) throws Exception {
		String url = "contract_payment/payment_management.owner";		
		
		List<MenuVO> menuList1 = null;
		List<MenuVO> menuList2 = null;
		List<MenuVO> menuList3 = null;
		List<MenuVO> menuList4 = null;

		try{
			menuList1 = menuService.selectUnderMenu("MENU01");
			menuList2 = menuService.selectUnderMenu("MENU02");
			menuList3 = menuService.selectUnderMenu("MENU03");
			menuList4 = menuService.selectUnderMenu("MENU04");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		mnv.addObject("menuList1", menuList1);
		mnv.addObject("menuList2", menuList2);
		mnv.addObject("menuList3", menuList3);
		mnv.addObject("menuList4", menuList4);

		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/payment_management/owner/test")
	public ModelAndView pay_managementGET(SearchCriteria cri, ModelAndView mnv, HttpSession session) throws Exception {
		String url = "contract_payment/payment_management";
		
		MemberVO member =  (MemberVO) session.getAttribute("loginUser");
		
		Map<String, Object> dataMap = mypageService.getPaymentList(cri);
		
		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		
		return mnv;
		 		
	}
	@RequestMapping(value="/registForm")
	public String pay_management_registForm(Model model, HttpSession session)throws Exception{
		String url ="contract_payment/payment_management_regist";
		
		MemberVO owner = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("owner", owner);
		
		return url;
	}
	
	
	@RequestMapping(value="payment_management_regist", method=RequestMethod.POST)
	public ModelAndView pay_management_regist(PaymentVO payment, ModelAndView mnv, HttpSession session)throws Exception{	
		//System.out.println("Controller addSuperintendent POST");
				String url = "contract_payment/regist_success";
				//MemberVO owner = (MemberVO) session.getAttribute("loginUser");
				
				
				
				try {
					payment.setBoard_sort_code(fileName); 
					
					//System.out.println(stock.getItem_picture()+">>>>>>>>>>>>>>"); // null
					//System.out.println("member.toString : >>>>>>>" + member.toString());
					mypageService.regist(payment);
					
					// 인서트 된애를찾아야해- 어떻게찾지...
					//...???
					
					//System.out.println("새로 넣을 member.getMember_code() : >>>" + member.getMember_code());
					//System.out.println("superintendent.toString() : >>>>>>>>>>>>>" + superintendent.toString());
					
					// 이렇게해도 되나????
				}catch(Exception e) {
					url = "contract_payment/regist_fail";
					e.printStackTrace();
				}
				
				//System.out.println("owner : >>>>>>>>" + owner.getMember_code());
				mnv.addObject("payment", payment);
				//mnv.addObject("owner", owner);
				mnv.setViewName(url);
				
				return mnv;
	}
	
	@RequestMapping(value="/picture",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> picture(@RequestParam("pictureFile") MultipartFile multi, 
										  String oldPicture) throws Exception{
		
		ResponseEntity<String> entity=null;
		String result="";
		HttpStatus status=null;
		
		/* 파일유무확인 */
		if (multi.isEmpty()) {			
			result="파일이 없습니다.!";			
			status=HttpStatus.BAD_REQUEST;
		}else 
		/* 용량제한 5MB */
		if (multi.getSize() > 1024 * 1024 * 5) {			
			result="용량초과 입니다";			
			status=HttpStatus.BAD_REQUEST;
		}else{
			/* 파일저장폴더설정 */
			String uploadPath = picturePath;
			// 업로드path를 멤버코드 폴더로 하기위해 
			// 서비스에서 시퀀스 currentval 가져와서 +1한거를 담아둔다. +1 안해도되나봐

			
			fileName = UUID.randomUUID().toString().replace("-", "")+".jpg";			
			File storeFile = new File(uploadPath,fileName);
			
			if(!storeFile.exists()) {
				storeFile.mkdirs();
			}
			// local HDD 에 저장.
			multi.transferTo(storeFile);
			
			if(!oldPicture.isEmpty()){
				File oldFile = new File(uploadPath,oldPicture);
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}
			
			result=fileName;
			status=HttpStatus.OK;
			
		}
		return new ResponseEntity<String>(result,status);
	}
	
	
	
	@RequestMapping("/getPicture")
	@ResponseBody
	public ResponseEntity<byte[]> getPicture(String picture, String member_code)throws Exception{
		//System.out.println("Controller /getPicture");
		//System.out.println("membercode : >>>>>>" + member_code);
		InputStream in=null;
		ResponseEntity<byte[]> entity=null;
		String imgPath = this.picturePath;
		
		// path가.. 각자의 memcode 폴더안에들어있으니까 memcode를 불러와야겠네
		try{
			
			//in=new FileInputStream(imgPath+File.separator+picture);
			in=new FileInputStream(new File(imgPath,picture));
			
			entity=new ResponseEntity<byte[]>(IOUtils.toByteArray(in),HttpStatus.CREATED);
		}catch(IOException e){
			e.printStackTrace();
			entity=new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			in.close();
		}
		
		//System.out.println(entity.toString());
		return entity;
	}
	
}
