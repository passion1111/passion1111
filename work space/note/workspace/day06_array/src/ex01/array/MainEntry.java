package ex01.array;

public class MainEntry {
	public static void main(String[] args) {
		//1.
		char[] ch;	//�迭����
		ch = new char[4];  //�迭����, �޸𸮿� �Ҵ�
		
		//2.
		char[] ch2 = new char[4]; // �迭���� �� ����
		//�迭 �ʱ�ȭ
		ch2[0] ='J';
		ch2[1] ='A';
		ch2[2] ='V';
		ch2[3] ='A';
		
		//3.
		char[] ch3 = {'J', 'A', 'V', 'A','k','b','s','m','b'};
		
		//�迭�� ����(ũ��)
		System.out.println("�迭�� ����(ũ��) : " + ch2.length);
		
		//�迭�� ���� ���
		System.out.println("ch2[2] = " + ch2[2]);
		System.out.println("\n===========");
		
		for(int i=0; i < 4; i++) { //�迭�� ���̸� ���� �־����
			System.out.println("ch2["+ i +"]= " + ch2[i]);
		} // end for
		System.out.println("\n===========");
		
		for(int i=0; i < ch3.length; i++) { //�迭�� ���̸� ���ϴ� �ʵ� lenght �̿���
			System.out.println("ch3["+ i +"]= " + ch3[i]);
		} // end for
		
	}
}







