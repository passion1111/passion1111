package homework;

//*
import java.util.*;

class HomeWorkEx01 {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int a=0, b=0, c=0;
		int temp=0;
		
		System.out.println("3개의 숫자를 입력하세요.");
		System.out.print("1 >> ");		a = sc.nextInt();
		System.out.print("2 >> ");		b = sc.nextInt();
		System.out.print("3 >> ");		c = sc.nextInt();

		if(a<b){
			temp = b;
			b = a;
			a = temp;
		}
		if(a<c){
			temp = c;
			c = a;
			a = temp;
		}
		if(b<c)
		{
			temp = c;
			c = b;
			b = temp;
		}

		System.out.println("*-*-*-*-*-*-*-*-*-*-*");
		System.out.println(a + " > " + b + " > " + c);
	}
}
//*/

/*
import java.util.*;

class HomeWorkEx01 {
	public static void main(String[] args) 
	{
		System.out.printf("3개의 숫자를 입력하세요:");
		Scanner sc = new Scanner(System.in);//입력그릇 생성
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int min,max,mid;

		if(a>b)	{  //
			max = (a>c) ? a:c;
			min = (b>c) ? c:b;
			mid = (max!=a  && min!=a)? a: (max!=b  && min!=b) ? b:c;
		} else {
			max = (b>c) ? b:c;
			min = (a>c) ? c:a;
			mid = (max!=a  && min!=a)? a: (max!=b  && min!=b) ? b:c;
		}
			    
		System.out.println("\nmax:" + max + "\nmid:" +mid + "\nmin:" +min+"\n");
	}
}
//*/

/*
import java.util.*;

class HomeWorkEx01 {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		System.out.println("첫번째 정수 입력");		int x = sc.nextInt();
		System.out.println("두번째 정수 입력");		int y = sc.nextInt();
		System.out.println("세번째 정수 입력");		int z = sc.nextInt();

		if(x >= y && x >= z) // x가 제일 클때. x y z 
		{
			if(y >= z)	{
				System.out.println(x + " " + y + " " + z);
			} else {
				temp = y;
				y = z;
				z = temp;
				System.out.println(x + " " + y + " " + z);
			}
		} else if(y >= x && y >= z) { //y가 제일클때. y x z
			if(x >= z)	{
				System.out.println(y + " " + x + " " + z);
			} else	{
				temp = x;
				x = z;
				z = temp;

				System.out.println(y + " " + x + " " + z);
			}
		} else if(z >= x && z >= y) { //z가 제일 클때 z x y 

			if(x >= y)	{
				System.out.println(z + " " + x + " " + y);
			} else	{
				temp = x;
				x = y;
				y = temp;

				System.out.println(z + " " + x + " " + y);
			}
		} else
			System.out.println("올바른 숫자 아님.");
	}
}
//*/

/*
import java.util.*;

class HomeWorkEx01 {
	public static void main(String[] args) 
	{
		// 과제 : 3개의 정수를 입력 받아서 크기 순으로 나열
		int x, y, z, MAX, min, cnt;
		Scanner sc = new Scanner(System.in);

		System.out.print("3개의 정수를 입력하세요 : ");
		x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();

		if( x > y ) {
			MAX = x;
			if( y > z ) {
				cnt = y; min = z;
			}
			else {
				MAX = ( x > z ) ? x : z;
				cnt = ( x > z ) ? z : x;
				min = y;
			}
		}

		else {
			MAX = y;
			if( x > z ) {
				cnt = x;
				min = z;
			}
			else {
				MAX = ( y > z ) ? y : z;
				cnt = ( y > z ) ? z : y; min = x;
			}
		}

			System.out.printf("\n ====> %d > %d > %d \n\n", MAX, cnt, min);


	}
}
//*/

/*
import java.util.*;

class HomeWorkEx01 {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");		int x = sc.nextInt();
		System.out.print("숫자 입력 : ");		int y = sc.nextInt();
		System.out.print("숫자 입력 : ");		int z = sc.nextInt();

		int max=0;		int mid=0;		int min=0;

		if ( (x>y)&&(x>z) )
		{
			max = x; 
			if(y>z){
				mid=y;
				min=z;
			} else {
				mid = z;
				min = y;
			}
		}
		else if ((y>z)&&(y>x))
		{
			max = y;
			if(x>z){
				mid = x;
				min = z;
			} else {
				mid = z;
				min = x;
			}
		}
		else if ((z>x)&&(z>y))
		{
				max = z;
			if(x>y){
				mid = x;
				min = y;
			}else {
				mid = y;
				min = x;
			}
		}
		System.out.println( max + " > " + mid + " > " + min );

	}
}
//*/