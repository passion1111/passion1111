package kr.bit.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class GuestDAOImp implements GuestDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate; //DML-selet,insert,update,delete
	


	@Override
	public List listGuest() {
		String sql="select *from guestbook order by num desc";
		
		//select 제외하고는 다 .update
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public void insertGuest(GuestDTO dto) {
		String sql="insert into guestbook(num,name,email,home,contents) values(?,?,?,?,?)";
		//여러개 넣어야할떄는 배열로 처리해줘야함.
		Object[]  arr= {dto.getNum(),dto.getName(),dto.getEmail(),dto.getHome(),dto.getContents()};
		
		
		jdbcTemplate.update(sql, arr);
	}

	@Override
	public void deleteGuest(int num) {
		String sql="delete guestbook where num=?";
		Object[] arr= {num};
		jdbcTemplate.update(sql,arr);
		
	}


	@Override
	public void modifyGuest(GuestDTO dto) {
		String sql="update  guestbook  set name =? ,email=?,home=? ,contents=? where num=?";
		Object[] arr= {dto.getName(),dto.getEmail(),dto.getHome(),dto.getContents(),dto.getNum()};
		
		jdbcTemplate.update(sql, arr);
	}

	@Override
	public List modifySelect(int num) {
		String sql="select * from guestbook where num=?";
		Object[] arr= {num};
		
		return jdbcTemplate.queryForList(sql, arr);
		
	}

	
	
}
