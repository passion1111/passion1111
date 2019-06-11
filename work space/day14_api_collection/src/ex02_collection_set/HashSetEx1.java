package ex02_collection_set;
//hashset의 경우 초기용량은 16
//iterator를 통해서 하나씩 출력
import java.util.HashSet;
import java.util.Iterator;


//set;순서업속 중복허용x
public class HashSetEx1 {
	public static void main(String[] args) {
	HashSet<String> hs=new HashSet<String>();//뒤에다가는 <String>안해줘도 됨.
	hs.add("ddd");
//	hs.add(1);//정수형 집어넣었기떄문에 에러가 발생.
	hs.add("키보드");	hs.add("ddd");
	hs.add("컵");	hs.add("볼펜");
	
	HashSet<Integer> hs2=new HashSet();//타입 파라메터 적는 순간에는 레퍼클래스 타입만 들어간다. int불가능
	hs2.add(100);
	hs2.add(300);
	hs2.add(1);
	hs2.add(1);
	
	
	System.out.println("요소 개수: "+hs.size());//중복허용되지않는걸 확인할수있음 4 ddd중복되므로.
	
	Iterator it=hs.iterator();
	while(it.hasNext()) {//다음요소가 있다면.
		System.out.println(it.next());//요소를 꺼내옴. 순서보면 순서없이 ddd 컵 볼펜 키보드로 ㅊㄹ력이됨.
	}//while문 말고 for문이용법
	System.out.println("====================");
	for(Object item:hs ) {//for each이용
		System.out.println(item);
	}
	
	System.out.println("====================");
//	for(int i=0;i<hs.size();i++) {
		System.out.println(hs);//배열인데 출력이됨 가변길이배열이니까.
//	}
		System.out.println("====================");
		Iterator it2=hs2.iterator();
		while(it2.hasNext()) {//다음요소가 있다면.
			System.out.println(it2.next());//요소를 꺼내옴. 순서보면 순서없이 ddd 컵 볼펜 키보드로 ㅊㄹ력이됨.
		}
	
	}
}




/*	Object[] obArr = {"1", new Integer(1), "2","3","3", "4","4","4"};
//Hashset<E> <- <E>가 타임 param 파라메터라고 부름. 입력을 제한함.
//만약 E가없다면 출력할떄 형변환을 따로해줘야함.
Set set=new HashSet();

for (int i = 0; i < obArr.length; i++) {
	set.add(obArr[i]); //1,1나오는 이유는 타입이 문자형 정수형 다르기떄문이다.
}
System.out.println(set);
*/