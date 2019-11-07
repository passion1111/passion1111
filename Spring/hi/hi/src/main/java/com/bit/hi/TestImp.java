package com.bit.hi;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestImp implements Test {

	
	@Autowired
	SqlSession sqlsession;
	
	
	
	@Override
	public List<HashMap<String, String>> TestAA() {
		
		char ch='A';
		return sqlsession.getMapper(Test.class).TestAA();
	}

}
