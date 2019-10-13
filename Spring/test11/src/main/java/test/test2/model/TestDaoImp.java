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

	@Override
	public List<HashMap<String, String>> selectprocedure(Map map) {
		sqlsession.getMapper(TestDao.class).selectprocedure(map);
		System.out.println(map.get("result"));
		return sqlsession.getMapper(TestDao.class).selectprocedure(map);
	}


}
