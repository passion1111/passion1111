package ex06_constructor;
//default constructor /API �����.
public class MainEntry {
	/** 
	 * 
	 *
	 * @param args ������ �ƹ����� �Ѱܹ����ʽ��ϴ�.
	 * @param x���� ���ϴ°Ϳ� ù���� ������ ����
	 * @param y���� ���ϴ°Ϳ� �ι��� ������ ����
	 * @param gob ������ x�� y �� ������ ���� �����ϴ� ����
	*/  //<--/**   */  <- doc�ּ� @param <-- annotation ������̼�
	
	
	public static void main(String[] args) {
		int x,y,gob=1;
		char ch='A';
		String msg;
		
		x=5; y=10;
		msg="th129 Hello~~";
		gob=gob(x,y);
		System.out.println(ch);
		System.out.println(msg);
		System.out.println(x+"*"+y+"="+gob);
	}

	private static int gob(int x, int y) {
		
		return x*y;
	}
}

