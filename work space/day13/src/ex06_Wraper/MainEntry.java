package ex06_Wraper;

class Point{
	
}

public class MainEntry {
	public static void main(String[] args) {
		
		Integer Ia=new Integer(10);
		Integer Ib=new Integer("10");
		//�⺻�ڷ����� �����ڷ������� �ٲٷ��� ������ �޼ҵ��� ������ �޾Ҿ���ߴ�.
		//������ ���� �׷����ʰ� 
		String su="30";
		Point pt=new Point();
		
		System.out.println(pt);
		System.out.println(pt.toString());
		System.out.println(Ia);
		System.out.println(Ia.getClass().getName()+'@'+Integer.toHexString(Ia.hashCode()));
		//Ŭ������ �ּҰ��ƴ� ���� ���´�.
		int x=77;
		double y=5.5;
		System.out.println(x+","+y);
//		y=x;�� ���������� ����ȯ�� �Ͼ�µ�
		x=(int)y;//�� ���������ȯ�� �ʿ���
		System.out.println(x+","+y);
		
		//Boxing vs Unboxing
		int c=Ia.intValue();//jdk4.x������ ����ϴ� �޼ҵ�. Ŭ������ �ڷ����� �⺻���ڷ������� �����Ѵ�.
		int d=Ib;//jdk 5.x���ĺ��� autoboxing,unboxing�ȴ�.
		int num=Integer.parseInt(su);
		
		System.out.println(c+num);
		System.out.println(c+d);
		System.out.println(Ia.MAX_VALUE);//21��~
		System.out.println(Ia.MIN_VALUE);//-21��~
		
//		Double dd=12.34;
		Double dd=new Double(12.34);
		
		System.out.println(dd.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		
		System.out.println("================================");
		c=(int)dd.doubleValue();
		System.out.println("����ȯ�� c�ǰ���?"+c);
		int e=Integer.parseInt("123");// �̰��� ���ڸ� ���ڷ�.
		int f=Integer.parseInt("111111", 2);//2�����ǰ��� 10���������� ���
		System.out.println(e+20);//�׷��� ���ڰ���̵� e�� 123+�����غ�
		System.out.println(f);
		
		int xx=3;//stack memory;
		Integer yy=new Integer(3); //heap memory
		
		xx=yy.intValue();//jdk 4.0�������� ��ȯ�ϴ� �Լ� ����ؾ�����.
		xx=yy;//autoboxing /unboxing <-- jdk5.0���ĺ���~
	}

}
