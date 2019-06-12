package ex04.collection.list;
import java.util.*;

public class VectorEx02 {
	public static void main(String[] args) {
		int i;
		Date date = new Date();
		Vector v = new Vector(3, 5);
		
		v.addElement("�ڹ�");  //string
		v.addElement(new Double(10.2)); //double
		v.addElement(date); // object
		
		System.out.println("------- 3�� ��ü �߰� ----------");
		System.out.println("size : " + v.size() + ", capacity : " + v.capacity());
		
		for (i = 0; i<10; i++) {
			v.addElement(new Integer(i));
		}
		
		System.out.println("------- 10�� ��ü �߰� ----------");
		System.out.println("size : " + v.size() + ", capacity : " + v.capacity());
		
		System.out.println("------- Vector ���� ��� ----------");
		Enumeration enu = v.elements();
		
		while(enu.hasMoreElements()) {
			System.out.print(enu.nextElement() + "   ");
		}
		
		System.out.println("------- ��ü ���� ���� Ȯ�� ----------");
		if( v.contains("�ڹ�1")) System.out.println("�ڹ� ���ڿ� ���Ե�");
		else System.out.println("�ڹ� ���ڿ� ���Ծȵ�");
		
		System.out.println("10.2 ��ü ��ġ��? " + v.indexOf(new Double(10.2)));
		System.out.println("�Է� �ð� : " + date);
		System.out.println(v.get(v.indexOf(date)));
		
		//date ��ü ����
		v.removeElementAt(v.lastIndexOf(date));
		System.out.println("******************");
		System.out.println("size : " + v.size() + ", capacity : " + v.capacity());
		System.out.println(v);
		
		for (i = 0; i < v.size(); i++) {
			//v.removeElementAt(i);
			//v.remove(0);
			//v.removeAllElements();
			v.remove(10.2);
			v.remove("�ڹ�");
		}
		
		System.out.println("******************");
		System.out.println("size : " + v.size() + ", capacity : " + v.capacity());
		System.out.println(v);
		
		for(i=0; i< v.size(); i++) {
			System.out.print(v.get(i) + ", ");
		}
		
		System.out.println("+++++++++++++++++");
		v.setElementAt("java", 2); // 3��° ��ġ�� java ���ڿ� �߰�
		
		enu = v.elements();
		while(enu.hasMoreElements()) {
			System.out.print(enu.nextElement() + " , ");
		}
		System.out.println("\n\n");
		v.trimToSize(); //
		System.out.println("size : " + v.size() + ", capacity : " + v.capacity());
		
		v.setSize(2); //ũ�⸦ ������ 2�� ����
		enu = v.elements();
		while(enu.hasMoreElements()) {
			System.out.print(enu.nextElement() + " , ");
		}
		System.out.println();
		v.removeAllElements(); //��� ��� ����
		System.out.println("size : " + v.size() + ", capacity : " + v.capacity());
	}
}




















