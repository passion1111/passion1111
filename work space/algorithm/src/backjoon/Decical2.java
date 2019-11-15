package backjoon;

import java.util.ArrayList;
import java.util.List;

public class Decical2 {

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
	public void TotalDecical(int num) {
		    int[] arr=new int[num+1];
		    int i = 2;
		    // 입력받은 수 만큼 배열에 모두 초기화 해둔다
		    arr[1]=1;
		    for (i = 2; i <= num; i++) {
		        arr[i] = i;
		    }
		    
		    
		
		    for (i = 2; i <= Math.sqrt(num); i++) { 
		        if (arr[i] == 0) // 이미 체크된 수의 배수는 확인하지 않는다
		            continue;
		        for (int j = i + i; j <= num; j += i) { // i를 제외한 i의 배수들은 0으로 체크
		            arr[j] = 0;
		        }
		    }
		    // print
		    for (i = 1; i <= num; i++) {
		        if (arr[i] != 0) {
		        	System.out.println(arr[i]);
		        }
		          
		    }
		}
	
	
	public static void main(String[] args) {
		Decical2 decical=new Decical2();
//		decical.Decicalcheck(5);
		decical.TotalDecical(10000000);

		//System.out.println(Math.sqrt(3));
	}
}
