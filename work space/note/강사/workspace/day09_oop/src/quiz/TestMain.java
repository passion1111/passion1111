package quiz;

public class TestMain {
	public static void main(String[] args) {
		int i=1, j=1;   //���� �ʱ�ȭ
		
		do {
			
			j = 1; //���� ������ �ʱ�ȭ�� �־����
			
			do {
				
				System.out.print(j+ " ");
				j++; // ������
			} while( j < 11);  //����
			
			//j = 1;
			
			i++; //������
			System.out.println();
		}while(i < 11);  //����
		
		
	}
}
