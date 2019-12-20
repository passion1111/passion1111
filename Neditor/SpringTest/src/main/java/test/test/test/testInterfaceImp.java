package test.test.test;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testInterfaceImp  implements testInterface{

	@Autowired
	SqlSessionTemplate sqlsession;

	@Override
	public HashMap test(int idx) {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(testInterface.class).test(idx);
	}

	@Override
	public List<HashMap> testList() {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(testInterface.class).testList();
	}

	@Override
	public void testInsert(HashMap CONTENT) {
		
		sqlsession.getMapper(testInterface.class).testInsert(CONTENT);
		
	}

	@Override
	public void testUpdate(HashMap insertdata) {
		sqlsession.getMapper(testInterface.class).testUpdate(insertdata);
		
	}
	
}
