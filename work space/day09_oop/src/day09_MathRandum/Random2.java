package day09_MathRandum;
import java.util.Random;		
public class Random2 {


	
	
	public static void main(String[] args) {
		Random rand=new Random();//객체생성,메모리 할당,생성자함수 자동호출
		System.out.println(rand.nextInt());// int형 크기안에 있는 임의적인 숫자
		//rand.nextInt(n) <- 0~n-1까지의 숫자 ㅊ출
		System.out.println(rand.nextInt(5));//0~4
		System.out.println(rand.nextInt(5)+1);//1~5할려면 +1
	
		}
	}

