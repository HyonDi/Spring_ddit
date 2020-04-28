package com.daejeon.action.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daejeon.action.Action;
import com.daejeon.dto.AttachVO;
import com.daejeon.dto.BoardVO;
import com.daejeon.service.BoardService;
import com.daejeon.utils.MakeFileName;


public class GetAttachAction implements Action {

	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;// 화면 없음. 이미지 저장하는 일만 할것임.
		
		// pno, ano 넘어올것이다.
		int bno = Integer.parseInt(request.getParameter("bno"));
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		try {
			BoardVO board = boardService.getBoardForModify(bno);
			
			// pds로부터 attach List 를 꺼내온다.
			// 하나하나 꺼내며 이 중 ano가 같은 리스트를 뽑는다.
			List<AttachVO> attachList = board.getAttachList();
			
			// 변수선언 밖에 한다.
			String fileName = null;
			String filePath = null;
			
			for(AttachVO attach : attachList) {
				if(ano == attach.getAno()) {
					fileName = attach.getFileName();
					filePath = attach.getUploadPath();
					break;
				}
			}
			
			// 파일 저장
			sendFile(request, response, fileName, filePath);
			
		} catch (Exception e) {
			e.printStackTrace();
			url="error/500_error";
		}
		
		return url;
	}

	
	private void sendFile(HttpServletRequest request, HttpServletResponse response, String fileName, String filePath) throws Exception{
		filePath = filePath + File.separator + fileName;
		
		// 읽어들인다. 보낼파일 설정.
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		// 브라우저에게 이미지/혹은 파일이라고 말해주는 과정필요.
		// 헤더를 세팅한다.(컨텍스트가 필요해)
		ServletContext context = request.getServletContext();
		
		// 파일 포맷으로 MIME을 결저한다. 
		String mimeType = context.getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		
		// response 수정.
		response.setContentType(mimeType);
		response.setContentLength((int)downloadFile.length());
		
		// file명은 Header에달려나가기때문에 파일명붙일때 반드시 인코딩해줘야합니다.
		// 인코딩필터가 있지만 body거만 해당됩니다. header거는 해당 안돼.
		// file은 바디에, file명은 헤더에 있다. 꼭 기억해라.
		// 파일명 한글깨짐 방지 : utf-8
		String downloadFileName = new String(downloadFile.getName().getBytes("utf-8"),"ISO-8859-1");
		downloadFileName = MakeFileName.parseFileNameFromUUID(downloadFileName, "\\$\\$");
		
		// response header setting
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFileName);
		response.setHeader(headerKey, headerValue);
		
		// 파일 내보내기
		// bytesRead 가 없으면 -1을 리턴한다. = 끝났다. = end of file . 
		// 그런데 이 while문 하다 터지면 stream이 안닫히니 try로 묶고 finally 에서 null판단하고 닫는다.
		// 읽으면서 내보내는것임.
		OutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			
			while ((bytesRead = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
		}finally {
			if(inStream!=null) inStream.close();
			if(outStream!=null) outStream.close();
		}
	}
}
