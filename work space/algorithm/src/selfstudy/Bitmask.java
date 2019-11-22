package selfstudy;

public class Bitmask {
	
	
	
	public static  void main(String[] args) {
		int[] array= {1,4,6,7};
		int[] array2= {7,10,11,22};
		Bitmask obj=new Bitmask();
		obj.cal(array, array2);
		
		
		
	}
	
	
	
	public int[] cal(int[] array,int[] array2) {
		int[] total= new int[array.length];
//		int[] total= {};
		String[] check=new String[array.length];
		for(int i=0; i<array.length;i++) {
			total[i]=array[i]|array2[i];
			check[i]=	Integer.toBinaryString(array[i]|array2[i]).replaceAll("[0-1]", "#");
			System.out.println("2233");
			System.out.println(total[i]);
			System.out.println(check[i]);
		}
		
		
		
		
		return total;
	}
}
