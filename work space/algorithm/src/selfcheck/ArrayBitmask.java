package selfcheck;

public class ArrayBitmask {
	
	public static void main(String[] args) {
		int[] i= {1,0,1,0};
		int[] j= {1,1,0,0};
		int[] total=new int[4];
		for (int j2 = 0; j2 < j.length; j2++) {
			total[j2]=i[j2]& j[j2];
			System.out.println(  total[j2] );
			
		}
		
		
		Object abc=new Integer(3);
		System.out.println(abc);
		ArrayBitmask a=new ArrayBitmask();
		a.Object(abc);
		System.out.println(abc);
		
		
	}
	public  void Object(Object o) {
		o=new Integer(5);
	}
}
