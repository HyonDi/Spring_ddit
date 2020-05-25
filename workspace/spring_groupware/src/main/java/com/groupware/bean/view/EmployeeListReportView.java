package com.groupware.bean.view;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.servlet.view.AbstractView;

import com.groupware.request.SearchCriteria;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

public class EmployeeListReportView extends AbstractView{
	
	// jasper가 query문 실행하려면 dataSource가 필요하다. dataSource를 property로 인가해줘야함.
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
										   HttpServletRequest request,
										   HttpServletResponse response) throws Exception {
		// model.get("cri"),model.get("type") 하면 받을수 있겠구나.
		String type = (String)model.get("type");
		SearchCriteria cri = (SearchCriteria)model.get("cri");
		
		//System.out.println(type + "형식으로 출력합니다.");
		
		String jrFileName = "employee_list.jrxml";
		
		// 1. 파라메터 추가
		Map<String, Object> params = new HashMap<String, Object>();
		//params.put("page",cri.getPage());
		//params.put("perPageNum",cri.getPerPageNum());
		//params.put("keyword", cri.getKeyword());
		//params.put("searchType", cri.getSearchType());
		// jrxml에 파라미터로 넣을것이다. > 쿼리문 파라미터로 들어간다.
		
		// * (classpath: 한거 = 배포될 때 classes 를 말함.)
		
		//
		Map<String, String> searchType= new HashMap<String, String>();
		
		searchType.put("i", "id");
		searchType.put("n", "name");
		searchType.put("e", "email");
		
		String query = "select * from employee ";
		
		if(cri.getSearchType()!=null) {
			query += "where " + searchType.get(cri.getSearchType()) + " like '%'||'" + cri.getKeyword()+"'||'%'";
		}
		
		System.out.println("query:" + query);
		params.put("query", query);
		//
		
		// 2. jrxml 템플릿 결정/로딩
		InputStream reportStream = 
			this.getClass().getResourceAsStream("/com/groupware/jrxml/" + jrFileName);
		
		// 3. 템플릿을 JasperDesign으로 변환
		JasperDesign jd = JRXmlLoader.load(reportStream);
		
		// 4. jrxml 컴파일
		JasperReport jr = JasperCompileManager.compileReport(jd);
		
		// 5. JasperPrint 생성
		// export(?)할수있는 jasperPrint. 파라미터와 datasource를 넣는다.
		JasperPrint jp = 
				JasperFillManager.fillReport(jr, params, dataSource.getConnection());
		
		// 원천소스가 만들어진 상태.
		
		// 내보낼준비를 합니다.
		// 6. outputStram 생성
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// 7. exporter() 실행
		export(type, jp, response, baos);
		
		// 8.response 이용한 전송.
		write(response, baos);
		
	}
	// 헤더에들어갈 공통값을 미리 상수값으로 정해두었다.
	public static final String MEDIA_TYPE_EXCEL="application/vnd.ms-excel";
	public static final String MEDIA_TYPE_PDF="application/pdf";
	public static final String EXTENSION_TYPE_EXCEL="xls";
	public static final String EXTENSION_TYPE_PDF="pdf";
	
	public void export(String type, JasperPrint jp, HttpServletResponse response,
			  			ByteArrayOutputStream baos) throws RuntimeException{
		
		// type 이 xls로 들어오면 아래 exportXls() 실행. pdf로 들어오면 exportPdf(). 
		// header(file명)을 맞춰줘야한다.
		if(type.equalsIgnoreCase(EXTENSION_TYPE_EXCEL)) {
			exportXls(jp,baos);// 얘가 jasperPrint를 xls로 내보내게 해줄것임. 그리고 그걸 ByteArrayOutputStream으로 내보낼수있게해준다.
			
			String fileName="MemberList.xls";// file명. 영어여서 encoding하지않아도된다.
			response.setHeader("Content-Disposition", "inline; filename="+fileName);// header세팅.
			response.setContentType(MEDIA_TYPE_EXCEL);
			response.setContentLength(baos.size());			
		}else if(type.equalsIgnoreCase(EXTENSION_TYPE_PDF)) {
			exportPdf(jp,baos);
			
			String fileName="MemberList.pdf";
			response.setHeader("Content-Disposition", "inline; filename="+fileName);
			response.setContentType(MEDIA_TYPE_PDF);
			response.setContentLength(baos.size());
			
		}else {	
			throw new RuntimeException("No type set for type "+type);
		}
	}
	private void write(HttpServletResponse response, ByteArrayOutputStream baos) {
		try {

			ServletOutputStream outputStream = response.getOutputStream();
			baos.writeTo(outputStream);
			outputStream.flush();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// 엑셀변환해주는 메서드
	public void exportXls(JasperPrint jp,ByteArrayOutputStream baos) {
		
		// 시트하나에한 페이지.(true줘야한다. default=false)
		JRXlsExporter exporter=new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jp));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
		SimpleXlsReportConfiguration configuration=new SimpleXlsReportConfiguration();
		configuration.setOnePagePerSheet(true);
		exporter.setConfiguration(configuration);
		try {
			exporter.exportReport();
		}catch(JRException e) {
			throw new RuntimeException(e);
		}
	}
	
	// pdf 변환해주는 매서드
	public void exportPdf(JasperPrint jp,ByteArrayOutputStream baos) {
		JRPdfExporter exporter=new JRPdfExporter();
		
		exporter.setExporterInput(new SimpleExporterInput(jp));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
		
		SimplePdfReportConfiguration configuration=new SimplePdfReportConfiguration();		
		exporter.setConfiguration(configuration);
		
		try {
			exporter.exportReport();
		}catch(JRException e) {
			throw new RuntimeException(e);
		}
	} 
	
	
}






