package operator;

import java.util.Scanner;

public class Quiz_ex02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է����ּ��� : ");
		String name = sc.nextLine();
		System.out.print("���� ������ �Է����ּ��� : ");
		int kor = sc.nextInt();
		System.out.print("���� ������ �Է����ּ��� : ");
		int eng = sc.nextInt();
		System.out.print("���� ������ �Է����ּ��� : ");
		int com = sc.nextInt();

		int total = kor + eng + com;
//		double avg = total / 3.0;
		double avg = (double)(total / 3);

		System.out.println("\n\n***** " + name + "���� ����ǥ *****");
		System.out.println("���� : " + kor + " ���� : " + eng + " ���� : " + com);
		System.out.printf("���� : %d ��� : %.2f", total, avg);

		sc.close();
	}

}


/*/
package operator;

import java.util.Scanner;

public class Quiz_ex02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("�̸��� �Է����ּ���:");

		String name = sc.nextLine();

		System.out.println("���� ������ �Է����ּ���:");

		int kor = sc.nextInt();

		System.out.println("���� ������ �Է����ּ���:");

		int eng = sc.nextInt();

		System.out.println("���� ������ �Է����ּ���:");

		int jun = sc.nextInt();

		int sum = kor + eng + jun;

		double avg = (kor + eng + jun) / 3.0;

		System.out.printf("\n\n�̸�\t\t����\t����\t����\t����\t���\n");
		System.out.printf("%s\t%3d\t%3d\t%3d\t%3d\t%.2f", name, kor, eng, jun, sum, avg);

	}

}
//*/
