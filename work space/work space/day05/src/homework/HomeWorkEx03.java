package homework;

//*
import java.util.*;

class HomeWorkEx03 
{
	public static void main(String[] args) 
	{

		// ���� : ������(+, -, *, /, %)�� ���� 2�� �Է� �޾� ��Ģ����

		Scanner sc = new Scanner(System.in);

		try
		{
					int x, y; char sym;
				String str;

				System.out.print("�����ڸ� �Է��ϼ��� ( +, -, *, / ) : ");
				str = sc.next(); sym = str.charAt(0);

				System.out.print("���� 2���� �Է��ϼ��� : ");
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

		// ���� : ������(+, -, *, /)�� ���� 2�� �Է� �޾� ��Ģ����

		Scanner sc = new Scanner(System.in);

		int x, y; char sym;
		String str;

		System.out.print("�����ڸ� �Է��ϼ��� ( +, -, *, / ) : ");
		str = sc.next(); sym = str.charAt(0);

		System.out.print("���� 2���� �Է��ϼ��� : ");
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
				//e.printStackTrace(); //������ �ܰ躰�� ã�Ƽ� ���
				System.out.println( e.getMessage() );  //�����Ǵ� ���� �޼���
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

		// ���� : ������(+, -, *, /)�� ���� 2�� �Է� �޾� ��Ģ����

		Scanner sc = new Scanner(System.in);

		int x, y; char sym;
		String str;

		System.out.print("�����ڸ� �Է��ϼ��� ( +, -, *, / ) : ");
		str = sc.next(); 
		sym = str.charAt(0);

		System.out.print("���� 2���� �Է��ϼ��� : ");
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