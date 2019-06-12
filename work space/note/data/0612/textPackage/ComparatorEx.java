package ex02.textPackage;

import java.util.TreeSet;

public class ComparatorEx {
	public static void main(String[] args) {
			TreeSet  set1 = new TreeSet();
			TreeSet  set2 = new TreeSet(new Desending());
			
			int[] scores = { 91, 88, 52, 100, 95, 70, 55, 60, 70 };
			for (int i = 0; i < scores.length; i++) {
				set1.add(new Integer(scores[i]));  // 오름차순
				set2.add(new Integer(scores[i]));  // 내림차순
			}
			
			System.out.println("set1 : " + set1);
			System.out.println("set2 : " + set2);
			
	}
	
	
}
