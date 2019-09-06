package kosta.mvc.web.service;

import java.util.List;

import kosta.mvc.web.dto.TransferDTO;



public interface TransferService {
	

	/**
	 * 계좌이체하기
	 * */
	int transfer(TransferDTO dto);
}










