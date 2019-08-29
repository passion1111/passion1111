package kr.bit.model;

import java.util.List;

public interface GuestDAO {
	public List listGuest();//select
	public void insertGuest(GuestDTO dto);
	public void deleteGuest(int num);
	public void modifyGuest(GuestDTO dto);
	public List modifySelect(int num);
	
	
}
