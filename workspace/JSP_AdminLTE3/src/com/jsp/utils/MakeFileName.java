package com.jsp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jsp.dto.AttachVO;

/**
 * UUID 로 사진 이름 고유하게 만들것이다.
 * @author PC-16
 *
 */
public class MakeFileName {
	
	public static String toUUIDFileName(String fileName, String delimiter) {
		
		// 지구상에 딱 하나인!!
		// 회원등록 원래이미지 파일명을 유지시키지 않을거가 delimiter는 "" 빈문자 줄것임.
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}
	
	public static String parseFileNameFromUUID(String fileName, String delimiter) {
		String[] uuidFileName = fileName.split(delimiter);
		return uuidFileName[uuidFileName.length-1];
	}
	
	public static List<AttachVO> parseFileNameFromAttaches(List<AttachVO> attachList, String delimiter) {
		List<AttachVO> renamedAttachList = new ArrayList<AttachVO>();
		
		for(AttachVO attach : attachList) {
			String fileName = attach.getFileName();// DB 상의  fileName
			fileName = parseFileNameFromUUID(fileName, delimiter); // uuid 가 제거된 fileName
			attach.setFileName(fileName);
			
			renamedAttachList.add(attach);
			
		}
		return renamedAttachList;
	}
	
}
