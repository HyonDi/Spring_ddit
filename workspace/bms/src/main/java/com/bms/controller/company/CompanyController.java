package com.bms.controller.company;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bms.dto.company.CompanyVO;
import com.bms.request.paging.SearchCriteria;
import com.bms.service.company.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("mobileList")
	public ModelAndView mobileList(SearchCriteria cri, ModelAndView mnv) throws Exception{
		String url = "mobile/companyList";
		
		Map<String, Object> dataMap = companyService.getCompanyAll(cri);
		
		mnv.setViewName(url);
		mnv.addAllObjects(dataMap);
		
		return mnv;
	}
	
	@RequestMapping(value="userinfo", method=RequestMethod.GET)
	public ModelAndView getUserInfo(ModelAndView mnv, String company_charge_name) throws Exception{
		String url = "mobile/company_info";
		
		/*Map<String, Object> dataMap = employeeService.getEmployee(id);
		EmployeeVO employee = (EmployeeVO)dataMap.get("employee");
		model.addAttribute("employee", employee);*/
		
		CompanyVO company = companyService.getCompnyByName(company_charge_name);
		
		System.out.println(company.toString());
		
		mnv.setViewName(url);
		mnv.addObject("company",company);
		
		return mnv;
	}
	
	
}
