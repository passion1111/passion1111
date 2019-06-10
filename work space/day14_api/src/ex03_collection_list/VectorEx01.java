package ex03_collection_list;

import java.util.*;

//List : ���� �ְ�, �ߺ�����Ѵ�
public class VectorEx01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		System.out.println("length     /    capacity");
		int len = v.size();
		System.out.println(len +"        /       "+ v.capacity());
		
		Vector<Integer> v2 = new Vector<Integer>(3, 4); //�ʱ�뷮, �����뷮 4������
		v2.add(2);
		v2.add(new Integer(333));
		v2.add(2);
		v2.add(20);
		v2.add(21);
		v2.add(25);
		v2.add(77);
		v2.add(3535);
		
		len = v2.size();  //3
		System.out.println(len +"        /       "+ v2.capacity());
		
		System.out.println("-------------- iterator() method ---------------");
		Iterator it = v2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("-------------- get() method ---------------");
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(v2.get(i));
		}
		System.out.println("----------sort result--------");
		Collections.sort(v2);
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(v2.get(i));
		}
		System.out.println("--------elementsAt() method------");//�ѹ� ��Ʈ�Ǹ� ���߿��� ��Ʈ��.(����)��.
		for (int i = 0; i < v2.size(); i++) {//vector�� �ִ� ��� ��ҿ� ���� �ݺ������� ���ٰ�
			Integer num=v2.elementAt(i);//��� ��ü �˾Ƴ���
			System.out.println(num.toString());
		}
		System.out.println("-------trimtosize() method------");
		System.out.println(v2.size() +"        /       "+ v2.capacity());
		v2.trimToSize();  //����
		System.out.println(v2.size() +"        /       "+ v2.capacity());
		
	}
}











