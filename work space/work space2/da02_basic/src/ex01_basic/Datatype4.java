package ex01_basic;

public class Datatype4 {
	public static void main(String[] args) 
		
	 {
		int su=10;
			System.out.println("10����: "+su); //%d 10����,%o 8����,%x  16����,%X
			System.out.printf("10����: %d \n" ,su);
			System.out.printf("8����: %o \n" ,su);
			System.out.printf("16���� %x, %X \n" , su , su); //x,X���̴� abcdef���� �ҹ��� �빮������
			System.out.printf("%d %x %o %X  \n",10,10,10,10);
			System.out.printf("%.2f  \n",32.132);
			
			
			
			System.out.printf("%d \n" ,012); //012(8����) ->10���� 10 ���
			System.out.printf("%d \n", 0xA); //0xA(16����)->10���� 10 ���
			
			double f= 12.34;
			System.out.println(f);
			/*float ff=5.6;
			System.out.println(ff);*/ //���Կ����� �ڿ��ִ°��� ������ �ѱ� �׷��� 5.6���ڸ���
			//��Ȯ���� ���� double������ �������ع����� ������ ������.�ذ��ҷ��� f�� �������.
	}
         //0���� -> 8���� ,0x���̸� 16����
			
}