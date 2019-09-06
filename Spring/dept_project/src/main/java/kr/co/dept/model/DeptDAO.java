package kr.co.dept.model;

import java.util.List;
import java.util.Map;

public interface DeptDAO {

	public List<DeptDTO> getDeptList();

	public DeptDTO getDept(int deptno);

	public List<DeptDTO> searchDeptList(Map map);

	public void insertDept(DeptDTO dto);

	public int deleteDept(int dpetno);

	public int multiDeleteDept(List deleteTargets);

	public int updateDept(DeptDTO dto);

}
