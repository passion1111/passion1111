package ex03_IO;
import java.io.*;
public class BufferedReader1 {
	public static void main(String[] args) throws Exception {//����ó�� ����.		
//		
//		InputStream is=System.in;		
//		Reader reader=new InputStreamReader(is);
//		BufferedReader br=new BufferedReader(reader);
		

		
//		��ü������ ���� ȣ������������ �ѹ��� �����ֱ�/
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("charactor input = ");
		String str=br.readLine();//���ܹ߻� �������� �������Է¹�
		System.out.println(str);
	}
}
