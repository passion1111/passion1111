//*/
package ex01.For;
//����4] 1~ 100���� �߿��� 3�� ����� �հ� ������ ? 

public class ForEx2 {
	public static void main(String[] args) {
		
		//int sum = 0, count =0;
		int sum, count;
		sum = count = 0;
		
		for(int i=1; i < 101; i++) {
			
			if( i % 3 == 0 ) {
				sum += i; //sum = sum + i;
				count++; //count += 1;  //count = count + 1;
			} // end if
			
		} // end for
		System.out.println("3�� ��� �� : " + sum);
		System.out.println("3�� ��� ���� : " + count);
		
	} // main end
}
//*/

/*
package ex01.For;
// ����3] 1~ 100���� �߿��� ¦�� ����ϰ� ���࿡ 10���� ���

public class ForEx2 {
	public static void main(String[] args) {
		for(int i=1; i < 101; i++) {
			
			if(i % 2 == 0) {
				System.out.print(i + "\t");
			}
			if(i % 20 == 0) {
				System.out.println();
			}
			
		} //end for
		
	}
}
//*/
