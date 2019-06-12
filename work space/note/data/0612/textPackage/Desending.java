package ex02.textPackage;

import java.util.Comparator;

public class Desending implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if( o1 instanceof Comparable && o2  instanceof Comparable ) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			 return  c1.compareTo(c2) * -1 ; // -1을 곱해서 기본 정렬 방식을 역으로 출력 
			//return  c2.compareTo(c1);  // c1.compareTo(c2)와 같은 상황
		}
		return -1 ;
	}

}
