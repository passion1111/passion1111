package method;
//�Ű����� o ����Ÿ�� o
public class Mainentry4 {
	
	public static String name(int x,String irum) {
		System.out.println("x="+x);
		return irum;
	
		
	}
		
	
	public static void main(String[] args) {//�������̶� ������ �־�� �Ѵ�.
		System.out.println("main start~~");
		
		String str=name(10,"irurururum");
		System.out.println("name() call= "+name(9999,"girl girl"));
		
		System.out.println(str);
		
		
		System.out.println("main end");
	}

}
