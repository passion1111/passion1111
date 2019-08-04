package trade.board.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;


public class TradeBoardDao {
	
	DataSource dataFactory;
	
	public TradeBoardDao() {
		try {
			 Context ctx = new  InitialContext();
			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc:TeamProjectDB");
			System.out.println("팀프로젝 success!!");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}// end �깮�꽦�옄�븿�닔 
	

}
	













