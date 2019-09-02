package kr.bit.service;

import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

public class SqlMapClient {

	private static SqlSession session;
	static{
		String resource="sqlMapConfig.xml";
		
		try {
			Reader reader=Resources.getResourceAsReader(resource);
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
			
			session=factory.openSession();//sql객체생성
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession() {
		return session;
	}
	
}
