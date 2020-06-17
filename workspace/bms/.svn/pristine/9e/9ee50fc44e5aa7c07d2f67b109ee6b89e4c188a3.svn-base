package com.bms.controller.item;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

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

import com.bms.dto.item.ItemVO;
import com.bms.dto.menu.MenuVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.service.item.ItemService;
import com.bms.service.menu.MenuService;

@Controller
@RequestMapping("/facility_stock/facility_supply_management/")
public class ItemController {

	@Resource(name="picturePath")
	private String picturePath;
	
	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	@Autowired
	private MenuService menuService;
	String fileName = "";
	
	@RequestMapping("/owner")
	public ModelAndView getItemMain_owner(ModelAndView mnv) throws Exception {
		
		String url = "item/itemList.owner";
		List<MenuVO> menuList1 = menuService.selectUnderMenu("MENU01");
		List<MenuVO> menuList2 = menuService.selectUnderMenu("MENU02");
		List<MenuVO> menuList3 = menuService.selectUnderMenu("MENU03");
		List<MenuVO> menuList4 = menuService.selectUnderMenu("MENU04");

		mnv.addObject("menuList1", menuList1);
		mnv.addObject("menuList2", menuList2);
		mnv.addObject("menuList3", menuList3);
		mnv.addObject("menuList4", menuList4);
		mnv.setViewName(url);
		
		return mnv;
	}
	@RequestMapping(value="/owner/test")
	public ModelAndView stockList(SearchCriteria cri, ModelAndView mnv)throws Exception{
		String url = "item/itemList";
		
		Map<String, Object> dataMap = itemService.getItemList(cri);
		
		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		
		return mnv;
	}
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registForm()throws Exception{
		String url = "item/regist";
		
		return url;
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ModelAndView registPost(ItemVO item, ModelAndView mnv) throws Exception{
		String url = "item/regist_success";
		try {
			item.setItem_picture(fileName);
			System.out.println(item.getItem_picture()+">>>>>>>>>>>>>>"); // null
			itemService.insertStock(item);
		}catch(Exception e) {
			url = "item/regist_fail";
			e.printStackTrace();
		}
		mnv.addObject("item", item);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView detail(String item_code, @ModelAttribute("cri") SearchCriteria cri, ItemVO item, ModelAndView mnv)throws Exception{
		String url = "item/detail";
		
		item = itemService.getStockByItemCode(item_code);
		
		mnv.addObject("item", item);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(String item_code, @ModelAttribute("cri") SearchCriteria cri, ModelAndView mnv)throws Exception{
		String url = "item/delete_success";
		
		ItemVO item = itemService.getStockByItemCode(item_code);
		fileName = item.getItem_picture();
		File file = new File(picturePath,fileName);
		if(file.exists()) {
			file.delete();
		}
		
		itemService.deleteStock(item_code);
		mnv.addObject("item", item);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/modifyForm")
	public ModelAndView modifyGet(String item_code, @ModelAttribute("cri") SearchCriteria cri, ItemVO item, ModelAndView mnv)throws Exception{
		String url = "item/modify";
		
		item = itemService.getStockByItemCode(item_code);
		mnv.addObject("item", item);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modifyPost(ItemVO item, Model model)throws Exception{
		String url = "item/modify_success";
		
		try {
			item.setItem_picture(fileName);
			System.out.println(item.getItem_code()); //null
			itemService.modifyStock(item);
			model.addAttribute("item", item);
		}catch(SQLException e) {
			url = "item/modify_fail";
			e.printStackTrace();
		}
		
		return url;
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
			fileName = UUID.randomUUID().toString().replace("-", "")+".jpg";			
			File storeFile = new File(uploadPath,fileName);
			
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
	public ResponseEntity<byte[]> getPicture(String picture)throws Exception{
		InputStream in=null;
		ResponseEntity<byte[]> entity=null;
		String imgPath = this.picturePath;
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
		return entity;
	}
}
