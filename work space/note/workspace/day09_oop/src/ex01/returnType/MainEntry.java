package ex01.returnType;

public class MainEntry {
	//�Լ� �����
	//1. �Լ� ���Ǻ� �����
	//2. �����Լ����� ȣ���ؼ� �����
	
	public static void main(String[] args) {
		int x = 3, y = 5;
				
		int result = methodEx(x, y);
		System.out.println(result);
		
		int[] arrResult = methodEx2();
		for(int i =0; i < arrResult.length; i++) {
			System.out.print(arrResult[i] + " ");
		}
		
	}

	private static int[] methodEx2() {
		int[] arr = { 1,2,3,4,5,6 };
		
		return arr;  //�������� ������ ������ �迭, ��ü(object)�� �����Ѵ�.
	}

	public static int methodEx(int x, int y) {
		
		return x + y;  //���� ���� ���� 1����, ��, ����, ����
		//return x, y; //�������� �� �� ����
	}

	
	
}










