package ex4.coolection.map;
import java.util.*;
class TreeSetLotto{
	public static void main(String[] args) 	{
		Set set = new TreeSet(); //자동정렬해주는 Treeset
		for (int i = 0; set.size() < 6 ; i++) {
			int num = (int)(Math.random()*45) + 1; //만약 여러장 뽑아내고싶으면 for문안에 for문을 만들면됨.
			set.add(new Integer(num));
		}
	//	List list = new LinkedList(set);	// LinkedList(Collection c)
	//	Collections.sort(list);		// Collections.sort(List list)
		System.out.println(set);
	}
}