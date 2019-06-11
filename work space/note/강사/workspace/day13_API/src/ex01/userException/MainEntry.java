package ex01.userException;

public class MainEntry {

	public void test1(String[] n) throws UserException {
		
		System.out.println("Test1");
		if (n.length < 1)
			throw new UserException("아무것도없다네"); // 강제exception발생
		else
			throw new UserException("최종예선", 703);// 강제exception발생
	}

	public static void main(String[] args) {
		MainEntry ut = new MainEntry();
		try {
			ut.test1(args);
		} catch (UserException e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
