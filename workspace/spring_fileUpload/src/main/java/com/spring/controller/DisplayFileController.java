package com.spring.controller;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.utils.MediaUtils;

@Controller
public class DisplayFileController {
	
	// rootContext에 만들어놓은 uploadPath를 가져온다.
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		// 화면으로 파일을 내보내는 작업을 할 것임.
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			
			// inputStrem은 byte단위(글자단위?)로가져옴. // FileInputStream 은 bufferStream.  // FileReader 는 라인단위로가져온다.
			
			// 파일읽어온다음 수정하고재등록.
			// 덮어쓰기/이어쓰기(append)가 가능하지만 부분수정은불가능함.
			// reader, writer는 라인단위로 읽기때문에 서식이없는 text만가능하다. txt, property, cvc? 만.메모장으로열었을때 온전히열리는것만가능.
			fileName = fileName.replace('/', File.separatorChar);
			in=new FileInputStream(uploadPath+fileName);
			
			if(mType!=null) {
				headers.setContentType(mType);
			}else {
				fileName=fileName.substring(fileName.indexOf("$$")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment;filename=\"" + new String(fileName.getBytes("utf-8"),"ISO-8859-1") + "\"");
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		}catch(IOException e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}finally {
			in.close();
		}
		
		
		
		return entity;
	}
}
