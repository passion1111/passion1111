package ex04.While;
//�̸� �Է¹ް� ���� 3��(0~100�� �Է� k e c ���� ��� ���ϴ� ���α׷� �ۼ�
//
//
//
import java.util.Scanner;

public class While04 {
	public static void main(String[] args) {
		String name=null;
		
		int k,e,c,sum;
		double avg=0;
		char op=' ';
		System.out.println("name");
		Scanner sc=new Scanner(System.in);
		name=sc.nextLine();
		do {
		System.out.println("K=");
		k=sc.nextInt();
		}while(k<0||k>101);
		do {
		System.out.println("e=");
		e=sc.nextInt();
		}while(e<0||e>101);
		do {
		System.out.println("c=");
		c=sc.nextInt();
	}while(c<0||c>101);
		sum=k+e+c;
		avg=sum/3.;
		System.out.println("����� ������: "+sum+"\n����� �����:"+avg);
		
		//���� ���ϱ�,������,�������� �������ִٸ�.
		do {System.out.println("op(+,-,*,/)=");
			op=sc.next().charAt(0);
	
		
		}while((op!='+')&&(op!='-')&&(op!='*')&&(op!='/'));// +,-,*,/�� ����.
		
	}
	
	}

	
	
	





/*Scanner sc=new Scanner(System.in);
int sum=0,avg,x,y,z;
int k=0,e=0,c=0;



double avg1=0;
System.out.println("����� �̸� �Է� ��� : ");
String name=sc.nextLine();

System.out.println("���� 3���� �Է��ϼ���");
 k=sc.nextInt();
 e=sc.nextInt();	
 c=sc.nextInt();	
do {
	 k=sc.nextInt();		
	System.out.println("��� �Է����ּ���");		
}while(k<0||k>101);   

do {
	 e=sc.nextInt();		
	System.out.println("��� �Է����ּ���");		
}while(e<0||e>101);
do {
	 c=sc.nextInt();		
	System.out.println("������ �Է����ּ���");		
}while(c<0||c>101);    
   sum=k+e+c;
avg1=sum/3.0;

System.out.println(name+"�� ");
System.out.println("����� ������:"+sum+"\n����� �����:"+avg1);
*/