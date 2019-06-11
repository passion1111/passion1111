package ex1.coolection.set;
import java.util.*;

class TreeSetEx1 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		String from = "a";
		String to	= "b";
		set.add("abc");
		set.add("alien");set.add("bat");
		set.add("car");set.add("Car");
		set.add("disc");set.add("dance");
		set.add("dZZZZ");set.add("dzzzz");
		set.add("elephant");set.add("elevator");
		set.add("fan");set.add("flower");
		System.out.println(set);
		System.out.println("range search : from " + from  +" to "+ to); 
		System.out.println("result1 : " + set.subSet(from, to));//subset은 각각이 가지고있는 포함 ~미포함
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));//마지막 미포함해결하기위해서 넣어줬음
	}
}