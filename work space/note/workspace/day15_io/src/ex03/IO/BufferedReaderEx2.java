package ex03.IO;
import java.io.*;

public class BufferedReaderEx2 {
	public static void main(String[] args) 
			throws IOException {  //예외처리 위임

		BufferedReader br = new BufferedReader(
				 		   new InputStreamReader(System.in));
		
//		System.out.println("input = ");
//		String str1 = br.readLine();
//		System.out.println("input = ");
//		String str2 = br.readLine();
//		
//		int su1 = Integer.parseInt(str1);
//		int su2 = Integer.parseInt(str2);
		
		System.out.println("input = ");
		int su1 = Integer.parseInt(br.readLine());
		System.out.println("input = ");
		int su2 = Integer.parseInt(br.readLine());
		
		System.out.println(su1 + su2);
		
		
	}
}







