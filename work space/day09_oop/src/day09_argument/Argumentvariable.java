package day09_argument;

public class Argumentvariable {
	public static void plus(int...x) {///�������� �迭
		for(int i=0; i<x.length;i++) {System.out.print(x[i]);
		System.out.println("");}
	}
	
	  public static void main(String[] args) {
		plus(1);
		plus(1,2);
		plus(1,2,3,4,5,6,7,8,9,10);// �޼ҵ�� ����� �Ʒ������� ������ �ʹ�~~����
//		plus("a","b","c"); //�Ʒ� �޼ҵ庸�� ���뽺��
		
	}
}

//	private static void plus(String string, String string2, String string3) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private static void plus(int i) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private static void plus(int i, int j) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private static void plus(int i, int j, int k, int l, int m, int n, int o, int p, int q, int r) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
