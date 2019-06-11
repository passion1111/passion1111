package ex3.coolection.map;
import java.util.*;
public class HashMapEx02 {
	public static void main(String[] args) {
		HashMap<String, Integer> map=new HashMap<String, Integer>(); 
		map.put("세종", new Integer(90));
		map.put("영학", new Integer(900));
		map.put("수아", new Integer(900));
		map.put("상주", new Integer(9000));
		map.put("소영", new Integer(90000));
		
		Set set=map.entrySet();
		Iterator it=set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e=(Map.Entry)it.next();//오브젝트타입을 Map.entry타입에 넣을려고하니까 오류뜸 형변환필수
			System.out.println("이름"+e.getKey()+",점수:"+e.getValue());//키가 셋타입이기떄문에 순서가 막나옴
		}
		set=map.keySet();
		System.out.println("참가자 명단:"+set);
		Collection values=map.values();
		it=values.iterator();
		
		int total=0;
		while(it.hasNext()) {
			Integer i=(Integer)it.next();
			total+=i.intValue();
		}
		System.out.println("총점 : "+total);
		System.out.println("평점 : "+total/set.size());
		System.out.println("최고점수 : "+Collections.max(values));
		System.out.println("최저점수 : "+Collections.min(values));
		
		
	}
}