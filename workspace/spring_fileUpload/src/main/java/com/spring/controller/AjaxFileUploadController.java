package com.spring.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.utils.FileUpload;

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
		
		sourcePath = FileUpload.uploadFile(file, uploadPath);
		
		entity = new ResponseEntity<String>(sourcePath,HttpStatus.CREATED);
		
		
		return entity;
	}
	
}
