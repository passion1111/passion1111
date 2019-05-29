package personal_array;

public class Array {
	public static void main(String[] args) {
		if(args.length !=1) {
			System.out.println("usage:java morsevonverter word");
			System.exit(0);
			
		}
		System.out.println("sorce:"+args[0]);
		String source=args[0].toUpperCase();
		
		String[] morse= {".-","-...","-.-.","-..",".","..-.","--.","--."};
		String result=" ";
		
		for(int i=0;i<source.length();i++) {
			result+=morse[source.charAt(i)-'A'];
		
		}
		System.out.println("morse:"+result);
	}

}
