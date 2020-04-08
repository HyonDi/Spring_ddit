package com.hj.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OracleMyBatisSqlSessionFactoryBuilder {

	private OracleMyBatisSqlSessionFactoryBuilder() {}
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		 String config = "com/hj/mybatis/sqlConfig.xml";
		 
		 try {
			 
			 Reader reader = Resources.getResourceAsReader(config);
			 
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			 
			 System.out.println("sqlSessionFactory 성공");
		 
		 } catch(Exception e) {
			 System.out.println("sqlSessionFactory 실패");
			 e.printStackTrace();
		 }
		 
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
