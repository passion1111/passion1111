package test.test2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDaoImp implements TestDao {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<HashMap<String, String>> TestList() {

		return sqlsession.getMapper(TestDao.class).TestList();
	}

//	@Override
//	public List<HashMap<String, String>> selectprocedure(Map map) {
//		sqlsession.getMapper(TestDao.class).selectprocedure(map);
//		System.out.println(map.get("result"));
//		return sqlsession.getMapper(TestDao.class).selectprocedure(map);
//	}
	@Override
	public HashMap<?, ?> selectprocedure(HashMap map) {
		sqlsession.getMapper(TestDao.class).selectprocedure(map);
		System.out.println(map.get("result"));
		return map;
	}

	@Override
	public void insert(String date,int date2) {
		sqlsession.getMapper(TestDao.class).insert(date,date2);
		
		
	}

	@Override
	public List<HashMap<String, String>> callable(Map map) {
		sqlsession.getMapper(TestDao.class).callable(map);
		return (List<HashMap<String, String>>) map.get("result");
	}

	@Override
	public int integercheck(int checkvalues) {
		return sqlsession.getMapper(TestDao.class).integercheck(checkvalues);
	}

	@Override
	public List<HashMap<String, String>> test22() {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(TestDao.class).test22();
	}


}
