package kosta.mvc.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.web.dto.TransferDTO;

@Repository
public class TransferDAOImpl implements TransferDAO {
	
	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public int withdraw(TransferDTO dto) {
		return sqlSession.update("TransferMapper.withDraw" ,  dto);
	}

	@Override
	public int deposit(TransferDTO dto) {
		return sqlSession.update("TransferMapper.deposit" ,  dto);
	}

}





