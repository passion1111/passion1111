package ex05_Apiobject;

class Point{
	
}

public class ObjectClass {
	public static void main(String[] args) {
		Point pt=new Point();
		System.out.println("����Ʈ pt ����");
		System.out.println("class name:"+pt.getClass());//�ش�Ŭ������ ��ü�ּҳ���.
		System.out.println("hash code"+pt.hashCode());//��ü�� ������ ��ġ���� 10���������κ�����.													//������ �޸�ü��� 16�����̴�.
		System.out.println("object String:"+pt.toString());//16������ ǥ������. toString�� hashcode�µ���
		System.out.println("object String:"+pt);			//���̴� 10������ �����ֳ� 16������ �����ִ���
		System.out.printf("10���� %d \n", 0x15db9742);
		System.out.println("=============================");
		Point pt2=new Point();//1��2
		System.out.println("����Ʈ pt2 ����");
		System.out.println("class name:"+pt2.getClass());//�ش�Ŭ������ ��ü�ּҳ���.
		System.out.println("hash code"+pt2.hashCode());//��ü�� ������ ��ġ���� 10���������κ�����.													//������ �޸�ü��� 16�����̴�.
		System.out.println("object String:"+pt2.toString());//16������ ǥ������. toString�� hashcode�µ���
		System.out.println("object String:"+pt2);
	
		System.out.println("=============================");
		System.out.println("pt2.tostring() : tostring()�� �ǹ�");
		System.out.println(pt2.getClass().getName()+'@'
				+Integer.toHexString(pt2.hashCode()));
		System.out.println("////////////////////////////////");
		Point pt3=new Point();
	
		if(pt.hashCode()==pt3.hashCode())    System.out.println("����");
		else    	System.out.println("�ٸ���");
		System.out.println("*************************************");
		Point pt4;//�׸��� ���� pt4���̶�� pt�� �־���. ��������򰡿� pt�����Ѱ��� �־�����.
		pt4=pt;//�ᱹ pt�� pt4�� ���� �ּ������� �϶�� �������ذ�.
		if(pt.hashCode()==pt4.hashCode())System.out.println("����");
		else System.out.println("�ٸ���");
	}
	
}
