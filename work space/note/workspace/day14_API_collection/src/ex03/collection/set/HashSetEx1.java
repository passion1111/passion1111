//*
package ex03.collection.set;

import java.util.*;

//Set  : ���� ����, �ߺ� ��� X
public class HashSetEx1 {
	public static void main(String[] args) {
		//HashSet<String> hs = new HashSet();
		HashSet<String> hs = new HashSet<String>();
		hs.add("Ű����");		hs.add("���콺");	hs.add("��");
		hs.add("����");		hs.add("Ű����");
		
		HashSet<Integer> hs2 = new HashSet<Integer>();
		hs2.add(100);
		hs2.add(3);
		hs2.add(1000);
		//hs2.add("string");
		
		System.out.println("��� ���� : " + hs.size()); //4
		
		Iterator it = hs.iterator();
		while( it.hasNext() ) { //���� ��Ұ� �ִٸ�,...
			System.out.println(it.next()); //��Ҹ� �����ͼ� �����
		}
		
		System.out.println("----------------------");
		for(Object item : hs) {
			System.out.println(item);
		}
		
		System.out.println("----------------------");
		//for(int i=0; i < hs.size(); i++) {
			System.out.println(hs);
		//}
			
		Iterator it2 = hs2.iterator();
		while( it2.hasNext() ) { //���� ��Ұ� �ִٸ�,...
			System.out.println(it2.next()); //��Ҹ� �����ͼ� �����
		}
	}
}
//*/


/*
package ex03.collection.set;

import java.util.HashSet;
import java.util.Set;

//Set  : ���� ����, �ߺ� ��� X
public class HashSetEx1 {
	public static void main(String[] args) {
		Object[] obArr = {"1", new Integer(1), "2","3","3", "4","4","4"};
		
		Set set = new HashSet(); //
		
		for (int i = 0; i < obArr.length; i++) {
			set.add(obArr[i]);
		}
		System.out.println(set);
	}
}
//*/