
//*
package ex02.For_star;

public class ForEx5 {
	public static void main(String[] args) {
		
		//역정삼각형//////////////////////////////////////////
		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= 6-i; j++) { // 출력 ('*')

				System.out.print("*");

			} // end for in

			System.out.println();
		} // end for out
		System.out.println();

		//정삼각형//////////////////////////////////////////
		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= i; j++) { // 출력 ('*')//for (int j = 5; j >= 6 - i ; j--) {

				System.out.print("*");

			} // end for in

			System.out.println();
		} // end for out
		System.out.println();
		
		//정사각형/////////////////////////////
		for (int i = 1; i <= 5; i++) {  // row

			for (int j = 1; j <= 5; j++) { // col

				System.out.print("*");

			} // end for in

			System.out.println();
		} // end for out
	}
}
//*/