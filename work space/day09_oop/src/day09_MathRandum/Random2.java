package day09_MathRandum;
import java.util.Random;		
public class Random2 {


	
	
	public static void main(String[] args) {
		Random rand=new Random();//��ü����,�޸� �Ҵ�,�������Լ� �ڵ�ȣ��
		System.out.println(rand.nextInt());// int�� ũ��ȿ� �ִ� �������� ����
		//rand.nextInt(n) <- 0~n-1������ ���� ����
		System.out.println(rand.nextInt(5));//0~4
		System.out.println(rand.nextInt(5)+1);//1~5�ҷ��� +1
	
		}
	}

