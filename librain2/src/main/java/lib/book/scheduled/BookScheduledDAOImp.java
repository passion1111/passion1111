package lib.book.scheduled;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookScheduledDAOImp implements BookScheduledDAO {
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public void rentservationAutoReturn() {
		sqlsession.getMapper(BookScheduledDAO.class).rentservationAutoReturn();
	}

	@Override
	public void rentStop() {
		sqlsession.getMapper(BookScheduledDAO.class).rentStop();

	}

	@Override
	public void rentAvailable() {
		sqlsession.getMapper(BookScheduledDAO.class).rentAvailable();
	}

}
