
package day03.operator;


	//�ִܻ꽬��������
public class Ex01_Opearator {
	public static void main(String[] args) {
		   					//���������:+,-,*,/,%,^...
		  int x= 10,y=20;  //���������ϸ� �޸��Ҵ����. y�� �ʱ�ȭ�¾������� �޸𸮸� Ȯ��.
		  						 //���߿� �����ϸ� ����������.
		  int gob=x*y;
		System.out.println("x*y= " +gob);  //
		System.out.println("x*y= " +x*y);
		System.out.println(x+"*"+y+"="+(x*y));
		System.out.println("\n\n3+4+*5=" +(3+4*5));
		System.out.println("(3+4)+*5=" +( (3+4)*5 ));
		
		System.out.println("7/3="+ (7/3));//��
		System.out.println("7%3=" + (7%3));//������
		
		//����(+,-,*,/,%,...) ����=����
		
		
		System.out.println("7/3="+ (7/3));
		System.out.println("7/3.0="+ (7/3.0)); //��������.
		System.out.println("7.0/3="+ (7.0/3));
		
	}

}



/*  ����������
package day03.operator;


	//�ִܻ꽬��������
public class Opearator_test {
	public static void main(String[] args) {
		  //�ִ�[] {} ()
		 //���� ������: ����=> ++,--,~(��Ʈ����,ƿ��),...
		int x = 10,y ;
		 
		
		    //y=x++;  //���� ���� :���Ը���,���� ���� x11,y10
		    //y=++x;  //���� ���� :�������,���� ���� x11,y11 
		y=x--;         //���̳ʽ� ������� y10,x9
		                 //�ܵ����� ����ϸ� ���� ���� �������.
		System.out.println("x= "+x+ "\t =" +y);  //
		
	}

}
*/


/* ��Ʈ����
package day03.operator;


	//�ִܻ꽬��������
public class Ex01_Opearator {
	public static void main(String[] args) {
		  
		  int x= -7,y;
		  y=~x;  //��Ʈ���� 0�� ��Ʈ�����ϸ� -1 ,��ȣ����ٲ�� ������ 8��Ʈ¥���� 1�ιٲ�⋚��
		           //��Ʈ����: -(������+1) ��� ���
		System.out.println("x= "+x+ "\t =" +y);  //
		
	}

}
*/
