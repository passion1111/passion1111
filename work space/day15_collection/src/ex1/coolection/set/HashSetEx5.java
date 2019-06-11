package ex1.coolection.set;
import java.util.*;

class HashSetEx5 {
	public static void main(String args[]) {
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();
//								 앞에있는것을 기준으로 뒤에것을 뺴거나 더하거나 공통된것을확인이 목적.
		setA.add("1");		setA.add("2");
		setA.add("3");		setA.add("4");
		setA.add("5");
		System.out.println("A = "+setA);

		setB.add("4");		setB.add("5");
		setB.add("6");		setB.add("7");
		setB.add("8");
		System.out.println("B = "+setB);

		Iterator it = setB.iterator();  //오브젝트형식으로한이유는 어떤형식이든 받아내기위함.
		while(it.hasNext()) {
			Object tmp = it.next();
			if(setA.contains(tmp))//setA에 포함돼있으면.
				setKyo.add(tmp);// 교집합kyo에 포함
		}

		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp)) //tmp에 없으면 즉 b에없으면
				setCha.add(tmp);//집어넣는다.
		}

		it = setA.iterator();
		while(it.hasNext())
			setHab.add(it.next());

		it = setB.iterator();
		while(it.hasNext())
			setHab.add(it.next());

		System.out.println("A ∩ B = "+setKyo);  // 한글 ㄷ을 누르고 한자키
		System.out.println("A ∪ B = "+setHab); // 한글 ㄷ을 누르고 한자키
		System.out.println("A - B = "+setCha); 
	}
}