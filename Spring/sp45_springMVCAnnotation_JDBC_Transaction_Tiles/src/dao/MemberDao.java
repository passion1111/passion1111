package dao;

import java.sql.SQLException;
//crtl + sh + O (import 구문 정리)
import vo.Member;

public interface MemberDao {
	public Member getMember(String uid) throws ClassNotFoundException, SQLException;
	public int insert(Member member) throws ClassNotFoundException, SQLException;
	
}
