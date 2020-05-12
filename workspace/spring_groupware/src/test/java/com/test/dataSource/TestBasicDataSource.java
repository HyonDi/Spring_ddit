package com.test.dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


// 테스트클래스라는것을알리기위한 어노테이션.
@RunWith(SpringJUnit4ClassRunner.class)
// 루트컨텍스트를 읽어서 스프링컨테이너를 만들어주는 아이.
@ContextConfiguration("classpath:/com/groupware/context/root-context.xml")
public class TestBasicDataSource {
	// new junit 해도되지만 Spring테스트는 못한다. java테스트만가능.
	// 그래서일반클래스 테스트할파일 BasicDataSource에 Test를 붙인다. 
	//BasicDataSource이게 어딨는건데??:org.apache.commons.dbcp2.BasicDataSource 여기에있음.
	
	// 어노테이션 붙여서 껍데기는 스프링 . 안에는 junit 이라는의미. 껍데기는 context라고??
	// 우리가테스트하려는것 : 컨테이너안의 인스턴스 테스트. (잘 사용중인지)
	// 원래 junit은 해당클래스의 메서드테스트하는것이다.(잘 만들었는지)
	
	// 자동묶기.타입으로불러낸다.
	/*<bean id="dataSource"
			class="org.apache.commons.dbcp2.BasicDataSource"
		여기속에있는 class가 타입이야.(rootContext.xml)*/
	// resouces 쓰면 id로 불러낼수도있구 다른것도 있지만 spring은 autowired가 잘 맞는다.
	@Autowired
	private BasicDataSource dataSource;
	
	//@Autowired // 여기에쓰면 파라미터타입보고 잡아넣고 위에 변수에쓰면 변수타입보고 잡아넣는다. 현재는 어디에쓰던 똑같다.
	/// 그리고지금은 set메서드필요없음.
	//public void setDataSource(BasicDataSource dataSource) {}
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 어노테이션 Befor : 테스트할때마다 해야하는 무언가.
	// 테스트메서드가 실행될 때 마다 한 번씩 실행된다.
	@Before
	public void init() throws SQLException{
		conn=dataSource.getConnection();
	}
	
	// 테스트할 메에서드 테스트어노테이션안붙이면 실행하지않음. jvm말고 junit으로실행한다. 결과는 success/fail/error 로나옴(메서드명마다) => 결과만들어내는애 = assert
	// 따라서 test어노테이션이랑 assert랑 세트임.
	

	@Test
	public void testConnection() throws SQLException{
		Connection conn = this.conn;
		
		Assert.assertNotEquals(null, conn);
		// 해석 : 커넥션이 null이아닐것이라 기대한다.(기대예상치,타겟)
	}
	
	// 메서드만들때 해야할일 : public, void, throws, 메서드명만보고도 뭔지 알 수있게 정하기.
	// 테스트시 : 시나리오, 테스트실행(변인통제), 결과분석. => 재설계
	
	
	/*@Test
	public void testSqlInjection() throws SQLException{
		final String id="mimi";
		
		String sql="select * from member where id='" + id + "'";
		
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(sql);
		
		MemberVO member = null;
		if(rs.next()) {
			member = new MemberVO();
			member.setId(rs.getString("id"));
		}
		
		Assert.assertEquals(id, member.getId());
		// 리터럴스트링 바로넣으면 위험할수있으니 변수로! 변수에 final
	}*/
	
	@After
	public void end() throws SQLException{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}

}
