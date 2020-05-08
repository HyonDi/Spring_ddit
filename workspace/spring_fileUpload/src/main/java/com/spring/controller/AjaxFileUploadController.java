package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.utils.FileUpload;
import com.spring.utils.MediaUtils;

@Controller
public class AjaxFileUploadController {

	
	/*@Autowired
	private String uploadPath;
	*/
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@ RequestMapping("/ajaxFileUploadForm")
	public void ajaxFileUploadForm() {}
	
	// 한글파일명올리면 깨지기때문에(인코딩필터로잡을수없음) prodeuces = "text/plain;charset=utf-8" 을 단다. 한글파일명깨짐방지.
	
	@RequestMapping(value = "/uploadAjax",method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		
		ResponseEntity<String> entity = null;
		
		String sourcePath = null;
		
		try {
			sourcePath = FileUpload.uploadFile(file, uploadPath);
			entity = new ResponseEntity<String>(sourcePath,HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		return entity;
	}
	
	@RequestMapping(value="/deleteFile",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> deleteFile(@RequestBody Map<String,String> dataMap) throws Exception{
										// @RequestBody!! 있는 String을 jackson이 변환해준다. => 였는데 String fileName을 Map<String,String> dataMap로 바꿨음.
										// VO나 Request , Map같은 객체형태로 받아서 꺼내서 써라.  
										// jar : jacksonData bind는 꼭필요함.
										// String주면 jasonString그대로 가져와서 문제가 생김. handlerAdator때문임!
										
		
		String fileName = dataMap.get("fileName");
		
		System.out.println("fileName : " + fileName);
		
		ResponseEntity<String> entity = null; // return할것!
		
		
		
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		MediaType mType = MediaUtils.getMediaType(formatName);
		
		try {
			if(mType!=null) {
				String front = fileName.substring(0,12);
				String end = fileName.substring(14);
				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
				
			}
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
			
			entity = new ResponseEntity<String>("deleted",HttpStatus.OK);
		
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return entity;
	}
	
	
}
