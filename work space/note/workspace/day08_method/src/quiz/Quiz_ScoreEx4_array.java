package quiz;

import java.util.Scanner;

public class Quiz_ScoreEx4_array {
	public static void main(String[] args) {

		int saramsu = saramsu();

		String[] name = new String[saramsu];
		int[] kor = new int[saramsu];
		int[] eng = new int[saramsu];
		int[] mat = new int[saramsu];
		int[] total = new int[saramsu];
		int[] avg = new int[saramsu];
		char[] hakjum = new char[saramsu];

		for (int i = 0; i < saramsu; i++) {
			name[i] = inputname();
			kor[i] = inputkor();
			eng[i] = inputeng();
			mat[i] = inputmat();
			total[i] = total(kor[i], eng[i], mat[i]);
			avg[i] = avg(total[i]);
			hakjum[i] = hakjum(avg[i]);
		}//for end

		int[] arrorder = rank(total);

		output(name, kor, eng, mat, total, avg, hakjum, arrorder);
	}

	public static int[] rank(int[] total) { // total���� �ް� ���������� �迭�� ����ϴ� �޼���

		int[] arrorder1 = new int[total.length];

		for (int i = 0; i < total.length; i++) { // �������� arr[0] ù��°������ ��
			for (int j = 0/* i+1 */; j < total.length; j++) { // �񱳰��� ����Ǹ�簪�� �񱳸��ؼ� �������̸� �񱳰��� �������� �ø���.
				if (total[i] < total[j]) {
					++arrorder1[i];
				}
			}
		} // �迭�� ���������� ������ ���ϴ� ����

		return arrorder1;
	}

	// ��¸޼��� ������� ����� �����߽��ϴ�.
	public static void output(String[] name, int[] kor, int[] eng, int[] mat, int[] total, int[] avg, char[] hakjum,
			int[] arrorder) {
		for (int i = 0; i < arrorder.length; i++) {
			for (int j = 0; j < arrorder.length; j++) {
				if (i == arrorder[j]) {/// 0���� �迭�� �����̱��� �񱳸��ؼ� 0������ �´°� ����Ѵ�. if ((i��(0))=(j(2)����0)�̸� ���� ù��°����
					// i=1�̰� (j(4)���� 1)�̸� �ι�°����)

//					System.out.println("i="+arr[j]);
					int sukcha = i + 1;

					System.out.println("\n\n���� : " + sukcha + "�� " + name[j] + "���� ����ǥ ");
					System.out.printf("���� : %d, ���� : %d, ���� : %d \n", kor[j], eng[j], mat[j]);
					System.out.printf("���� : %d, ��� : %d,���� : %c\n", total[j], avg[j], hakjum[j]);
					System.out.println("------------------------------------");

				}
			}
		} // ����������
	}

	public static int saramsu() { // ����� ���ϱ�

		Scanner scan = new Scanner(System.in);
		System.out.println("����� �Է��ϼ���  : ");
		return scan.nextInt();
	}

	public static int total(int kor, int eng, int mat) { // �������ϱ�
		return kor + eng + mat;
	}

	public static int avg(int total) { // ��ձ��ϱ�

		return total = total / 3;
	}

	public static char hakjum(int avg) { // ���� ��� �޼���
		char ch = ' ';
		if (avg > 90)
			ch = 'A';
		else if (avg > 80)
			ch = 'B';
		else if (avg > 70)
			ch = 'C';
		else if (avg > 60)
			ch = 'D';
		else
			ch = 'F';

		return ch;
	}

	public static int inputkor() { // ���� �Է¸޼���
		Scanner scan = new Scanner(System.in);
		System.out.println("���� ���� : ");
		int kor = scan.nextInt();
		return kor;
	}

	public static int inputeng() {// �����Է¸޼���
		Scanner scan = new Scanner(System.in);
		System.out.println("���� ���� : ");
		int kor = scan.nextInt();
		return kor;
	}

	public static int inputmat() { // ����Է¸޼���
		Scanner scan = new Scanner(System.in);
		System.out.println("���� ���� : ");
		int kor = scan.nextInt();
		return kor;
	}

	public static String inputname() { // �̸� �Է¸޼���
		Scanner scan = new Scanner(System.in);
		System.out.println("�̸� : ");
		String kor = scan.nextLine();
		return kor;
	}
}