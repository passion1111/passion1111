package ex02_collection_set;

import java.util.TreeSet;

public class TreesetEx1 {
	public static void main(String[] args) {
		TreeSet set=new TreeSet();
		int[] score= {85,95,50,35,45,65,4,100,65};
		for (int i = 0; i < score.length; i++) {
			set.add(new Integer(score[i]));
		}
		System.out.println(set); //���ı�����. �ߺ�����.
		
		
		System.out.println("50���� ���� ��: "+set.headSet(new Integer(50))); //���� 50�̸�����
		System.out.println("50���� ū ��"+set.tailSet(new Integer(50)));//���� ū�� �׳� �����������ͳ־��.
		ystem.out.println("50���� ū ��"+set.tailSet(50));
	
	}
	
	
}
