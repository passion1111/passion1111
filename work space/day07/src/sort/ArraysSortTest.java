package sort;

import java.util.Arrays;

//���� ����
public class ArraysSortTest {
	public static void main(String[] args) {
		int[] a = { 7,3,5,2,8 };
		int temp ; 
		System.out.println("******* sort�� ��� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println("\n�������� ���ĵ�");
		Arrays.sort(a);  //���� �˰������� �̹� ���������� ó�����ִ� �޼ҵ�
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		} // for end
		
		System.out.println("\n�������� ���ĵ�");
		// i = a.length-1�� data ������ 5����, �迭�� �ε�����
				// 0���� �����ϱ� ������ 4�� �����ؾ���
		for (int i = a.length-1; i >= 0 ; i--) {
			System.out.print(a[i] + "\t");
		} // for end
		
	}
}

		
		
		
		
		
		
		
		
		