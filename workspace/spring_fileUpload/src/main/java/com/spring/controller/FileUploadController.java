package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileUploadForm")
	public void form() {};
	
	@RequestMapping(value = "/multipartFile",method = RequestMethod.POST)
	public String uploadByMultipartFile(String title, MultipartFile file) throws Exception{
		
		System.out.println(title);
		System.out.println(file.getOriginalFilename());
		
		return null;
	}
}	
	