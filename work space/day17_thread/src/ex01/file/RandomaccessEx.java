package ex01.file;

import java.io.*;

public class RandomaccessEx {
	public static void main(String[] args) throws Exception{
		
		RandomAccessFile raf=new RandomAccessFile("exmple.txt", "rw");//���ܹ߻� 
		
		for (int i = 0; i <= 10; i++) {
			raf.seek(i*100);//���ܹ߻� 
			raf.write(i);
		}
			System.out.println("�����߾�");
			raf.close();
		}
}