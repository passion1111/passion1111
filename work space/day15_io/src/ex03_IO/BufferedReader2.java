package ex03_IO;
import java.io.*;
public class BufferedReader2 {
	public static void main(String[] args) throws Exception {//����ó�� ����.		

		

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
//		System.out.println("input =");
//		String str1=br.readLine();
//		System.out.println("input =");
//		String str2=br.readLine();
		
		int su1=Integer.parseInt(br.readLine());
		int su2=Integer.parseInt(br.readLine());
		
//		System.out.println(str1+str2);//������� ���ڿ������̿��� �پ����
		System.out.println(su1+su2);//IntegerŬ�����ϳ����� parseInt�� �ѱ�.
	}
}
