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

	public static int[] rank(int[] total) { // total값을 받고 높은순서를 배열로 출력하는 메서드

		int[] arrorder1 = new int[total.length];

		for (int i = 0; i < total.length; i++) { // 시작점은 arr[0] 첫번째값부터 비교
			for (int j = 0/* i+1 */; j < total.length; j++) { // 비교값이 행렬의모든값과 비교를해서 높은값이면 비교값의 순위값을 올린다.
				if (total[i] < total[j]) {
					++arrorder1[i];
				}
			}
		} // 배열의 낮은값부터 순서를 정하는 로직

		return arrorder1;
	}

	// 출력메서드 석차출력 방식을 적용했습니다.
	public static void output(String[] name, int[] kor, int[] eng, int[] mat, int[] total, int[] avg, char[] hakjum,
			int[] arrorder) {
		for (int i = 0; i < arrorder.length; i++) {
			for (int j = 0; j < arrorder.length; j++) {
				if (i == arrorder[j]) {/// 0부터 배열의 끝길이까지 비교를해서 0순서에 맞는걸 출력한다. if ((i값(0))=(j(2)값은0)이면 제일 첫번째순서
					// i=1이고 (j(4)값은 1)이면 두번째순서)

//					System.out.println("i="+arr[j]);
					int sukcha = i + 1;

					System.out.println("\n\n석차 : " + sukcha + "등 " + name[j] + "님의 성적표 ");
					System.out.printf("국어 : %d, 영어 : %d, 전산 : %d \n", kor[j], eng[j], mat[j]);
					System.out.printf("총점 : %d, 평균 : %d,학점 : %c\n", total[j], avg[j], hakjum[j]);
					System.out.println("------------------------------------");

				}
			}
		} // 순서대로출력
	}

	public static int saramsu() { // 사람수 정하기

		Scanner scan = new Scanner(System.in);
		System.out.println("사람수 입력하세요  : ");
		return scan.nextInt();
	}

	public static int total(int kor, int eng, int mat) { // 총점구하기
		return kor + eng + mat;
	}

	public static int avg(int total) { // 평균구하기

		return total = total / 3;
	}

	public static char hakjum(int avg) { // 학점 계산 메서드
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

	public static int inputkor() { // 국어 입력메서드
		Scanner scan = new Scanner(System.in);
		System.out.println("국어 점수 : ");
		int kor = scan.nextInt();
		return kor;
	}

	public static int inputeng() {// 영어입력메서드
		Scanner scan = new Scanner(System.in);
		System.out.println("영어 점수 : ");
		int kor = scan.nextInt();
		return kor;
	}

	public static int inputmat() { // 산수입력메서드
		Scanner scan = new Scanner(System.in);
		System.out.println("전산 점수 : ");
		int kor = scan.nextInt();
		return kor;
	}

	public static String inputname() { // 이름 입력메서드
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 : ");
		String kor = scan.nextLine();
		return kor;
	}
}
