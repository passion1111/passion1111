package ex05_Apiobject;

class Circle{
	int x,y;
	
}

public class EqualsMain {
	public static void main(String[] args) {
		Circle c1=new Circle();
		Circle c2=new Circle();
		
		System.out.println("c1 :"+c1.hashCode());
		System.out.println("c2 :"+c2.hashCode());
		
		
		if(c1==c2)System.out.println("����");
		else System.out.println("�ٸ���");//�ٸ������� �ּ������� �ٸ��⋚��.
		
		int x=3,y=3;
		System.out.println("�⺻ �ڷ��� ��");
		if(x==y)System.out.println("����");//����.
		else System.out.println("�ٸ���");
		
		System.out.println("�����ڷ��� ��");
		String str1=new String("Korea");
		String str2=new String("Korea");
		if(str1==str2)System.out.println("����");
		else System.out.println("�ٸ���");//�ٸ��� 
		
		System.out.println("*******equlas() method ��**********");
		if(str1.equals(str2))System.out.println("����");//eqals.�� �Ȱ��ƾ���.
		else System.out.println("�ٸ���");// equalsignorecase�� ���ڿ��� �Ȱ������
	}
}
