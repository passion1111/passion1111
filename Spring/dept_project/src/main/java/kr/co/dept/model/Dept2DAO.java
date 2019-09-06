package kr.co.dept.model;

import java.util.List;
import java.util.Map;

public interface Dept2DAO {

	public List<Dept2DTO> getDept2List();
	
	public Dept2DTO getDept2(int dcode);
	
	public List<Dept2DTO> searchDept2List(Map map);

	public void insertDept2(Dept2DTO dto);

	public int deleteDept2(int dcode);
	
	public int multideleteDept2(List deleteTargets);

	
	public int updateDept2(Dept2DTO dto);

}
