package prob2;

import java.util.ArrayList;

public class Prob2 {
	public static void main(String[] args) {
		int num = generateRandom();
		System.out.println("생성된 정수 : " + num);
		if (primeNumber(num)) {
			System.out.println("---> 소수입니다.");
		} else {
			System.out.println("---> 소수가 아닙니다.");
		}
	}

	private static int generateRandom() {
		int num2=(int) (Math.random()*100+1);
		
		return num2;
	}

	private static boolean primeNumber(int num) {
		ArrayList a=new ArrayList();
		for (int i = 1; i <= num; i++) {
				if(num%i==0) {
					a.add(i);
					}
			
}
		if(a.size()==2||num==1) {	
			return true;			
		}
		
		return false;
	}
}