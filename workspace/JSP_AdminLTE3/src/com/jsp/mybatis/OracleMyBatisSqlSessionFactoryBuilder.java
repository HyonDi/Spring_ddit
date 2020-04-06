package com.jsp.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * factory를 주는 클래스. 원하는 sqlConfig로.
 * @author PC-16
 *
 */
public class OracleMyBatisSqlSessionFactoryBuilder {
	
	// 생성자 잠그는 역할. >>
	private OracleMyBatisSqlSessionFactoryBuilder() {}
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		String config = "com/jsp/mybatis/sqlConfig.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(config);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			/*reader.close();*/
			
			System.out.println("sqlSessionFactory 성공했습니다.");
		} catch(Exception e) {
			System.out.println("sqlSessionFactory 실패했습니다.");
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
