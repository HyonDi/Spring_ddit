package com.jsp.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jsp.utils.GetUploadPath;
import com.jsp.utils.ViewResolver;
import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaClientTube;


@WebServlet("/member/picture/get")
public class GetPictureSevlet extends HttpServlet {
	// 회원detail에서 사진을 보여주는용도이기때문에 get
	// servlet을 만드는 이유 : 이미지에 브라우저가 닿을수없어서 요청해야함.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 화면 없음!
		//String url="";
		
		//2. 파라미터 -파일명 이거..어디서받아온거야...
		String fileName = request.getParameter("picture");
		String savedPath = GetUploadPath.getUploadPath("member.picture.upload");
		
		String filePath = savedPath+fileName;
		
		sendFile(response,filePath);
		
		// 여기서 throws throws ServletException, IOException 하는것들 throws 하지말고 잡는 방법을 생각해보렴.
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void sendFile(HttpServletResponse response, String filePath) throws ServletException, IOException{
		// response로 내보낸다는데 어떻게내보내??
		// response.getWriter().println(filePath); -test
		
		// 보낼 파일 설정
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		// servletContext = header조작을 위해 불러왔다. => 브라우저가 파일임을 인지시키기위해.
		ServletContext context = getServletContext();
		
		// 파일 포맷으로 Mime을 결정한다.
		String mimeType = context.getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type : " + mimeType);
		
		// response 수정.
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		
		response.setHeader(headerKey, headerValue);
		
		// 파일 내보내기
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		
		if(inStream != null) inStream.close();
		if(outStream != null) outStream.close();
	}
	
}
