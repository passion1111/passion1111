package selfstudy;

public class ReversString {

	public static void main(String[] args) {
		String  revers="adasdqrq";
		char[]  reversTochar=revers.toCharArray();
		//String buffer 기본기능으로 구현 
		System.out.println(new StringBuffer(revers).reverse().toString());
	
		char[] tempchar=reversTochar;
		StringBuffer temp=new StringBuffer();
		int tempcount=0;
		for (int i=reversTochar.length-1 ; i >= 0; i--) {
			temp.append(reversTochar[i]);
			reversTochar[i]=tempchar[tempcount];
			
			System.out.println(tempchar[tempcount]);
			tempcount++;
		}
	
	System.out.println(temp.toString());
	System.out.println(new String(reversTochar));
	}
	
}
