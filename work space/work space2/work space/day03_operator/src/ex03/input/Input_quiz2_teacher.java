package ex03.input;

// ������ �Է¹޾Ƽ� ����ϴ� ���α׷� �ۼ�
//�̸�,����,����,�������� �Է¹޾Ƽ� ����,��ձ��� ����ϴ� ���α׷������
//result
//   �̵������� ����ǥ*****
//   ���� : 100, ����: 100, ����: 100
//   ����: 300 , ���: 100.00
import java.util.Scanner;

public class Input_quiz2_teacher {
	public static void main(String[] args) {
		System.out.println("name=");
		String name= new Scanner(System.in).nextLine();
		int kor,eng,com;
		System.out.println("kor,eng.com score= ");
		kor=new Scanner(System.in).nextInt();
		eng=new Scanner(System.in).nextInt();
		com=new Scanner(System.in).nextInt();


			int total= kor+eng+com;
			float avg=(float) (total/3.0);
		
		System.out.println("****"+name+"���� ����ǥ�Դϴ�.****");
		System.out.println("�̸�:" + name);
		System.out.println("���� :" + kor + "\t����: " + eng + "\t����: " + com);
	


		System.out.printf("����: " + total + "\t���: %.2f", avg);

	}

}
