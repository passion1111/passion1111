package ex03_IO;
import java.io.*;
public class BufferedReader2 {
	public static void main(String[] args) throws Exception {//예외처리 위임.		

		

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
//		System.out.println("input =");
//		String str1=br.readLine();
//		System.out.println("input =");
//		String str2=br.readLine();
		
		int su1=Integer.parseInt(br.readLine());
		int su2=Integer.parseInt(br.readLine());
		
//		System.out.println(str1+str2);//결과보면 문자열결합이여서 붙어서나옴
		System.out.println(su1+su2);//Integer클래스하나만들어서 parseInt로 넘김.
	}
}
