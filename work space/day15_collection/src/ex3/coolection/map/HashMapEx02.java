package ex3.coolection.map;
import java.util.*;
public class HashMapEx02 {
	public static void main(String[] args) {
		HashMap<String, Integer> map=new HashMap<String, Integer>(); 
		map.put("����", new Integer(90));
		map.put("����", new Integer(900));
		map.put("����", new Integer(900));
		map.put("����", new Integer(9000));
		map.put("�ҿ�", new Integer(90000));
		
		Set set=map.entrySet();
		Iterator it=set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e=(Map.Entry)it.next();//������ƮŸ���� Map.entryŸ�Կ� ���������ϴϱ� ������ ����ȯ�ʼ�
			System.out.println("�̸�"+e.getKey()+",����:"+e.getValue());//Ű�� ��Ÿ���̱⋚���� ������ ������
		}
		set=map.keySet();
		System.out.println("������ ���:"+set);
		Collection values=map.values();
		it=values.iterator();
		
		int total=0;
		while(it.hasNext()) {
			Integer i=(Integer)it.next();
			total+=i.intValue();
		}
		System.out.println("���� : "+total);
		System.out.println("���� : "+total/set.size());
		System.out.println("�ְ����� : "+Collections.max(values));
		System.out.println("�������� : "+Collections.min(values));
		
		
	}
}