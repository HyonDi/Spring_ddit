package com.spring.controller.employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.CareerVO;
import com.spring.dto.EmployeeVO;
import com.spring.request.Criteria;
import com.spring.request.ModifyEmployeeRequest;
import com.spring.request.RegistEmployeeRequest;
import com.spring.service.employee.DepartmentService;
import com.spring.service.employee.EmployeeService;
import com.spring.service.employee.PositionService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService deptService;

	@Autowired
	private PositionService positionService;

	@Resource(name = "employeeAttachPath")
	private String employeeAttachPath;

	@ModelAttribute("subMenuList")
	public List<String[]> subMenuModel(HttpServletRequest request) {
		List<String[]> subMenuList = new ArrayList<String[]>();

		String rootPath = request.getContextPath() + "/board";
		String[] icons = { "fa-search-plus", "fa-inbox", "fa-hacker-news", "fa-pencil-square-o", "fa-archive" };

		subMenuList.add(new String[] { "통합검색", rootPath + "/search", "SUB10001", icons[0] });
		subMenuList.add(new String[] { "연도별 신입사원검색", "", "SUB10002", icons[1] });
		subMenuList.add(new String[] { "출퇴근조회", rootPath + "", "SUB10003", icons[2] });
		subMenuList.add(new String[] { "부서검색", rootPath + "", "SUB10004", icons[3] });
		subMenuList.add(new String[] { "이달의 우수사원", rootPath + "", "SUB10005", icons[4] });

		return subMenuList;
	}

	@RequestMapping("")
	public String employeeMain()throws Exception{
		return "employee/main";
	}
		
	@RequestMapping("list") // @GetMapping("list") : spring 4.3
	public ModelAndView list(Criteria cri, ModelAndView mnv) throws Exception {
		String url = "employee/employee_list";

		mnv.addAllObjects(employeeService.getEmployeeList(cri));
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registGet(Model model) throws Exception {
		String url = "employee/regist";

		model.addAttribute("positionList", positionService.getPosotionList());
		model.addAttribute("deptList", deptService.getDeptList());

		return url;
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPost(RegistEmployeeRequest empReq, Model model) throws Exception {

		String url = "employee/regist_ok";

		EmployeeVO employee = empReq.toEmployeeVO();
		List<CareerVO> careers = new ArrayList<CareerVO>();

		for (CareerVO career : empReq.getCareers()) {
			career.setId(empReq.getId());
			careers.add(career);
		}

		// 첨부파일 저장 : picture, licenseDoc, graduDoc, scoreDoc
		MultipartFile[] files = { empReq.getPicture(), empReq.getLicenseDoc(), empReq.getGraduDoc(),
				empReq.getScoreDoc() };
		List<String> saveFileName = new ArrayList<String>();
		for (MultipartFile file : files) {
			if (file==null) continue;
			String fileName = UUID.randomUUID().toString().replace("-", "") + "$$" + file.getOriginalFilename();
			File savePath = new File(employeeAttachPath + File.separator + empReq.getId());
			if (!savePath.exists()) {
				savePath.mkdirs();
			}

			file.transferTo(new File(savePath, fileName));
			saveFileName.add(fileName);
		}

		// EmployeeVO 에 각 attach set.
		employee.setPicture(saveFileName.get(0));
		employee.setLicenseDoc(saveFileName.get(1));
		employee.setGraduDoc(saveFileName.get(2));
		employee.setScoreDoc(saveFileName.get(3));

		System.out.println(employee);
		System.out.println(careers);

		employeeService.regist(employee, careers);

		model.addAttribute("employee", employee);
		return url;
	}

	@RequestMapping("/detail")
	public String detail(String id, Model model) throws Exception {
		String url = "employee/detail";

		Map<String, Object> dataMap = employeeService.getEmployee(id);

		EmployeeVO employee = (EmployeeVO) dataMap.get("employee");
		EmployeeVO register = (EmployeeVO) employeeService.getEmployee(employee.getRegister()).get("employee");

		dataMap.put("register", register);
		model.addAllAttributes(dataMap);

		return url;
	}
	
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modifyGET(String id,Model model)throws Exception{
		String url="employee/modify";
		
		Map<String, Object> dataMap = employeeService.getEmployee(id);

		EmployeeVO employee = (EmployeeVO) dataMap.get("employee");
		EmployeeVO register = (EmployeeVO) employeeService.getEmployee(employee.getRegister()).get("employee");

		dataMap.put("register", register);
		
		model.addAttribute("positionList", positionService.getPosotionList());
		model.addAttribute("deptList", deptService.getDeptList());
		
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPOST(ModifyEmployeeRequest modifyReq,HttpSession session,
							 Model model)throws Exception{
		String url="employee/modify_ok";
		

		EmployeeVO employee = modifyReq.toEmployeeVO();
		List<CareerVO> careers = modifyReq.getCareerList();
				

		// 첨부파일 저장 : picture, licenseDoc, graduDoc, scoreDoc
		employee.setPicture(saveFile(modifyReq.getPicture(),modifyReq.getOld_picture(),modifyReq.getId()));
		employee.setLicenseDoc(saveFile(modifyReq.getLicenseDoc(),modifyReq.getOld_licenseDoc(),modifyReq.getId()));
		employee.setGraduDoc(saveFile(modifyReq.getGraduDoc(),modifyReq.getOld_graduDoc(),modifyReq.getId()));
		employee.setScoreDoc(saveFile(modifyReq.getScoreDoc(),modifyReq.getOld_scoreDoc(),modifyReq.getId()));

		employeeService.modify(employee, careers);
		
		EmployeeVO loginUser = (EmployeeVO)session.getAttribute("loginUser");
		
		
		if(loginUser.getId().equals(employee.getId())) {		
			loginUser = (EmployeeVO)employeeService.getEmployee(employee.getId()).get("emoployee");			
			session.setAttribute("loginUser", loginUser);
		}
		model.addAttribute("employee", employee);
		
		return url;				
	}
	
	private String saveFile(MultipartFile file,String old_fileName,String id) throws Exception{
		if (file==null || file.isEmpty()) { 
			if(old_fileName==null || old_fileName.isEmpty()) {
				File oldFile = new File(employeeAttachPath + File.separator + id,old_fileName);
				if(oldFile.exists()) oldFile.delete();
				return "";
			}
			return old_fileName;
		}		
			
		//기존 파일 삭제
		File oldFile = new File(employeeAttachPath + File.separator + id,old_fileName);
		if(oldFile.exists()) oldFile.delete();
		
		//신규 파일 저장
		String fileName = UUID.randomUUID().toString().replace("-", "") + "$$" + file.getOriginalFilename();
		File savePath = new File(employeeAttachPath + File.separator + id);
		
		if (!savePath.exists()) {
			savePath.mkdirs();
		}

		file.transferTo(new File(savePath, fileName));
		
		return fileName;
	}
	

	
	@RequestMapping("/deptEmpCount")
	public void deptEmpCount(@RequestParam("dept_no") String deptNum, HttpServletResponse response) throws Exception {

		int count = employeeService.getdeptEmpCount(deptNum);

		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(count);
	}

	@RequestMapping("/checkId")
	@ResponseBody
	public ResponseEntity<Map<String, Boolean>> checkId(String id, HttpServletResponse response) throws Exception {

		ResponseEntity<Map<String, Boolean>> entity = null;
		Map<String, Boolean> result = new HashMap<String, Boolean>();

		try {
			EmployeeVO emp = (EmployeeVO) employeeService.getEmployee(id).get("employee");

			if (emp != null) {
				result.put("result", false);
			} else {
				result.put("result", true);
			}
			entity = new ResponseEntity<Map<String, Boolean>>(result, HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<Map<String, Boolean>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return entity;
	}

	@RequestMapping("/picture/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> sendPicture(@PathVariable("id") String id, HttpServletResponse response)
			throws Exception {

		ResponseEntity<byte[]> entity = null;

		EmployeeVO emp = (EmployeeVO) employeeService.getEmployee(id).get("employee");

		String fileName = emp.getPicture();
		String savePath = employeeAttachPath + File.separator + emp.getId();

		FileInputStream in = null;

		try {
			in = new FileInputStream(savePath + File.separator + fileName);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}

		return entity;
	}

	@RequestMapping("/receiveDoc")
	@ResponseBody
	public ResponseEntity<byte[]> recieveDoc(String fileName, String id) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		HttpHeaders headers = new HttpHeaders();

		String savePath = employeeAttachPath + File.separator + id;
		try {
			in = new FileInputStream(savePath + File.separator + fileName);

			fileName = fileName.substring(fileName.indexOf("$$") + 2);

			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition",
					"attachment;filename=\"" + new String(fileName.getBytes("utf-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (IOException e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			in.close();
		}
		return entity;
	}
	
	
	
	
}
