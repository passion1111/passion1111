package ex03.randomMethod;

public class MathRandom {
	public static void main(String[] args) {
		
		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println();
		//random() : ���� �߻� 0.0 ~ 1.0
		System.out.println(Math.random());
		// 0 ~ n-1 �� ��� ���ϸ� 
		System.out.println(Math.random() * 5); //0 ~ 4
		// 1 ~ 5
		System.out.println((Math.random() * 5) + 1);
		System.out.println();
		for(int i =1; i < 7; i++ ) {
			System.out.print((int)(Math.random() * 45) + 1 +" ");
		}
		
	}
}










