package homework;

public class ChangeEx4 {
	public static void main(String[] args) {
		int x =3 , y = 5, temp;
		
		System.out.println(x + ", " + y);
		
		temp = x;  // ��ȯ
		x = y;
		y = temp;  
		
		System.out.println(x + ", " + y);
				
	}
}
