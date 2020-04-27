package com.jsp.action.pds;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.request.PdsRegistRequest;
import com.jsp.service.PdsService;
import com.jsp.utils.GetUploadPath;
import com.jsp.utils.MakeFileName;

public class RegistPdsAction implements Action {
	
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url="pds/regist_success";
		// 잘등록되면 리스트페이지 1페이지로이동시켜야 한다.
		
		
		// 파일저장
		
		// db저장
		// pdsVO가 attach를가져야해??
		// pds대로 insert하고 pds에서 pno랑 writer받아와서 attach 따로 insert할 수도있지만 현재는 동시에 진행할것이기때문에
		// attach insert에필요한 나머지정보들은 파일업로드가먼저되어야 가능하다.
		// 파일저장이먼저야.
		
		
		try {
			PdsVO pds = fileUpload(request);
			
			pdsService.regist(pds);
		} catch(Exception e) {
			// 결과에따른 화면 결정.
			e.printStackTrace();
			url = "pds/regist_fail";
		}
		
		return url;
		// factory : 하드디스크에저장할 준비를 한다.
		// 저장준비할 것.실제저장할 것. 저장할 파라미터 필요하다. (sqlSessionFactory, sqlSession / )

		// 내가 한 것.
		/*String pno = "1"; // 일단 1넣어놓는다.
		
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println("title : " + title);
		
		PdsRegistRequest pdsReq = new PdsRegistRequest(pno,title, writer, content);
		
		PdsVO pds = pdsReq.toPdsVO();
		
		
		try {
			pdsService.regist(pds);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "pds/regist_fail";
		}
		
		return url;*/
	}
	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50 MB 얘는 filesize 보다 커야한다.
	
	
	private PdsVO fileUpload(HttpServletRequest request) throws Exception{
		// pdsVO 주기위함.
		
		
		PdsVO pds = new PdsVO();
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		
		// 1. 파라미터 데이터 저장 : request.getParameter() X  -> enctype 이기때문!
		
		// 업로드를 위한 upload 환결설정 적용.
		DiskFileItemFactory factory  = new DiskFileItemFactory();
		// 저장을 위한 threshold memory 적용.
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// 임시저장 위치 결정.
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 업로드 파일의 크기 적용.
		upload.setFileSizeMax(MAX_FILE_SIZE);
		
		// 업로드 request 크기 적용.
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		
		// 실제 저장 경로를 설정.
		String uploadPath = GetUploadPath.getUploadPath("pds.upload");
		// property uploadPath에 적어놓았다. property는 해당 '.class' 로딩할때 실행한다. - 관리자가 propery변경가능해야함.
		
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
					
					// pdsVO에 넣기위해 구분한것이니 pdsVO 생성한다.
					// pdsVO 생성(위에서 이미했다)
					
				} else {// 파일인지 구분
					
					// 여기서 써머노트의 임시태그들이 같이오기때문에 제외시켜야한다.
					if(!item.getFieldName().equals("uploadFile")) continue; 
					// 우리가 올린  uploadFile이 아니면 취소. 다시위로올라간다.
					// 우리가 선택한 첨부파일이 아니면 다시 위로올라간다.
					
					String fileName = new File(item.getName()).getName();
					fileName = MakeFileName.toUUIDFileName(fileName, "$$");
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					
					// local HDD 에 저장.
					try {
						item.write(storeFile);
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
					
					// DB에 저장할 attach에 file 내용 추가.
					AttachVO attach = new AttachVO();
					attach.setFileName(fileName);
					attach.setUploadPath(uploadPath);
					attach.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));// 확장자
					
					// 각각의 attach를 list<attachVO>에 담는다.
					attachList.add(attach);
					
					System.out.println("upload file : " + attach);
					
				} // -- if-else 끝
			} // -- for문 끝
			// pdsVO에 attach넣는다.
			pds.setAttachList(attachList);
			pds.setWriter(writer);
			pds.setContent(content);
			pds.setTitle(title);
			
			
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw e;
			// 화면구분은 위에 excute 메서드에서하니까 여기선 throw하고 excute메서드에서 trycatch해야한다.
		}
		
		 return pds;
	}
}
