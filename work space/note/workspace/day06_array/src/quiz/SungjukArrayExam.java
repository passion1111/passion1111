package quiz;

import java.util.Scanner;

public class SungjukArrayExam {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("�Է��һ�� ���� ���Ͻÿ� : ");
		int saramsu = scan.nextInt();
		
		// �迭 ���� �� ����. �޸𸮿� �Ҵ�
		String namearr[] = new String[saramsu];
		int korscore[] = new int[saramsu];
		int engscore[] = new int[saramsu];
		int matscore[] = new int[saramsu];
		int totalarr[] = new int[saramsu];
		float avgarr[] = new float[saramsu];
		// input 
		for (int i = 0; i < saramsu; i++) {
			System.out.println("�̸��� �Է��ϼ��� : ");
			namearr[i] = scan.next();

			System.out.println("���� ������ �Է��ϼ��� : ");
			korscore[i] = scan.nextInt();

			System.out.println("���� ������ �Է��ϼ��� : ");
			engscore[i] = scan.nextInt();

			System.out.println("���� ������ �Է��ϼ��� : ");
			matscore[i] = scan.nextInt();

			totalarr[i] = korscore[i] + engscore[i] + matscore[i];

			avgarr[i] = totalarr[i] / 3.0f;

		} 
		// output
		for (int i = 0; i < saramsu; i++) {
			System.out.println(namearr[i] + "���� ����ǥ");
			System.out.printf("���� : %d, ���� : %d, ���� : %d \n", korscore[i], engscore[i], matscore[i]);
			System.out.printf("���� : %d, ��� : %.2f\n", totalarr[i], avgarr[i]);
		}

	}
}