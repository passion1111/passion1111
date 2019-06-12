package ex05_io;
import java.io.*;
public class InputStringex {
	public static void main(String[] args) throws Exception{
		File file=new File("test.txt");
		FileInputStream fis=new FileInputStream(file);
		DataInputStream dis=new DataInputStream(fis);//데이터타입에 맞게끔 읽어오세요
		
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		System.out.println(dis.readShort());
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
		System.out.println(dis.readFloat());
		System.out.println(dis.readDouble());
		
		dis.close();
		
	}
}
