package ex02_IO;

import java.io.IOException;
import java.io.InputStream;

public class KeyInput2 {
	public static void main(String[] args) throws IOException {
		InputStream is=System.in; //ǥ�� �Է�
		int su1=0,s2=0;
		
		System.out.println("������ �Է� ���� ctr+z��������");
		while((su1=System.in.read())!=-1) {
			System.out.print((char)su1+"\t");
			
		}
		System.out.println();
	}

}
