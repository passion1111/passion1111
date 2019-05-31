package day09_MathRandum;
import java.util.Random;
import java.util.Scanner;		
public class Random_quiz {


	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();//객체생성,메모리 할당,생성자함수 자동호출
		int su=rand.nextInt(100)+1;
		int su2;
		for(int i=0;i<5;i++) {
			
			
			do {
				System.out.println((i+1)+"번쨰 숫자를 입력해주세요");
			su2=sc.nextInt();
			}while(su2>100||su2<0);
			if(su2<su) {System.out.println("up");
			}
			else if(su2>su) System.out.println("down");
			else {System.out.println("정답입니다");
				break;
			}
			}
			
			
			
		}
	
		}
	

