package day09_overroad;
//�����ε�.plus��� �ϳ��� �޼ҵ带 
//���ڰ��� �������������� �ٸ����Ƿ� �������ִ�.
//
public class Mainentry {

			
	
	
	
	public static void main(String[] args) {
		plus(2.2,3.45);
		plus("kbs","tvn");
		plus(100,33.456);
		plus(11.11,345);
		plus(3.4F);//���̻�f�Ǵ� F������ȴ�
		
	}//end main
							//long int
							//double float ���� �浹�������� ������ �ʿ���.
	public static void plus(float x) {
		System.out.println(x);
	}
	
	public static void plus(int x) {
		System.out.println(x);
	}
	public static void plus(int x,int y) {
		System.out.println(x+y);
		
	}
	public static void plus(double x,double y) {
		System.out.println(x+y);
	}
	public static void plus(String x,String y) {
		System.out.println(x+y);
	}
	
	public static void plus(int x,double y) {// 2������ doulbe,int���� �ٸ��� �ν��ؼ� ���������մϴ�.
		System.out.println(x+y);
	}
	
	
	
	
	
	
	
//	public static void iplus(int x,int y) {
//		
//	}
//	public static void dplus(double x,double y) {
//		
//	}
//	public static void splus(String x,String y) {
//		
//	}
//	
//	public static void diplus(int x,double y) {
//		
//	}
//	
//	
	
	
	
	
}//end class
