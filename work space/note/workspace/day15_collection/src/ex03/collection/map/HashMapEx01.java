package ex03.collection.map;
import java.util.*;
//Map : key/value �ѽ����� ó��. ( set + list )
public class HashMapEx01 {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("bit", "129");
		map.put("kbs", 123345);
		map.put("kosta", "147");
		map.put("bitCamp", "129");
		
		System.out.println("��� ���� : " + map.size()); //
		Scanner sc = new Scanner(System.in);
		
		while(true) {  //���ѷ���
			System.out.println("id �� password�� �Է����ּ���. ");
			System.out.print("id : ");
			String id = sc.nextLine().trim();
			System.out.print("password : ");
			String pwd = sc.nextLine().trim();
			System.out.println();
			
			if( !map.containsKey(id) ) {
				System.out.println("�Է��Ͻ� id�� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			} else {
				if( !map.get(id).equals(pwd) ) {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				}else {
					System.out.println("id�� pwd�� ��ġ�մϴ�.");
					break;
				} // in if end
			} // out if end
			
		} //end while
		
	}
}






