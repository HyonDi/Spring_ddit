package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.command.FileUploadCommand;
import com.spring.exception.EmptyMultipartFileException;
import com.spring.exception.OverflowFileSizeException;
import com.spring.utils.FileUpload;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileUploadForm")
	public void form() {};
	
	@RequestMapping(value = "/multipartFile",method = RequestMethod.POST)
	public String uploadByMultipartFile(String title, @RequestParam("file") MultipartFile multi,HttpServletRequest request, Model model) throws Exception{
		
		String url = "fileUpload_success";
		
		// PrintWriter out = response.getWriter();
		
		try {
			
			File uploadfile = FileUpload.saveFile(multi,request);
			
			model.addAttribute("title", title);
			model.addAttribute("originalFileName",multi.getOriginalFilename());
			model.addAttribute("uploadedFileName",uploadfile.getName());
			model.addAttribute("uploadPath",uploadfile.getAbsolutePath());
			
		} catch(EmptyMultipartFileException | OverflowFileSizeException e) {
			e.printStackTrace();
			model.addAttribute("exception",e);
			url = "fileUpload_fail";
		} catch(IOException e) {
			url = "error/500_error";
		}
		
		return url;
	}
	
	/*private File saveFile(MultipartFile multi, HttpServletRequest request) throws EmptyMultipartFileException, OverflowFileSizeException, IOException{
		// 여기서는 trycatch를 하지 않는다. throw만 함.

		if(multi.isEmpty()) {
			throw new EmptyMultipartFileException();
		}
		
		if(multi.getSize() > 1024 * 1024 * 5) {
			throw new OverflowFileSizeException();
		}
		
		
		 파일 저장 폴더 설정 
		String uploadPath = request.getServletContext().getRealPath("resources/upload");
		
		 파일명 중복 방지 
		String fileName = UUID.randomUUID().toString().replace("-", "") + "$$" + multi.getOriginalFilename();
		
		파일 경로 확인 및 생성
		File file = new File(uploadPath,fileName);
		
		파일 경로 생성
		if(!file.exists()) {
			file.mkdirs();
		}
		
		파일 저장
		multi.transferTo(file);
		
		return file;
		
	}*/
	@RequestMapping("multipartHttpServletRequest")
	public String uploadByMultipartHttpServletRequest(MultipartHttpServletRequest request, Model model) throws IOException{
		
		String url = "fileUpload_success";
		
		String title = request.getParameter("title");
		MultipartFile multi = request.getFile("file");
		
		try {
			
			File uploadfile = FileUpload.saveFile(multi,request);
			
			model.addAttribute("title", title);
			model.addAttribute("originalFileName",multi.getOriginalFilename());
			model.addAttribute("uploadedFileName",uploadfile.getName());
			model.addAttribute("uploadPath",uploadfile.getAbsolutePath());
			
		} catch(EmptyMultipartFileException | OverflowFileSizeException e) {
			e.printStackTrace();
			model.addAttribute("exception",e);
			
			url = "fileUpload_fail";
		}
		
		return url;
		
		
	}
	
	@RequestMapping(value="/commandObject",method=RequestMethod.POST)
	public String uploadByCommandObject(FileUploadCommand command, HttpServletRequest request, Model model) throws IOException{
		
		String url = "fileUpload_success";
		
		MultipartFile multi = command.getFile();
		String title = command.getTitle();
		
			try {
			
			File uploadfile = FileUpload.saveFile(multi,request);
			
			model.addAttribute("title", title);
			model.addAttribute("originalFileName",multi.getOriginalFilename());
			model.addAttribute("uploadedFileName",uploadfile.getName());
			model.addAttribute("uploadPath",uploadfile.getAbsolutePath());
			
		} catch(EmptyMultipartFileException | OverflowFileSizeException e) {
			e.printStackTrace();
			model.addAttribute("exception",e);
			
			url = "fileUpload_fail";
		}
		
		return url;
		
		
	}
}	
	