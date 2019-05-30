package homework;

//*
import java.util.*;

class HomeWorkEx03 
{
	public static void main(String[] args) 
	{

		// 과제 : 연산자(+, -, *, /, %)와 정수 2개 입력 받아 사칙연산

		Scanner sc = new Scanner(System.in);

		try
		{
					int x, y; char sym;
				String str;

				System.out.print("연산자를 입력하세요 ( +, -, *, / ) : ");
				str = sc.next(); sym = str.charAt(0);

				System.out.print("정수 2개를 입력하세요 : ");
				x = sc.nextInt(); y = sc.nextInt();
				if(sym == '+')
					System.out.println("\nresult : " + x + " + " + y + " = " + ( x+y ) + "\n");
				else if(sym == '-')
					System.out.println("\nresult : " + x + " - " + y + " = " + ( x-y ) + "\n");
				else if(sym == '*')
					System.out.println("\nresult : " + x + " * " + y + " = " + ( x*y ) + "\n");
				else if(sym == '/') {
					System.out.println("\nresult : " + x + " / " + y + " = " + ( x/y ) + "\n");
				}
				else
					System.out.println("\nresult : ERROR!\n");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
//*/

/*
import java.util.*;

class HomeWorkEx03 
{
	public static void main(String[] args) 
	{

		// 과제 : 연산자(+, -, *, /)와 정수 2개 입력 받아 사칙연산

		Scanner sc = new Scanner(System.in);

		int x, y; char sym;
		String str;

		System.out.print("연산자를 입력하세요 ( +, -, *, / ) : ");
		str = sc.next(); sym = str.charAt(0);

		System.out.print("정수 2개를 입력하세요 : ");
		x = sc.nextInt(); y = sc.nextInt();

		if(sym == '+')
			System.out.println("\nresult : " + x + " + " + y + " = " + ( x+y ) + "\n");

		else if(sym == '-')
			System.out.println("\nresult : " + x + " - " + y + " = " + ( x-y ) + "\n");

		else if(sym == '*')
			System.out.println("\nresult : " + x + " * " + y + " = " + ( x*y ) + "\n");

		else if(sym == '/') {
			try 	{
				System.out.println("\nresult : " + x + " / " + y + " = " + ( x/y ) + "\n");
			} 
			catch (Exception e)	{
				//e.printStackTrace(); //에러를 단계별로 찾아서 출력
				System.out.println( e.getMessage() );  //제공되는 에러 메세지
				//System.out.println("\nresult : ERROR!\n");  //user message
			}
		}

		else
			System.out.println("\nresult : ERROR!\n");
	}
}
//*/



/*
import java.util.*;

class HomeWorkEx03 
{
	public static void main(String[] args) 
	{

		// 과제 : 연산자(+, -, *, /)와 정수 2개 입력 받아 사칙연산

		Scanner sc = new Scanner(System.in);

		int x, y; char sym;
		String str;

		System.out.print("연산자를 입력하세요 ( +, -, *, / ) : ");
		str = sc.next(); 
		sym = str.charAt(0);

		System.out.print("정수 2개를 입력하세요 : ");
		x = sc.nextInt(); y = sc.nextInt();

		if(sym == '+')
			System.out.println("\nresult : " + x + " + " + y + " = " + ( x+y ) + "\n");

		else if(sym == '-')
			System.out.println("\nresult : " + x + " - " + y + " = " + ( x-y ) + "\n");

		else if(sym == '*')
			System.out.println("\nresult : " + x + " * " + y + " = " + ( x*y ) + "\n");

		else if(sym == '/') {
			if( y == 0 )
				System.out.println("\nresult : ERROR!\n");
			else
				System.out.println("\nresult : " + x + " / " + y + " = " + ( x/y ) + "\n");
		}

		else
			System.out.println("\nresult : ERROR!\n");
	}
}
//*/