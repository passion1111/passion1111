package ex03.input;

// ������ �Է¹޾Ƽ� ����ϴ� ���α׷� �ۼ�
//�̸�,����,����,�������� �Է¹޾Ƽ� ����,��ձ��� ����ϴ� ���α׷������
//result
//   �̵������� ����ǥ*****
//   ���� : 100, ����: 100, ����: 100
//   ����: 300 , ���: 100.00
import java.util.Scanner;

public class Input_quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("�̸��� �Է��ϼ���: ");
		String name = sc.next();
		// System.out.println(name);

		System.out.println("���� ������ �Է��ϼ���: ");
		int a = sc.nextInt();
		// System.out.println(a);
		System.out.println("���� ������ �Է��ϼ���: ");
		int b = sc.nextInt();
		// System.out.println(b);
		System.out.println("���� ������ �Է��ϼ���: ");
		int c = sc.nextInt();
		// System.out.println(c); �� Ȯ��
		System.out.println("****"+name+"���� ����ǥ�Դϴ�.****");
		System.out.println("�̸�:" + name);
		System.out.println("���� :" + a + "\t����: " + b + "\t����: " + c);
		int sum = a + b + c;
		float ave = (float) sum / 3;

		System.out.printf("����: " + sum + "\t���: %.2f", ave);

	}

}