package quiz;

import java.util.Scanner;

public class Quiz_ScoreEx5_array {
	//����� ���� �� �Է� �׸� ���� ���� ó����
	static Scanner sc = new Scanner(System.in);
	static int man, subject = 3, tempi;
	static float tempf;
	static String temps;
	static String[] name, grade;
	static int[] kor, eng, com, total, rank;
	static float[] avg;

	public static void arraysize(int x) {
		name = new String[x]; //�迭 ����, �޸𸮿� �Ҵ�
		grade = new String[x];
		kor = new int[x];
		eng = new int[x];
		com = new int[x];
		total = new int[x];
		avg = new float[x];
		rank = new int[x];

	}//arraysize(1) end

	public static void input(int i) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n" + (i + 1) + ".�̸� : ");
		name[i] = sc.nextLine();
		System.out.print("  ���� : ");
		kor[i] = sc.nextInt();
		System.out.print("  ���� : ");
		eng[i] = sc.nextInt();
		System.out.print("  ���� : ");
		com[i] = sc.nextInt();
	} //input(1) end

	public static int tota(int i) {
		return kor[i] + eng[i] + com[i];
	}

	public static float averag(int i) {
		return total[i] * 1.0f / subject;
	}

	public static String grad(int i) {
		String garade = "";
		switch ((int) (avg[i] / 10)) {
		case 10:
		case 9:	garade = "A"; break;
		case 8:	garade = "B"; break;
		case 7:	garade = "C"; break;
		case 6:	garade = "D"; break;
		default: garade = "F";
		}
		
		return garade;
	} // grad(1) end
	
	// ��� - ��Ʈ 
	public static void totalsort() {
		for (int i = 0; i < man; i++) { // ������ ����
			for (int j = 0; j < man - 1; j++) {
				if (total[j] < total[j + 1]) { // ��
					tempi = kor[j];
					kor[j] = kor[j + 1];
					kor[j + 1] = tempi;
					tempi = 0;
					tempi = eng[j];
					eng[j] = eng[j + 1];
					eng[j + 1] = tempi;
					tempi = 0;
					tempi = com[j];
					com[j] = com[j + 1];
					com[j + 1] = tempi;
					tempi = 0;
					tempi = total[j];
					total[j] = total[j + 1];
					total[j + 1] = tempi;
					tempi = 0;
					tempf = avg[j];
					avg[j] = avg[j + 1];
					avg[j + 1] = tempf;
					tempf = 0;
					temps = name[j];
					name[j] = name[j + 1];
					name[j + 1] = temps;
					temps = "";
					temps = grade[j];
					grade[j] = grade[j + 1];
					grade[j + 1] = temps;
					temps = "";
				}
			}
		}
		for (int i = 0; i < man; i++) {
			rank[i] = (i + 1);
		}
	}

	public static void output(int i) {
		System.out.println("\n  ============" + name[i] + "���� ����ǥ=============");
		System.out.printf("  ���� : %d��\n", rank[i]);
		System.out.printf("  ���� : %d\t���� : %d\t���� : %d\n", kor[i], eng[i], com[i]);
		System.out.printf("  ���� : %d\t��� : %.1f\t���� : %s\n", total[i], avg[i], grade[i]);
	}

	public static void main(String[] args) {

		System.out.print("�� ���� ����ǥ�� ����ϰڽ��ϱ�? ");
		man = sc.nextInt();
		arraysize(man);

		for (int i = 0; i < man; i++) { // ���� �Է�
			input(i);
			total[i] = tota(i);
			avg[i] = averag(i);
			grade[i] = grad(i);

			System.out.println();
		} //end for
		
		totalsort();

		for (int i = 0; i < man; i++) {
			output(i);
		}
	}
}