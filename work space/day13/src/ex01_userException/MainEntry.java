package ex01_userException;

public class MainEntry {

	public void test1(String[] n) throws UserException{
		System.out.println("Test1");
		if(n.length< 1)
		throw new UserException("�ƹ��͵����ٳ�"); // ����exception�߻�
		else
		throw new UserException("��������",703);// ����exception�߻�
		}
		public static void main(String[] args) {
		MainEntry main= new MainEntry();
		try{
		main.test1(args);
		}catch(UserException ue){
		 // System.out.println(ue.getMessage());
		ue.printStackTrace();
		}
		}
}
		