package ex03.array;

public class ForeachTest {
	public static void main(String[] args) {
		int[] a = {1, 2, 5, 6,7,90,100};
		System.out.println("���� ���� ���");
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i] + " ");
			if( i == 3 ) break;
		}
		System.out.println("\n==============");
		
		//for(�ڷ��� ������ : �迭�� �Ǵ� �÷��Ǹ�) { �ݺ����๮; }
		for(int item : a ) {
			System.out.print(item + " ");
		}
		
		System.out.println("\n�������� ���");
		for(int i= a.length-1 ; i >= 0 ; i--) {
			System.out.print(a[i] + " ");
		}
		
	}
}





