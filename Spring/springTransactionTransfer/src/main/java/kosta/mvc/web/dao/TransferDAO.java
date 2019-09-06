package kosta.mvc.web.dao;

import kosta.mvc.web.dto.TransferDTO;


public interface TransferDAO {
	
	/**
	 * 출금하기
	 * */
	int withdraw(TransferDTO dto) ;
	
	/**
	 * 입금하기
	 * */
	int deposit(TransferDTO dto);
	
}












