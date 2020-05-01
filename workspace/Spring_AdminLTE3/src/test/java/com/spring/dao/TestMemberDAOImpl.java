package com.spring.dao;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class TestMemberDAOImpl {
// @TransactionConfiguration(transactionManager="transactionManager") : 트렌젝션매니저 어떤거쓸건지에대함.
// @Transactional : 트랜젝션 쓸것이다.!
// 이 두개 달기만하면 전부 롤백 됩니다.- 테스트결과를 실제 db에 반영하지 않기위함.
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void testElectMember() throws SQLException{
		String id = "mimi";
		MemberVO member = memberDAO.selectMemberById(id);
		Assert.assertEquals(id, member.getId());
	}
	
	@Test
	public void testInsertMember() throws SQLException{
		MemberVO member = new MemberVO();
		member.setId("kaka");
		member.setPwd("kaka");
		member.setName("kaka");
		member.setEmail("kaka@kak.net");
		member.setPhone("010123241234");
		member.setPicture("noImage.jpg");
		
		memberDAO.insertMember(member);
		
		MemberVO result = memberDAO.selectMemberById("kaka");
		Assert.assertEquals(member.getId(), result.getId());
		
	}

}
