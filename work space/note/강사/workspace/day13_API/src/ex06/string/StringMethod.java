package ex06.string;

public class StringMethod {
	public static void main(String[] args) {
		String s1 = "happydoyeon";
		String s2 = "SEOUL";
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s2.hashCode()); //78786452
		System.out.println(s2.replace("EO", "korea")); //SkoreaUL
		System.out.println(s2.hashCode()); //78786452
		System.out.println(s2);
		s2 = s2.replace("EO", "korea");
		System.out.println(s2.hashCode());  //-1910762226
		System.out.println(s2);
		System.out.println("=========================");
		//s1 = s1.concat(s2);  //문자열 결합
		s1 = s1 + s2;  
		System.out.println(s1); //happydoyeonSkoreaUL
		
		System.out.println("=========================");
		String s3 = new String("    ab     cd     ");
		System.out.println(s3);
		System.out.println(s3.length()); //문자열 길이 - 18
		s3 = s3.trim(); //공백제거
		System.out.println(s3.length());  // 9
		System.out.println(s3);
		System.out.println("=========================");
		
		String s4 = new String("ab/defgh/3485294/kwierw/213714");
		//String s4 = new String("ab defgh 3485294 kwierw 213714");
		//String[] s5 = s4.split(" ");  // 공백이 구분자 역할
		String[] s5 = s4.split("/");
		for (int i = 0; i < s5.length; i++) {
			System.out.println("분리된 " + i + "번 문자열 : " + s5[i]);
		} //for end
		
		System.out.println("=========================");
		String s6 = "123-4567-8912";
		String[] s7 = s6.split("-");
		for (int i = 0; i < s7.length; i++) {
			System.out.println(s7[i]);
		} //for end
		
		System.out.println("=========================");
		String s8 = "1328472abcdef   3543535   576567   string";
		char ch = s8.charAt(10); //
		System.out.println(ch);
				
		s8 = s8.substring(3);
		System.out.println(s8); //3번 인덱스부터 끝까지 출력
		
		s8 = s8.substring(5, 7); //시작값 포함, 끝값 미포함
		System.out.println(s8);
		System.out.println("+++++++++++++++++++++++++++++++");
		
		System.out.println("소문자로 출력 toLowerCase() : " + s2.toLowerCase());
		System.out.println("대문자로 출력 toLowerCase() : " + s1.toUpperCase());
		System.out.println(s2);
		
		System.out.println(s1.length()); // 문자열 길이
		char[] ch2 = s1.toCharArray();
		
		for (int i = 0; i < s1.length(); i++) {
			System.out.print(ch2[i] + "\t");
		}
		
	}
}










