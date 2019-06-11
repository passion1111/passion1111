package ex03_collection_list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListex03 {
	public static void main(String[] args) {
		ArrayList list=new ArrayList(10);
		list.add(new Integer(5));
		list.add(new Integer(4));
		list.add(new Integer(0));
		list.add(new Integer(2));
		list.add(new Integer(55));
		list.add(new Integer(1));
		list.add(new Integer(3));
		
		ArrayList list2=new ArrayList(list.subList(1, 4));//1������ 3������ 
		print(list,list2);
		Collections.sort(list);
		Collections.sort(list2);
		print(list,list2);
		
		System.out.println("list.containsAll(list2): "+list.containsAll(list2));
		//���� �����ϳ�
		list2.add("B");
		list2.add("C");
		list2.add(3,"A");//�ε�����ġ,������
		print(list,list2);
	
		
		System.out.println("list.containsAll(list2): "+list.retainAll(list2));
		print(list,list2); //retain ������.
		for (int i = list2.size()-1; 0<=i;i--) {
			list2.remove(i);
			
		}
		print(list,list2);
	}

	private static void print(ArrayList list, ArrayList list2) {
		System.out.println("list"+list);
		System.out.println("list2"+list2);
	}
}
