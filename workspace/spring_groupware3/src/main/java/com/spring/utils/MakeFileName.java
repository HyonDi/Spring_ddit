package com.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.spring.dto.PdsAttachVO;

public class MakeFileName {
	
	public static String toUUIDFileName(String fileName,String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-","");
		return uuid+delimiter+fileName;
	}
	
	public static String parseFileNameFromUUID(String fileName,
											   String delimiter) {
		String[] uuidFileName=fileName.split(delimiter);
		return uuidFileName[uuidFileName.length-1];
	}
	
	public static List<PdsAttachVO> parseFileNameFromAttaches(
			List<PdsAttachVO> attachList, String delimiter){
		
		List<PdsAttachVO> renamedAttachList=new ArrayList<PdsAttachVO>();
		
		for(PdsAttachVO attach : attachList) {
			String fileName=attach.getFileName(); //DB상의 fileName
			fileName=parseFileNameFromUUID(fileName, delimiter); //uuid가 제거된 fileName
			attach.setFileName(fileName);
			
			renamedAttachList.add(attach);
		}
		return renamedAttachList;
	}
}





