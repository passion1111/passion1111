package test.test2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TestDao {
public List<HashMap<String, String>> TestList();
public List<HashMap<String, String>> selectprocedure(Map map);
public void insert(@Param("date") String date ,@Param("date2")int date2);	
public List<HashMap<String, String>> callable(Map map);

}
