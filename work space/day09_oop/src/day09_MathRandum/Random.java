package day09_MathRandum;
			//�ڵ� ����Ʈ���ش�. java.lang pakage
public class Random {

	

	
	
	
	public static void main(String[] args) {
		System.out.println(Math.abs(-3));// abs static keyword
		//random():���� �߻� 0.0~1.0
		System.out.println(Math.random());
			//0~n-1�� ��� ���ϸ�
		System.out.println(Math.random()*5);
			//1~5   Math����� *���ڷ� �������Ұ����� ���� +���ڷ� �������Ұ����� ����.
		System.out.println((int)(Math.random()*5)+1 );
		
		
		for(int i=0;i<6;i++) {
			System.out.println((int)(Math.random()*45)+1);
		}
	}
}
