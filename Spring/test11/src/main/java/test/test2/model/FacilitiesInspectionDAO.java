package test.test2.model;

import java.util.List;
import java.util.Map;

public interface FacilitiesInspectionDAO {
	public List<FacilitiesInspectionDTO> facinselect();
	public int facintotalcount();
	public void facininsertprocedure(Map map);
}
