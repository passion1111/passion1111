package ex03.collection.map;
import java.util.*;
//Map : key/value 한쌍으로 처리. ( set + list )
public class HashMapEx01 {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("bit", "129");
		map.put("kbs", 123345);
		map.put("kosta", "147");
		map.put("bitCamp", "129");
		
		System.out.println("요소 개수 : " + map.size()); //
		Scanner sc = new Scanner(System.in);
		
		while(true) {  //무한루프
			System.out.println("id 와 password를 입력해주세요. ");
			System.out.print("id : ");
			String id = sc.nextLine().trim();
			System.out.print("password : ");
			String pwd = sc.nextLine().trim();
			System.out.println();
			
			if( !map.containsKey(id) ) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			} else {
				if( !map.get(id).equals(pwd) ) {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				}else {
					System.out.println("id와 pwd가 일치합니다.");
					break;
				} // in if end
			} // out if end
			
		} //end while
		
	}
}






