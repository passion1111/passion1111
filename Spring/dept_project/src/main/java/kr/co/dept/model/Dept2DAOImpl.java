package kr.co.dept.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dept2DAOImpl implements Dept2DAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Dept2DTO> getDept2List() {
		Dept2DAO dao = sqlSession.getMapper(Dept2DAO.class);
		return dao.getDept2List();
	}

	@Override
	public Dept2DTO getDept2(int dcode) {
		Dept2DAO dao = sqlSession.getMapper(Dept2DAO.class);
		return dao.getDept2(dcode);
	}

	@Override
	public List<Dept2DTO> searchDept2List(Map map) {
		Dept2DAO dao = sqlSession.getMapper(Dept2DAO.class);
		return dao.searchDept2List(map);
	}

	@Override
	public void insertDept2(Dept2DTO dto) {
		Dept2DAO dao = sqlSession.getMapper(Dept2DAO.class);
		dao.insertDept2(dto);
	}

	@Override
	public int deleteDept2(int dcode) {
		Dept2DAO dao = sqlSession.getMapper(Dept2DAO.class);
		return dao.deleteDept2(dcode);
	}
	@Override
	public int multideleteDept2(List deleteTargets) {
		Dept2DAO dao = sqlSession.getMapper(Dept2DAO.class);
		return dao.multideleteDept2(deleteTargets);
	}

	@Override
	public int updateDept2(Dept2DTO dto) {
		Dept2DAO dao = sqlSession.getMapper(Dept2DAO.class);
		return dao.updateDept2(dto);
	}


}
