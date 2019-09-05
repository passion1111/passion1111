package com.kosta.board.dao;

import java.util.List;

import com.kosta.board.dto.BDto;

public interface IBDao {
	public List<BDto> list();
	public void write(String bName, String bTitle, String bContent);
	public BDto contentView(String bId);
	public void updateReadCount(String bId);
	public void modify(String bId, String bName, String bTitle, String bContent);
	public void delete(String bId);
	public BDto reply_view(String bId);
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, 	String bIndent);	
	public void replyShape(String bGroup, String bStep);
}
