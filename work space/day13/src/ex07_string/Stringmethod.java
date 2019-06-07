package ex07_string;

public class Stringmethod {
	public static void main(String[] args) {
		String s1="happyhappy";
		String s2="SEOSEO";
	
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());//해쉬 -1852589344
		System.out.println(s2.replace("EO", "OO"));
		System.out.println(s2.hashCode());//해쉬 -1852589344
		System.out.println(s2);//실제로 해쉬주소안바뀜. 바꾸고싶다면?
		s2=s2.replace("EO", "OO");
		System.out.println(s2.hashCode());//-1843353824 값이 바뀜.
		System.out.println("************************************");
		s1=s1.concat(s2);//문자열 결합
//		s1=s1+s2;   //위와 아래와 결과가같음.
		System.out.println(s1);//happyhappySOOSOO
		System.out.println("******************************");
		String s3=new String("     ab         cd         ");
		System.out.println(s3.length());//문자열길이 27
		s3=s3.trim();//앞 뒤 공백은 제거할수있지만 중간에있는 공백은 제거가불가능하다.
		System.out.println(s3);
		System.out.println(s3.length());// 문자열길이 13
	
		String s4=new String("ab /cddw/232323 /wqddwqwdq /232323");
//		String[] s5=s4.split(" ");  //split " "  공백이 구분자
//		for(int i=0;i<s5.length;i++) {
//			System.out.println("분리된"+i+"번 문자열:"+s5[i]);
		
		String[] s5=s4.split("/");  //split "/"  공백이 구분자
		for(int i=0;i<s5.length;i++) {
			System.out.println("분리된"+i+"번 문자열:"+s5[i]);
		}//for end
		System.out.println("==============");
		String s6="123-456-789";
		String[] s7=s6.split("-");
		for(int i=0;i<s7.length;i++) {
			System.out.println("분리된"+i+"번 문자열:"+s7[i]);
		}//for end
		
		String s8="231231wdqwddwq wqdwd qw qdwqd 23";
		char ch=s8.charAt(10);
		System.out.println(ch);
		
		s8=s8.substring(5);//5번부터 끝까지
		System.out.println(s8);
		s8=s8.substring(5, 7); //시작값포함 끝값 미포함.
		System.out.println(s8);
		System.out.println("====================================");
		
		System.out.println("소문자로 바꿔서 출력해보자.toLowerCase() :"+s2.toLowerCase());
		System.out.println("소문자로 바꿔서 출력해보자.toLowerCase() :"+s1.toUpperCase());
		System.out.println(s2);//값이 바뀌진않음
		
		System.out.println(s1.length());
		char[] ch2=s1.toCharArray();
		for(int i=0;i<s1.length();i++) {
			System.out.print(ch2[i]+"\t");
		}
	
	}
}

