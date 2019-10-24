package test.test2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TestDao {
public List<HashMap<String, String>> TestList();
//public List<HashMap<String, String>> selectprocedure(Map map);
public HashMap<?, ?> selectprocedure(HashMap map);
public List<HashMap<String, String>> test22(List<HashMap<String, String>> ho);

public void insert(@Param("date") String date ,@Param("date2")int date2);	
public List<HashMap<String, String>> callable(Map map);
public int integercheck(int checkvalues);
public void procproc();
}
