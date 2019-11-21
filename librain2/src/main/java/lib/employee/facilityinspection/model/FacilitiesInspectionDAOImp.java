package lib.employee.facilityinspection.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class FacilitiesInspectionDAOImp implements FacilitiesInspectionDAO {
	
	@Autowired
	SqlSession sqlsession;

	@Override
	@Transactional
	public List<FacilitiesInspectionDTO> facinselect() {
		return sqlsession.getMapper(FacilitiesInspectionDAO.class).facinselect();
	}

	@Override
	@Transactional
	public int facintotalcount() {
		return sqlsession.getMapper(FacilitiesInspectionDAO.class).facintotalcount();
	}

	@Override
	@Transactional
	public void facininsertprocedure(FacinVO vo) {
		sqlsession.getMapper(FacilitiesInspectionDAO.class).facininsertprocedure(vo);
		
	}

	@Override
	@Transactional
	public void facinupdateprocedure(FacilitiesInspectionDTO dto) {
		sqlsession.getMapper(FacilitiesInspectionDAO.class).facinupdateprocedure(dto);
		
	}

	@Override
	public void facindelete(FacilitiesInspectionDTO dto) {
		// sqlsession.getMapper(FacilitiesInspectionDAO.class).facinudelete(dto);
		
	}


	

}
