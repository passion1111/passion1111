package ex05_io;
import java.io.*;
public class OutputStringex2 {
	public static void main(String[] args) throws Exception {
		File file=new File("test.txt");
		FileOutputStream fos=new FileOutputStream(file);
		DataOutputStream dos=new DataOutputStream(fos);
		
		dos.writeBoolean(true);
		dos.writeChar(65);//ASCII code->'A'
		dos.writeShort(100);
		dos.writeInt(5000);
		dos.writeLong(5000000);
		dos.writeFloat(50.134f);
		dos.writeDouble(5.4235235);
		
		//버퍼는 차면 알아서 비워주지만 만약 다차지않는다면 비워줄필요가 있기떄문에 비우는것이 필요하다.
		
		dos.flush();//버퍼를 비우는 역할
		System.out.println("memo.txt파일에"+dos.size()+"byte save");//근데 꺠져보임 파일로부르면 정상적으로 보여요
		
		dos.close();
	}
}
