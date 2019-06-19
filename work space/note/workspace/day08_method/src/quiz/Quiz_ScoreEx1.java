package quiz;

import java.util.Scanner;

public class Quiz_ScoreEx1 {
	
	public static String strName = " ";
	public static int nKor = 0;
	public static int nEng = 0;
	public static int nCom = 0;

	public static void main(String[] args) {
		Info_Input();
		Proc();
	}

	public static void Info_Input() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�̸��� �Է� �ϼ���:");
		strName = sc.next();
		System.out.println("0~100������ ������ �Է� �ϼ���");
		do {
			System.out.print("�������� �Է�:");
			nKor = sc.nextInt();
		}while(nKor < 0 || nKor > 100);
		
		
		do {
			System.out.print("�������� �Է�:");
			nEng = sc.nextInt();
		}while(nEng < 0 || nEng > 100);
		
		do {
			System.out.print("�������� �Է�:");
			nCom = sc.nextInt();
		}while(nCom < 0 || nCom > 100);
		
		//Sum(nKor, nEng, nCom);
		
	} //Info_Input() end

	public static int Sum(int nkor, int neng, int ncom) {
		int hap = nkor + neng + ncom;
		return hap;
	}

	public static double Avg(int nSum, int nCnt) {
		return (double) (nSum / nCnt);
	}

	public static void Proc() {
		int nSum = Sum(nKor, nEng, nCom); //����(����ƽ)������ �Ǿ� �־
		double fAvg = Avg(nSum, 3);
		char szGrade = Grade(fAvg);

		System.out.println("\n\n�л��̸� : " + strName);
		System.out.println("Kor : " + nKor + "\tEng : " + nEng + "\tCom : " + nCom);
		System.out.print("[ ���� : " + nSum + " ]" + "[ ��� : " + fAvg + " ]");
		System.out.println("[ ���� : " + szGrade + " ]");
	}

	public static char Grade(double fAvg) {
		switch ((int) fAvg / 10) {
		case 10:
		case 9:
			return 'A';
		case 8:
			return 'B';
		case 7:
			return 'C';
		case 6:
			return 'D';
		default:
			return 'F';
		}
	}
}