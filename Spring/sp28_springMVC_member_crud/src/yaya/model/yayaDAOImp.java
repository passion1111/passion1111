package yaya.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class yayaDAOImp implements yayaDAO {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	
	@Override
	public void update(String id) {

	String sql="update yaya set pwd=?";
	Object[] obj= {id};
	
	jdbctemplate.update(sql,obj);
	
	
	}

	@Override
	public List select() {
		System.out.println("여기는타니?~");
		String sql="select * from yaya";
		
		return jdbctemplate.queryForList(sql);
	}

	@Override
	public void delete(String id) {
		String sql="delete  yaya where id=?";
		Object[] obj= {id};
		
		jdbctemplate.update(sql,obj);

	}
	
	@Override
	public void insert(String id,String pwd) {
		String sql="insert into yaya values(?,?)";
		Object[] obj= {id,pwd};
		
		jdbctemplate.update(sql,obj);

	}

}
