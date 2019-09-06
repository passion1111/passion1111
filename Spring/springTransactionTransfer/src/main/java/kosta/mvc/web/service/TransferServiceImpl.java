package kosta.mvc.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.web.dao.TransferDAO;
import kosta.mvc.web.dto.TransferDTO;
import kosta.mvc.web.exception.MyException;




@Service
@Transactional(propagation=Propagation.REQUIRED , isolation=Isolation.DEFAULT)
public class TransferServiceImpl implements TransferService {
	
	@Autowired
	private TransferDAO transferDAO;

	

	@Override
	public int transfer(TransferDTO dto) {
		
		int re= transferDAO.withdraw(dto);
		int re2=transferDAO.deposit(dto);
		if(re==0 || re2==0) {
			throw new MyException("예외발생해서 계좌이체 실패 했습니다.");
		}
		
		return 0;
	}

}







