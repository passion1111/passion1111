package ex03.For;

public class ForEx6 {
	public static void main(String[] args) {
		
		//구구단 전체 출력
		
		for (int i = 1; i <= 9; i++) {  // row - 행

			for (int j = 1; j <= 9; j++) { // col - 열

				System.out.print(j +"*"+i +"=" + (i*j) +"\t");
				//System.out.printf("%d*%d=%2d\t", j, i, (i*j));

			} // end for in

			System.out.println();
		} // end for out
	}
}
