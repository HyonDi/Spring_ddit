package com.jsp.mybatis;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

/**
 * factory를 주는 클래스. 원하는 sqlConfig로.
 * @author PC-16
 *
 */
public class OracleMyBatisSqlSessionFactory implements SqlSessionFactory{
	
	// 생성자 잠그는 역할. >>
	//private OracleMyBatisSqlSessionFactory() {}
	
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
	
	// getSqlsessionfactory 이제 필요 없어서 지운다.
	/*public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}*/
	
	
	// wrapping pattern 이라고 부름.(선생님이. 많이쓰인대.)
	//  껍데기만 바꾸는 작업. factorybuilder 를 factory로.
	
	
	@Override
	public Configuration getConfiguration() {
		return sqlSessionFactory.getConfiguration();
	}

	@Override
	public SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}

	@Override
	public SqlSession openSession(boolean autoCommit) {
		return sqlSessionFactory.openSession(autoCommit);
	}

	@Override
	public SqlSession openSession(Connection conn) {
		return sqlSessionFactory.openSession(conn);
	}

	@Override
	public SqlSession openSession(TransactionIsolationLevel transLevel) {
		return sqlSessionFactory.openSession(transLevel);
	}

	@Override
	public SqlSession openSession(ExecutorType exeType) {
		return sqlSessionFactory.openSession(exeType);
	}

	@Override
	public SqlSession openSession(ExecutorType exeType, boolean autoCommit) {
		return sqlSessionFactory.openSession(exeType,autoCommit);
	}

	@Override
	public SqlSession openSession(ExecutorType exeType, TransactionIsolationLevel transLevel) {
		return sqlSessionFactory.openSession(exeType,transLevel);
	}

	@Override
	public SqlSession openSession(ExecutorType exeType, Connection conn) {
		return sqlSessionFactory.openSession(exeType,conn);
	}
}
