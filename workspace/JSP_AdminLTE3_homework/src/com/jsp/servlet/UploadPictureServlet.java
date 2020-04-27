package com.jsp.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jsp.utils.GetUploadPath;
import com.jsp.utils.MakeFileName;
import com.jsp.utils.MakeLogForException;


//@WebServlet("/member/picture")
public class UploadPictureServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return;
		// 파일업로드를 하기위해 반드시 doPost를 해야함.
		// 여기서 doPost(request, response); 하면 안돼.
		// 파일에 손상이 있을 수 있다.
	}
	
	
	// 업로드 파일 환경 설정
	// threshold : 얼마단위로 저장할거냐???. 그 단위로 임시디렉토리에 저장해라.
	private static final int MEMORY_THRESHOLD = 1024*500; // 500KB
	private static final int MAX_FILE_SIZE = 1024*1024; // 1MB
	private static final int MAX_REQUEST_SIZE = 1024*1024*2;// 2MB

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = null;
		try {
			fileName = saveFile(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			// 위는 즉시 보기위함.개발중에 에러확인위함. (e.printStackTrace();) 유지보수위해서는 로그를관리해야해.
			
			// request (uri 뽑기용), exception 을 보낸다!! return은 void야!
			MakeLogForException.makeLog(request, e); // 이거는 사용자가 확인할것이아님. 얘 trycatch따로해야해.
			
			throw new IOException("파일 업로드 실패"); 
			// 사용자화면용 ( ajax ) 화면이필요한거면 화면을 내보냈을거고, 얼럿이필요하면 얼럿을했을건데 우리는 파일을 저장하는것뿐이야
		}
		
		
		// 캐치순서 중요!!! 맨 위 캐치가 못받으면 아래로 내리고 ....
		// 최상위층이 맨위로 올리면 안됌.상속계층으로 돼있어야한다.
		// 부모가 맨 아래.
		
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(fileName);

	}
	
	private String saveFile(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException, Exception {
		// return "fileName.jpg"; - test

		// 리퀘스트를 형변환시켜서 파일이 있는지 없는지 확인.
		// reference타입은 항상 null비교가 가장 먼저.
		// if조건식 : request가 multipartContent 타입인가? 
		// multipartContent : form을 여러개로 나눠서 보내는방식.
		// enctype : 서버로 전송되기 전에 url-encode 된다는 뜻.
		if(!ServletFileUpload.isMultipartContent(request)) { // 파일이 없으면?
			// return null; // throw exception message 처리
			// ajax가 success인줄알고 이름없는데 업로드시켜버린다.
			
			throw new Exception();
			// 바로 위로 올라갈것임. throw만나서.
			// 위에서는 throw해서 ajax가 error를 만나게해야함.(톰캣이 처리하게)
			// 사용자: 우리가만든에러화면을본다.
			// 우리 : 로거를남김
			// 관리자 : csv파일연다.
		}
		
		// 업로드를 위한 upload 환경설정 적용.
		// DiskFileItemFactory : 임시디렉토리에 저장시킨 링크
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 저장을 위한 threshold memory 적용.
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		
		// 임시 저장위치 결정.
		// java.io.tmpdir : 자바가 쓰고있는 temporaryDirectory(임시디렉토리)에 임시저장하자. -하드디스크
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		// 리퀘스트를 전환시킵니다!! ServletFileUpload가!
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		
		//============================여기까지 임시저장을 위한 코드. 아래부터는 실제파일저장위함.
		
		
		
		// 업로드 파일의 크기 적용.
		upload.setFileSizeMax(MAX_FILE_SIZE);
		
		// 업로드 request 크기 적용.
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		// 실제 저장 경로를 설정.
		String uploadPath = GetUploadPath.getUploadPath("member.picture.upload");
		File file = new File(uploadPath);
		
		// mkdirs() : makeDirectory. user/member/picture 모든 경로의 폴더를 전부 만든다.(만들 디렉토리 : user, member, picture) 
		// mkdir() :  최하위 폴더만 만든다. user, member가 있을때에만 사용가능함. (picture만 만듬)
		// 둘다 디렉토리를 만들면 true, 안만들면 false 나옴.(디렉토리가 이미 있으면 안만들고 없으면 만든다.)
		if(!file.mkdirs()) {
			System.out.println(uploadPath + "가 이미 존재하거나 실패했습니다.");
		};
		
		// request로부터 받는 파일을 추출해서 저장.
		// trycatch 하는 이유 : throws안하고? => saveFile 메서드에서 throws 하고있는 에러랑 달라서.
		// 메서드에서 throw하는 익셉션을 상속받은 익셉션이면 throw가 가능하다.
		
			List<FileItem> formItems = upload.parseRequest(request);
			// request를 List<FileItem>으로 바꾸는데, form에있는걸 하나하나꺼내서 파일인지아닌지 확인한다.
			// file아니면 버림.
			String fileName = null;
			if(formItems != null && formItems.size() > 0) {
				for (FileItem item : formItems) { // form items 반복하여 꺼내는 구문
					if (!item.isFormField()) { // 파일일 경우 해당.+ 업로드된 파일 저장.
						
						// uuid + 구분자 + 파일명
						fileName = MakeFileName.toUUIDFileName(".jpg", "");
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						
						// local HDD에 저장.!!!!
						// 저장이안되면 터진다.따라서 예외처리. 
						item.write(storeFile);
						
					}else { // old Picture 삭제.!!!!
						// oldPicture : regist.jsp의 inpu#oldFile의 name 이야!
						
						switch (item.getFieldName()) {
						case "oldPicture" :// jdk1.7 이상에서는 switch문 String비교가된다.
							String oldFileName = item.getString("utf-8");
							
							// MakeFileName 클래스에 delimiter 가 한글일수도있으니 ,
							// 다른 인코딩으로 되어있을수도있으니 항상함!
							
							File oldFile = new File(uploadPath + File.separator + oldFileName);
							if(oldFile.exists()) {// 있는지 먼저 체크해야함.(없으면 터짐!)
								oldFile.delete();
							}
							break;
						}
					}
				}
			}
		return fileName;
	}
}


