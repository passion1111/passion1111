package ex03.For;

public class ForEx6 {
	public static void main(String[] args) {
		
		//������ ��ü ���
		
		for (int i = 1; i <= 9; i++) {  // row - ��

			for (int j = 1; j <= 9; j++) { // col - ��

				System.out.print(j +"*"+i +"=" + (i*j) +"\t");
				//System.out.printf("%d*%d=%2d\t", j, i, (i*j));

			} // end for in

			System.out.println();
		} // end for out
	}
}
