package day09_MathRandum;
import java.util.Random;
import java.util.Scanner;		
public class Random_quiz {


	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();//��ü����,�޸� �Ҵ�,�������Լ� �ڵ�ȣ��
		int su=rand.nextInt(100)+1;
		int su2;
		for(int i=0;i<5;i++) {
			
			
			do {
				System.out.println((i+1)+"���� ���ڸ� �Է����ּ���");
			su2=sc.nextInt();
			}while(su2>100||su2<0);
			if(su2<su) {System.out.println("up");
			}
			else if(su2>su) System.out.println("down");
			else {System.out.println("�����Դϴ�");
				break;
			}
			}
			
			
			
		}
	
		}
	

