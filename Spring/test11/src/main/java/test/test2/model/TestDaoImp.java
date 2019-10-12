package test.test2.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TestDaoImp implements TestDao {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<HashMap<String, String>> TestList() {

		return sqlsession.getMapper(TestDao.class).TestList();
	}

}
