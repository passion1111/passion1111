package com.kosta.Config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryService {
	
	private static SqlSessionFactory sqlsessionfactory;
	
	static{
		String source = "SqlMapConfig.xml";
		try{
			Reader reader = Resources.getResourceAsReader(source);
			sqlsessionfactory= new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlsessionfactory;
	}
}
