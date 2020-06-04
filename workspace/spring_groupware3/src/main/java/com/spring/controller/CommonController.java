package com.spring.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.DynatreeVO;
import com.spring.dto.EmployeeVO;
import com.spring.dto.MenuVO;
import com.spring.service.employee.DepartmentService;
import com.spring.service.employee.EmployeeService;
import com.spring.service.menu.MenuService;

@Controller
public class CommonController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService deptService;

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String mainGET(Model model, String mCode) throws Exception {

		model.addAttribute("mCode", mCode);
		return "main";
	}

	@RequestMapping("/commons/login")
	public void loginForm() {
	}
	
	@RequestMapping("/commons/loginTimeOut")
	public void loginTimeOut(HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('세션이 만료되었습니다.\\n다시 로그인 하세요!');");
		out.println("location.href='"+request.getContextPath()+"/commons/login';");
		out.println("</script>");
	}
	
	@RequestMapping("/commons/loginExpired")
	public void loginExpired(HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('중복 로그인이 확인되었습니다.\\n다시 로그인하면 다른 장치에서 로그인은 취소됩니다.!');");
		out.println("location.href='"+request.getContextPath()+"/commons/login';");
		out.println("</script>");
	}
	
	/*
	  @RequestMapping(value="/commons/login",method=RequestMethod.POST) public
	  String loginPost(LoginRequest loginReq, HttpSession session,
	  RedirectAttributes rttr) throws SQLException{ String url="redirect:/";
	  
	  String message="";
	  
	  try { employeeService.login(loginReq.getId(), loginReq.getPwd()); EmployeeVO
	  employee=employeeService.getEmployee(loginReq.getId());
	  session.setAttribute("loginUser", employee); message="로그인 하셨습니다."; }
	  catch(IdNotFoundException e) { url="redirect:login";
	  message="존재하지 않는 아이디입니다."; }catch(InvalidPasswordException e) {
	  url="redirect:login"; message="패스워드가 불일치합니다."; }
	  
	  Map<String,String> paramMap = new HashMap<String,String>();
	  paramMap.put("id",loginReq.getId()); paramMap.put("message",message);
	  
	  rttr.addFlashAttribute("paramMap",paramMap);
	  
	  return url; }
	 */

	/*
		@RequestMapping(value="/commons/logout",method=RequestMethod.GET) public
	 	String logout(HttpSession session) { String url="redirect:login";
	 	session.invalidate(); return url; }
	 */

	@RequestMapping(value = "/commons/userInfo", method = RequestMethod.GET)
	public String getUserInfo(String id, Model model) throws Exception {
		String url = "commons/employee_info";
		Map<String, Object> dataMap = employeeService.getEmployee(id);
		EmployeeVO employee = (EmployeeVO) dataMap.get("employee");
		model.addAttribute("employee", employee);
		return url;
	}

	@RequestMapping("/commons/organization_selector")
	public String getOrganizaion(String title) throws Exception {
		String url = "commons/organization";
		return url;
	}

	@RequestMapping("/commons/organization_selector_support_json")
	@ResponseBody
	public List<DynatreeVO> getOragnizationSupport(@RequestParam(value = "dpId") String key) throws Exception {
		List<DynatreeVO> dynaList = deptService.getDynaTree(key);
		return dynaList;
	}

	@RequestMapping("conmons/topMenuHql")
	@ResponseBody
	public ResponseEntity<Map<String, List<MenuVO>>> getMenu(HttpSession session) throws Exception {

		ResponseEntity<Map<String, List<MenuVO>>> result = null;

		EmployeeVO loginUser = (EmployeeVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			result = new ResponseEntity<Map<String, List<MenuVO>>>(HttpStatus.BAD_REQUEST);			
		} else {

			Map<String, List<MenuVO>> menuMap = new HashMap<String, List<MenuVO>>();

			List<MenuVO> menuList = menuService.getTopMenuList();
			menuMap.put("subMenuCode", menuList);
			result = new ResponseEntity<Map<String, List<MenuVO>>>(menuMap, HttpStatus.OK);
		}
		return result;
	}

	@RequestMapping("/conmons/subMenuHql")
	public String getSubMenu(@RequestParam(defaultValue = "MENU00") String mCode,
								Model model) throws Exception {
		String url = "commons/subMenu";
		List<MenuVO> menuList = menuService.getSubMenuList(mCode);
		model.addAttribute("subMenuList", menuList);

		return url;
	}
	
}
