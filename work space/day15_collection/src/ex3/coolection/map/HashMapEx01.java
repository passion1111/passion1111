package ex3.coolection.map;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class HashMapEx01 {
	public static void main(String[] args) {
//		Map�� �������̽� Hashmap�� Map�� ��ӹ���.
		Map map=new HashMap();//Ű,����� �ٷ� �����൵��.
//		Hashmap map=new HashMap();//�̰͵�����
		map.put("bit","129");
		map.put("kbs",12345); //������Ÿ������������⋚���� �Ÿ���̵� ����̾���
		map.put("kosta","147");
		map.put("bit2","129");
		
//		System.out.println("��Ұ���:"+map.size()); //Ű �ߺ� �����ϴϱ�.3�� bit,129 2���־ 3��
		System.out.println("��Ұ���:"+map.size());//����� �ߺ��Ǵ��� Ű�� �ߺ����ϴϱ� 4��
	
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("id�� password�� �Է����ּ���.");
			System.out.println("id��");
			String id=sc.nextLine().trim();//trim�� ��������
			System.out.println("password��");
			String pwd=sc.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {//id�� �����ϰ��ִ� Ű���� �ִ��� Ȯ���ϴ� �޼ҵ�
				System.out.println("�Է��Ͻ� id�� ���������ʽ��ϴ�.�ٽ��Է����ּ���");
				continue;
			}else {
				if(!map.get(id).equals(pwd)) {
					System.out.println("��й�ȣ�� ��ġ�����ʽ��ϴ�. �ٽ��Է����ּ���");
				}else {
					System.out.println("id�� pwd�� ��ġ�մϴ�");
					break;
				}//in if end
			}//out if end
		
		
		
		}
	}
}
