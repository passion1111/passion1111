package quiz;

import java.util.Scanner;

public class Quiz_ScoreEx2 {
	
	public static void main(String[] args) {
		System.out.println("=========���� ó�� ���α׷�=========\n");
		input();
	}

	public static void input() {
		Scanner s = new Scanner(System.in);
		int kor, eng, math;
		String name = null;
		
		while (true) {
			System.out.println("\n###########[���� �Է�]###########\n");
			System.out.print("##[�л� �̸�] : ");
			name = s.next();
			System.out.print("##[���� ����] : ");
			kor = s.nextInt();
			System.out.print("##[���� ����] : ");
			eng = s.nextInt();
			System.out.print("##[���� ����] : ");
			math = s.nextInt();
			if (kor < 0 || kor > 100 || eng < 0 || eng > 100 || math < 0 || math > 100) {
				System.out.println("\n##Error!! ������ ����� �Է��ϼ��� (0 ~ 100)\n");
				continue;
			} else
				break;
		} //while end
		
		process(name, kor, eng, math);
	} //input() end

	public static void process(String name, int kor, int eng, int math) {
		
		int sum = kor + eng + math;
		double avg = sum /  3.0;
		//double avg = (kor + eng + math) / (double) 3;
		
		System.out.println("\n#############[�� ��]#############\n");
		System.out.println("[�� ��] : " + name);
		System.out.println("kor : " + kor + "\teng : "+eng + "\tmath : " + math);
		System.out.print("[�� ��] : " + sum);
		System.out.printf("[�� ��] : %.2f  ", avg);

		grade(avg);
	} // process(n, k, e,m) end

	public static void grade(double avg) {
		char grade = ' ';

		if (avg <= 100 && avg > 90) {
			grade = 'A';
		} else if (avg <= 90 && avg > 80) {
			grade = 'B';
		} else if (avg <= 80 && avg > 70) {
			grade = 'C';
		} else if (avg <= 70 && avg > 60) {
			grade = 'D';
		} else
			grade = 'F';
		System.out.println("[�� ��] : " + grade);
	}
}