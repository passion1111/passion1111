//*
package ex03.collection.set;

import java.util.*;

//Set  : 순서 없고, 중복 허용 X
public class HashSetEx1 {
	public static void main(String[] args) {
		//HashSet<String> hs = new HashSet();
		HashSet<String> hs = new HashSet<String>();
		hs.add("키보드");		hs.add("마우스");	hs.add("컵");
		hs.add("볼펜");		hs.add("키보드");
		
		HashSet<Integer> hs2 = new HashSet<Integer>();
		hs2.add(100);
		hs2.add(3);
		hs2.add(1000);
		//hs2.add("string");
		
		System.out.println("요소 개수 : " + hs.size()); //4
		
		Iterator it = hs.iterator();
		while( it.hasNext() ) { //다음 요소가 있다면,...
			System.out.println(it.next()); //요소를 꺼내와서 출력함
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
		while( it2.hasNext() ) { //다음 요소가 있다면,...
			System.out.println(it2.next()); //요소를 꺼내와서 출력함
		}
	}
}
//*/


/*
package ex03.collection.set;

import java.util.HashSet;
import java.util.Set;

//Set  : 순서 없고, 중복 허용 X
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