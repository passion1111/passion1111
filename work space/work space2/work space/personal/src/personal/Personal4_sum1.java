//  백준 알고리즘 더하기 문제

package personal;
import java.util.Scanner;

public class Personal4_sum1 {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			int input=scan.nextInt();
			int input2=scan.nextInt();
			System.out.println(input);
			System.out.println(input2);
			
			if((0<input)&(input2<10))
			{
					System.out.println(input+input2);

}
			else {
				System.out.println("다시 입력해주세요");
			
		}
}
}