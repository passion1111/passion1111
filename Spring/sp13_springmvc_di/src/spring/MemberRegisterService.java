package spring;

public class MemberRegisterService {
	
	private MemberDao memDao;

	public MemberRegisterService(MemberDao memDao) {
		this.memDao = memDao;
	}
	
	public void register(RegisterRequest req) {
		
	}
}
