package method;
//�Ű����� o ����Ÿ�� x
public class Mainentry2 {
	
	public static void plus(int x,int y,String msg) {
		System.out.println("hap ="+(x+y));
		int sum= x+ y;
		System.out.println("sum="+sum);
		System.out.println(msg);
		
	}
		
	
	public static void main(String[] args) {//�������̶� ������ �־�� �Ѵ�.
		System.out.println("main start~~");
		plus(3,5, null);  //�Լ� ȣ��
		plus(3,5,"hi");
		System.out.println("main end");
	}

}
