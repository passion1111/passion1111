package quiz;

import java.util.Scanner;

public class Quiz_ScoreEx5_array {
	//사용할 변수 및 입력 그릇 전역 변수 처리함
	static Scanner sc = new Scanner(System.in);
	static int man, subject = 3, tempi;
	static float tempf;
	static String temps;
	static String[] name, grade;
	static int[] kor, eng, com, total, rank;
	static float[] avg;

	public static void arraysize(int x) {
		name = new String[x]; //배열 생성, 메모리에 할당
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
		System.out.print("\n" + (i + 1) + ".이름 : ");
		name[i] = sc.nextLine();
		System.out.print("  국어 : ");
		kor[i] = sc.nextInt();
		System.out.print("  영어 : ");
		eng[i] = sc.nextInt();
		System.out.print("  전산 : ");
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
	
	// 등수 - 소트 
	public static void totalsort() {
		for (int i = 0; i < man; i++) { // 석차순 정렬
			for (int j = 0; j < man - 1; j++) {
				if (total[j] < total[j + 1]) { // 비교
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
		System.out.println("\n  ============" + name[i] + "님의 성적표=============");
		System.out.printf("  석차 : %d등\n", rank[i]);
		System.out.printf("  국어 : %d\t영어 : %d\t전산 : %d\n", kor[i], eng[i], com[i]);
		System.out.printf("  총점 : %d\t평균 : %.1f\t학점 : %s\n", total[i], avg[i], grade[i]);
	}

	public static void main(String[] args) {

		System.out.print("몇 명의 성적표를 출력하겠습니까? ");
		man = sc.nextInt();
		arraysize(man);

		for (int i = 0; i < man; i++) { // 정보 입력
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
