package a;


	
	import java.util.Scanner;
	 
	public class da02_re24  {
	    static String name;
	    static int[] score = {0, 1, 2};
	    static int total;
	    static double avg;
	    static char grade;
	    
	    public static int[] input() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("이름을 입력하슈 : ");
	        name = sc.nextLine();
	        System.out.println("국어점수를 입력하세요 : ");
	        score[0] = sc.nextInt();
	        System.out.println("영어점수를 입력하세요 : ");
	        score[1] = sc.nextInt();
	        System.out.println("전산점수를 입력하세요 : ");
	        score[2] = sc.nextInt();
	        
	        return score;
	        
	    } // input end
	    
	    public static int total(int[] score) {
	        for(int i = 0; i < 3; i++) {
	            total += score[i];
	        }
	        return total;
	    } // total end
	    
	    public static double avg(int total) {
	        avg = (double)total / 3;
	        return avg;
	    } // avg end
	    
	    public static char grade(double avg) {
	        if(avg > 90) grade = 'A';
	        if(avg > 80) grade = 'B';
	        if(avg > 70) grade = 'C';
	        if(avg > 60) grade = 'D';
	        else grade = 'F';
	        return grade;
	    } // grade end
	    
	    public static void output(String name, int[] score, int total, double avg, char grade) {
	        System.out.println(name+"님의 성적표");
	        System.out.printf("국어 : %d 영어 : %d 전산 : %d\n", score[0], score[1], score[2]);
	        System.out.printf("총점 : %d 평균 : %.2f 학점 : %c", total, avg, grade);
	    } // output end
	    
	    public static void main(String[] args) {
	        
	        input();
	        System.out.println(score);
	        total(score);
	        avg(total);
	        grade(avg);
	        output(name, score, total, avg, grade);
	        
	 
	        
	    } // end main
	} // end class
