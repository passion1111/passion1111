package ex01.file;
import java.io.*;

public class RandomAccessFileEx {
	public static void main(String[] args) 
			throws FileNotFoundException,IOException { //����ó�� ����
		
		RandomAccessFile raf = 
				new RandomAccessFile("example.txt", "rw");  //���ܹ߻�
		
		for (int i = 0; i <= 10; i++) {
			
			raf.seek(i * 100);  //���ܹ߻�
			raf.writeInt(i);
		}
		
		System.out.println("����!!!");
		raf.close();
		
	}
}
