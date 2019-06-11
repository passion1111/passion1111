package ex3.coolection.map;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class HashMapEx01 {
	public static void main(String[] args) {
//		Map은 인터페이스 Hashmap은 Map을 상속받음.
		Map map=new HashMap();//키,밸류값 바로 안해줘도됨.
//		Hashmap map=new HashMap();//이것도가능
		map.put("bit","129");
		map.put("kbs",12345); //데이터타입지정안해줬기떄문에 어떤타입이든 상관이없음
		map.put("kosta","147");
		map.put("bit2","129");
		
//		System.out.println("요소개수:"+map.size()); //키 중복 허용안하니까.3개 bit,129 2개있어도 3개
		System.out.println("요소개수:"+map.size());//밸류가 중복되더라도 키는 중복안하니까 4개
	
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("id와 password를 입력해주세요.");
			System.out.println("id는");
			String id=sc.nextLine().trim();//trim은 공백제거
			System.out.println("password는");
			String pwd=sc.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {//id를 포함하고있는 키값이 있는지 확인하는 메소드
				System.out.println("입력하신 id는 조내하지않습니다.다시입력해주세요");
				continue;
			}else {
				if(!map.get(id).equals(pwd)) {
					System.out.println("비밀번호가 일치하지않습니다. 다시입력해주세요");
				}else {
					System.out.println("id와 pwd가 일치합니다");
					break;
				}//in if end
			}//out if end
		
		
		
		}
	}
}
