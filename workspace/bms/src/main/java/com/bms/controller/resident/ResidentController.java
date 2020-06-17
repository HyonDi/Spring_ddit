package com.bms.controller.resident;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

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

import com.bms.dto.member.ResidentVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.service.resident.ResidentService;

@Controller
@RequestMapping("/resident")
public class ResidentController {
	
	@Autowired
	private ResidentService residentService;
	
	@Autowired
	private String memberPicturePath;
	
	@RequestMapping("mobileList")
	public ModelAndView mobileList(SearchCriteria cri, ModelAndView mnv) throws Exception{
		String url = "mobile/residentList";
		
		Map<String, Object> dataMap = residentService.getResidentAll(cri);
		
		mnv.setViewName(url);
		mnv.addAllObjects(dataMap);
		
		return mnv;
	}
	
	@RequestMapping(value = "/picture/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> getPicture(@PathVariable("id") String member_code) throws Exception{
		
		ResidentVO resident = residentService.getResidentByCode(member_code);
		System.out.println(resident.toString());
		
		String picture = resident.getMember_picture();
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String savePath = memberPicturePath + File.separator + resident.getMember_code();
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

}
