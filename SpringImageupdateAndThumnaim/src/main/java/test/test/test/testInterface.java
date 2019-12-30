package test.test.test;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface testInterface {

	public List<HashMap> testList();
	public HashMap test(@Param("idx") int idx);
	public void testInsert(HashMap HashMap);
	public void  testUpdate(HashMap insertdata);
}
