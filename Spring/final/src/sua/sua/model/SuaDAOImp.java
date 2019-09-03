package sua.sua.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SuaDAOImp implements SuaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void insert(SuaVO vo) {
		String sql="insert into member33(name,jumin,passwd,id) values(?,?,?,?)";
		Object[] obj= {vo.getName(),vo.getJumin1()+vo.getJumin2(),vo.getPassword(),vo.getId()};
		jdbcTemplate.update(sql,obj);
		
	}




	@Override
	public int numcount() {
		String sql="select count(*) from member33";
		List list= jdbcTemplate.queryForList(sql);
		
		return (int) list.get(0);
	}




	@Override
	public boolean suacheck(String id) {
		String sql="select * from member33 where id=? ";
		Object ojb[]= {id};
		if(jdbcTemplate.queryForList(sql,ojb).size()>0) {
			System.out.println("체크체크");
			return true;
		}
		return false;
	}

}
