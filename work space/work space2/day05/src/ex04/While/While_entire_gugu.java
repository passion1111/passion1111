package ex04.While;
//구구단 전체찍기
public class While_entire_gugu {
             public static void main(String[] args) {
				int i,j;
				i=2;
				j=1;

		do {
					do {System.out.print(i + "*" + j + "=" + (i * j) + "\t");
						j++;			
					} while (j <= 9);
		System.out.println("");
		i++;
		j = 1;
	 } while (i <= 9);
	}
}
