package com.daejeon.action.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.daejeon.action.Action;
import com.daejeon.dto.AttachVO;
import com.daejeon.dto.BoardVO;
import com.daejeon.service.BoardService;
import com.daejeon.utils.GetUploadPath;
import com.daejeon.utils.MakeFileName;

public class BoardRegistAction implements Action{

	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="board/regist_success";
		
		try {
			BoardVO board = fileUpload(request);
			
			boardService.write(board);
		} catch(Exception e) {
			// 결과에따른 화면 결정.
			e.printStackTrace();
			url = "board/regist_fail";
		}
		
		return url;
	}

	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50 MB 얘는 filesize 보다 커야한다.
	
	
	private BoardVO fileUpload(HttpServletRequest request) throws Exception{
		
		
		BoardVO board = new BoardVO();
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		
		
		DiskFileItemFactory factory  = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(MAX_FILE_SIZE);
		
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		
		String uploadPath = GetUploadPath.getUploadPath("board.upload");
		
		File file = new File(uploadPath);
		
		if(!file.mkdirs()) {
			System.out.println(uploadPath + "가 이미 존재하거나 생성을 실패했습니다.");
		}
		
		try {
			List<FileItem> formItems = upload.parseRequest(request);
			
			// 저장하는 작업 시작.
			String title = null;
			String writer = null;
			String content = null;
			int pno = -1; // pno가 0 혹은 null 일때 잘못된 값이 나오지 않게하기위해 -1을 넣어놓았다.

			// formItem : request에들어있는 각각의 항목들.
			// 집합체for문쓸때 null판단꼭 해야한다.
			for(FileItem item : formItems) {
				// 필드인 것 구분
				if(item.isFormField()) {		// formfield : 일반 파라미터.
					// 필드인건알지만 어떤필드인지모른다. -> 파라미터구분을해야함.
					// 파라미터 구분(파라미터이름)
					switch(item.getFieldName()) {
					case "title":
						title = item.getString("utf-8");
						break;
					case "writer":
						writer = item.getString("utf-8");
						break;
					case "content":
						content = item.getString("utf-8");
						break;
					}
					
					
				} else {// 파일인지 구분
					
					if(!item.getFieldName().equals("uploadFile")) continue; 
					
					String fileName = new File(item.getName()).getName();
					fileName = MakeFileName.toUUIDFileName(fileName, "$$");
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					
					try {
						item.write(storeFile);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
					
					AttachVO attach = new AttachVO();
					attach.setFileName(fileName);
					attach.setUploadPath(uploadPath);
					attach.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));// 확장자
					
					attachList.add(attach);
					
					System.out.println("upload file : " + attach);
					
				} // -- if-else 끝
			} // -- for문 끝
			board.setAttachList(attachList);
			board.setWriter(writer);
			board.setContent(content);
			board.setTitle(title);
			
			
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw e;
		}
		
		 return board;
	}
}
