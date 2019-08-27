package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao { //컨트롤러역할을함.
	private static long nextId=0;
	private Map<String ,Member>map =new HashMap<>();
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
public void inset(Member member) {
	member.setId(++nextId);
	map.put(member.getEmail(), member);
}
public void update(Member member) {
	map.put(member.getEmail(), member);
}
public Collection<Member> selectAll(){
	return map.values();
}

}
