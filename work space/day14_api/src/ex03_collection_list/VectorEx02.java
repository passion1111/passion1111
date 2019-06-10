package ex03_collection_list;
import java.util.*;
public class VectorEx02 {
	public static void main(String[] args) {
		int i;
		Date date=new Date();
		Vector v=new Vector(3,5);
		
		v.addElement("�ڹ�"); //String 
		v.addElement(new Double(10.2)); //Double
		v.addElement(date); //��ü object
		System.out.println("========3�� ��ü �߰�");
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		
		for (int j = 0; j < 10; j++) {
			v.addElement(new Integer(j));
		}
		System.out.println("------��ü 10�� �߰�-----");
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		
		System.out.println("------Vector ���� ���----");
		Enumeration enu=v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	
		System.out.println("-------��ü ���� ���� Ȯ��");
		if(v.contains("�ڹ�"))System.out.println("�ڹ� ���ڿ� ����");  // contains apiȮ���ϸ� object
//		�ֳ��ϸ� ��� ������Ÿ���� �޾Ƶ��̱� ���� contains�� �Ǻ��� ���� �ַ� ���
		else System.out.println("������");
		
		System.out.println("--------10.2��ü�� ��ġ�� Ȯ��"+v.indexOf(new Double(10.2)));
//		ù������ Ȯ�ε� �׷��Ƿ� 
		System.out.println("�Է� �ð� :"+date);
		System.out.println(v.get(v.indexOf(date)));//��ø���� v�ȿ� �޼ҵ�־ ��ø�ϴ°�.
		
	//	date ��ü ����
//		v.remove() ���� �̸����� ���� ex)v.remove("�ڹ�") <-�ڹٵ��� ����
		v.removeElementAt(v.lastIndexOf(date));//�ڿ������� �����Ұ��� Ȯ��
		System.out.println("*************************");
		System.out.println("size: "+v.size()+", capacity"+v.capacity());//�����Ȱ� Ȯ��.
		System.out.println(v);
		
		for (int j = 0; j < v.size(); j++) {
			v.removeElementAt(j);
		}
//		v.removeAllElements(); //�̰� �� ����°� �̰ž��� ��������
//		v.remove(new Integer(9)); �ڷ����� ��ģ����(��Ʈ��+��Ʈ)���� ������� Ŭ���������� ��������. 
		System.out.println("*************************");
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		System.out.println(v); //�� ���������� 6���� �������� �ֳ��ϸ� �������� �������� �׷���
//		                       remove�� �ص� �Ȱ��� 0���������� 1���� 0�����ΰ�.
//		for (int j = 0; j < v.size(); j++) {
//			System.out.println(v.get(j));
//		}//������ü���Ҵ��� Ȯ��
		
		System.out.println("------------------------");
		v.setElementAt("java", 2);//3���� ��ġ�� java���ڿ� �߰�
		enu=v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		v.trimToSize();
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		
		System.out.println("------------set size----------");
		v.setSize(2);//ũ�⸦ ������ 2�� ����.
		enu=v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		System.out.println("�� �����");
		v.removeAllElements();
		System.out.println(v);

	}
}
