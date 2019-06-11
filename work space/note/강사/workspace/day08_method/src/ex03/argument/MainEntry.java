//*
package ex03.argument;

public class MainEntry {
	
	public static void main(String[] args) { //매개변수(인수)에 값 전달하기
		
		if( args.length != 0 ) {
			//String result = args[0] + args[1];
//			int su1 = Integer.parseInt(args[0]);
//			int su2 = Integer.parseInt(args[1]);
//			int result = su1 + su2;
			
			//int result = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
			
			double result = Double.parseDouble(args[0]) 
								+ Double.parseDouble(args[1]);
			
			System.out.println(result);
		}else {
			System.out.println("main argument input error!!");
			System.exit(0);
		}
			
			
		
		
	}
}
//*/

/*
package ex03.argument;

public class MainEntry {
	
	public static void main(String[] args) { //매개변수(인수)에 값 전달하기
		
		System.out.println(args[0]);
		String str = args[1];
		System.out.println(str);
		
		for(int i=0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
	}
}
//*/