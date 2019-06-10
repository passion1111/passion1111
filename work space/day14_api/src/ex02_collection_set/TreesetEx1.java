package ex02_collection_set;

import java.util.TreeSet;

public class TreesetEx1 {
	public static void main(String[] args) {
		TreeSet set=new TreeSet();
		int[] score= {85,95,50,35,45,65,4,100,65};
		for (int i = 0; i < score.length; i++) {
			set.add(new Integer(score[i]));
		}
		System.out.println(set); //정렬까지함. 중복없이.
		
		
		System.out.println("50보다 작은 값: "+set.headSet(new Integer(50))); //값이 50미만인지
		System.out.println("50보다 큰 값"+set.tailSet(new Integer(50)));//보다 큰지 그냥 정수형데이터넣어도됨.
		ystem.out.println("50보다 큰 값"+set.tailSet(50));
	
	}
	
	
}
