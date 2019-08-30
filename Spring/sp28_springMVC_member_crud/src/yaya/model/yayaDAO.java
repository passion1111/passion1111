package yaya.model;

import java.util.List;

public interface yayaDAO {

	public void update(String id);
	public List select();
	public void delete(String id);
	void insert(String id, String pwd);
}
