package ex05_io;
import java.io.*;
import java.net.*;

import javax.management.openmbean.OpenDataException;
public class URicopy {
	public static void main(String[] args) throws IOException {//예외처리위임.
		URL url=new URL("https://www.google.com/logos/doodles/2019/2019-womens-world-cup-day-6-5696430367309824-s.png");
		
		//읽기객체
		InputStream is=url.openStream();
		//쓰기객체
		OutputStream os=new FileOutputStream("google.jpg");
		
		byte[] buffer=new byte[1024*8];
		
		while(true) {
			int inputData=is.read(buffer);
			if(inputData==-1) break;
			os.write(buffer,0,inputData);
		}
	is.close(); os.close();
	}
	
}
