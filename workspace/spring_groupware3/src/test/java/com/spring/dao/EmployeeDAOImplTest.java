package com.spring.dao;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.employee.EmployeeDAO;
import com.spring.dto.EmployeeVO;
import com.spring.request.Criteria;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class EmployeeDAOImplTest {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	@Test
	public void testSelectEmployeeById() throws SQLException{
		String id="mimi";
		EmployeeVO employee=employeeDAO.selectEmployeeById(id);		
		Assert.assertEquals("mimi", employee.getId());
	}

	@Test
	public void testInsertEmployee() throws SQLException{
		EmployeeVO employee=new EmployeeVO();
		employee.setId("abcd1234");
		employee.setPwd("abcd1234");
		employee.setEmail("email");
		employee.setPhone_c("01012341234");
		employee.setPicture("");
		
		employeeDAO.insertEmployee(employee);
		
		EmployeeVO receiveEmployee = employeeDAO.selectEmployeeById(employee.getId());
		
		Assert.assertEquals(employee.getId(),receiveEmployee.getId());
		
	}

	@Test
	public void testUpdateEmployee() throws SQLException{
		EmployeeVO employee = employeeDAO.selectEmployeeById("mimi");
		
		String pwd="abcd1234";
		employee.setPwd(pwd);
		
		employeeDAO.updateEmployee(employee);
		EmployeeVO receive = employeeDAO.selectEmployeeById("mimi");
		
		Assert.assertEquals(pwd, receive.getPwd());
	}

	@Test
	public void testDeleteEmployee() throws SQLException{
		String id="mimi";
		EmployeeVO receiveEmployee = employeeDAO.selectEmployeeById(id);
		if(receiveEmployee != null) {
			employeeDAO.deleteEmployee(id);
			EmployeeVO deletedEmployee = employeeDAO.selectEmployeeById(id);
			Assert.assertNull(deletedEmployee);
		}else {
			System.out.println("mimi 회원은 존재하지 않음.");
		}
				
	}

	@Test
	public void testDisableEmployee() throws SQLException{
		String id="mimi";
		employeeDAO.disableEmployee(id);
		
		EmployeeVO disabledEmployee = employeeDAO.selectEmployeeById(id);
		Assert.assertEquals(0,disabledEmployee.getEnabled());
	}

	@Test
	public void testSelectEmployeeListCriteria() throws SQLException{
		Criteria cri = new Criteria();
		
		List<EmployeeVO> employeeList = employeeDAO.selectEmployeeList(cri);
		
		Assert.assertEquals(cri.getPerPageNum(), employeeList.size());
	}

	@Test
	public void testSelectEmployeeListCount() throws SQLException{
		Criteria cri=new Criteria();
		cri.setSearchType("i");
		cri.setKeyword("mimi");
		
		int count = employeeDAO.selectEmployeeListCount(cri);		
		
		Assert.assertEquals(1, count);
		
	}

}
