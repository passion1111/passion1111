package ex01.file;

import java.io.*;

public class RandomaccessEx {
	public static void main(String[] args) throws Exception{
		
		RandomAccessFile raf=new RandomAccessFile("exmple.txt", "rw");//예외발생 
		
		for (int i = 0; i <= 10; i++) {
			raf.seek(i*100);//예외발생 
			raf.write(i);
		}
			System.out.println("성공했어");
			raf.close();
		}
}