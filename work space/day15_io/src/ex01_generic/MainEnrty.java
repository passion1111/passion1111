package ex01_generic;

public class MainEnrty {
	public static void main(String[] args) {
		GenericEx01<String> t1=new GenericEx01<String>();
		String[] str= {"dd","abc","bbs"};
		t1.set(str); t1.print();
		System.out.println("========================");
		
		GenericEx01<Integer> t2=new GenericEx01<Integer>();
		Integer[] num= {1,2,3,4,5};
		t2.set(num); t2.print();
		
		System.out.println("========================");
		
		GenericEx01<Double> t3=new GenericEx01<Double>();
		Double[] dou= {1.334,332.32};
		t3.set(dou); t3.print();
	}
}
