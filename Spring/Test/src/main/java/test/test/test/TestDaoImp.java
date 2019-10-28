package test.test.test;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImp implements TestDao {

	@Autowired
	SqlSession session;
	@Override
	public void AA() {

		
			session.getMapper(TestDao.class).AA();
	}

}
