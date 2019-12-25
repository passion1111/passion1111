package nullcheck;

public class Nullcheck {

	
	
	public static void main(String[] args) {
		String[] check= null;
		System.out.println(check==null);
		if(check==null) {
			System.out.println(String.valueOf(check));
			check[0]=String.valueOf(check);
			System.out.println(check[0]);
		}
	}
}
