package ex01_basic;

public class Datatype2 {
	
	public static void main(String[] args)  {
		      String str="A";  //���ڿ�, " " ,2byte
		      char ch='A';    //����, ' ' ,1byte
		      char ch2=67;    //ASCII C
		      char ch3='b';   //ASCII 98
		      int  su=20; String aa="happy"; double d=12.34;
		      	System.out.println(ch);  //A
		      	System.out.println(str); //sysout������ ctr+�����̽��ٴ������.
		      								  //A byte����
		      	System.out.println(su);
		      	
		      	System.out.println((int)ch); //ASCII65
		      	System.out.println(ch2= (char) (ch2+1));
		      	System.out.println(ch2+ch3); //�ƽ�Ű���ڷκ��ؼ� ������
		      	System.out.println("aa=" +aa);//���ڿ� ����������������
		      	System.out.println("�Ǽ���������:" +d); //12.34
		      	System.out.println("----------");
		      	for(int i=65; i<=90; i++) {
		      		System.out.println(i);
		      	}
	//end for  \t ��Ű
 				for(int i=65; i<=90; i++) {
 						System.out.print((char)i+ "\t");
  	}  //�ƽ�Ű�� ���ؼ� �������
 				
 				for(int i=65; i<='z'; i++)  {
						System.out.print((char)i+ "\t");
}
 				System.out.println("\n");
 				System.out.println("\n\n\n boolean type");
 				boolean flag=true;
 				//int b=flag �׸��� boolean�� ���ڷ� ����ȯ�ȵ�;
 				System.out.println(flag);
}
}
