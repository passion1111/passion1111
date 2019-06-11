package ex2.coolection.list;
import java.util.*;
//iterator 데이터 꺼내놓는 메소드
public class IteratorEx2 {
	public static void main(String[] args) {
		ArrayList original = new ArrayList(10);
		ArrayList copy1 = new ArrayList(10);		
		ArrayList copy2 = new ArrayList(10);		
		
		for(int i=0; i < 10; i++){
			original.add(i+"");
		}
		
		Iterator it = original.iterator();
		
		while(it.hasNext()){
			copy1.add(it.next());//오리지날의 데이터를 copy1에 넣으니 곧 카피하는것을 의미.
		}
		System.out.println("= Original에서 copy1로 복사(copy) =");		
		System.out.println("original:"+original);
		System.out.println("copy1:"+copy1);
		System.out.println();

		it = original.iterator();
		
		while(it.hasNext()){
			copy2.add(it.next());
			it.remove();//오리지널의 데이터를 지움
		}
		
		System.out.println("= Original에서 copy2로 이동(move) =");		
		System.out.println("original:"+original);
		System.out.println("copy2:"+copy2);		
	} // main
} // class