package ex04.While;

// ������ ���� ��� ���α׷� (do~while �̿�)
public class DoWhileEx7 {
	public static void main(String[] args) {
		
		int i=1, j=1;  //�ʱ�ȭ
		
		do {
			
			j = 1;  //while or do~while���� ���ʺ����� �ʱ�ȭ�� �־���Ѵ�
			do {
				
				System.out.print(j +"*"+i +"=" + (i*j) +"\t");
				j++; //������
			} while(j < 10); // end j - ����
			
			i++; //
			System.out.println();
			
		}while(i < 10); // end i - ����
		
	}
}




