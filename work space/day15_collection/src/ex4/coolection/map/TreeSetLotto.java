package ex4.coolection.map;
import java.util.*;
class TreeSetLotto{
	public static void main(String[] args) 	{
		Set set = new TreeSet(); //�ڵ��������ִ� Treeset
		for (int i = 0; set.size() < 6 ; i++) {
			int num = (int)(Math.random()*45) + 1; //���� ������ �̾Ƴ�������� for���ȿ� for���� ������.
			set.add(new Integer(num));
		}
	//	List list = new LinkedList(set);	// LinkedList(Collection c)
	//	Collections.sort(list);		// Collections.sort(List list)
		System.out.println(set);
	}
}