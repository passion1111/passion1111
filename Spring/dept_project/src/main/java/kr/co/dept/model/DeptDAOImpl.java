package kr.co.dept.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeptDAOImpl implements DeptDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<DeptDTO> getDeptList() {
		DeptDAO dao = sqlSession.getMapper(DeptDAO.class);
		return dao.getDeptList();
	}

	@Override
	public DeptDTO getDept(int deptno) {
		DeptDAO dao = sqlSession.getMapper(DeptDAO.class);
		return dao.getDept(deptno);
	}

	@Override
	public List<DeptDTO> searchDeptList(Map map) {
		DeptDAO dao = sqlSession.getMapper(DeptDAO.class);
		return dao.searchDeptList(map);
	}

	@Override
	public void insertDept(DeptDTO dto) {
		DeptDAO dao = sqlSession.getMapper(DeptDAO.class);
		dao.insertDept(dto);
	}

	@Override
	public int deleteDept(int deptno) {
		DeptDAO dao = sqlSession.getMapper(DeptDAO.class);
		return dao.deleteDept(deptno);
	}
	
	@Override
	public int multiDeleteDept(List deleteTargets){
		DeptDAO dao = sqlSession.getMapper(DeptDAO.class);
		return dao.multiDeleteDept(deleteTargets);
	}

	@Override
	public int updateDept(DeptDTO dto) {
		DeptDAO dao = sqlSession.getMapper(DeptDAO.class);
		return dao.updateDept(dto);
	}

}
