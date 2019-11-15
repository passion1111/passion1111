package backjoon;

import java.util.ArrayList;
import java.util.List;

public class Decical {

	public  void Decicalcheck(double d) {
		//num은 입력받은수
		
		//소수판별법 
		boolean isPrime=true;
		for (int i = 2; i <= Math.sqrt(d); i++) {
			if(d%i==0) {	
				//System.out.println("소수가 아니다");
				return;
			}
		}
		System.out.println(d+" 는소수이다");
		
		
	}
	public void TotalDecical(long num) {
		long longDecical=new Long(num+1);
		List list=new ArrayList<Long>();
		// 소수의 곱은 소수가 아님. 
		int i=2;
		for (i=i; i < num; i++) {
			
			Decicalcheck(i);
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		Decical decical=new Decical();
//		decical.Decicalcheck(5);
		decical.TotalDecical(10000000);
		Object check=new Decical();
		//System.out.println(Math.sqrt(3));
		
		
		//공부개념
		//소수가 있을떄 
		//이 소수는 자기자신과 1을 제외하고 소인수분해가 불가능하다(약수가 존재하지않는다) 
		//이떄 소수   루트 소수가 있을떄      만약 소수가 아니라면     공약수들은 루트 소수와 작거나같은 소인수와  큰거나 같은 소인수의 인자 한 쌍을 갖게 된다.
		//근데 만약 루트소수보다 작거나 같은애를 나눴을떄 값이 존재하지않는다면 그 값은 소수이다 왜냐하면 루트소수보다 큰값인 두 수를 곱하면 원래의 값보다 커지게 돼서 모순이 되기떄문이다.
		//이 점을 체에 적용하면  루트보다 작거나 같은 값의 배수들을 제외하면 (소인수분해되는 수들을 제외하면 
		
	}
}
