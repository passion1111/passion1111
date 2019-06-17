package ex05_io;
import java.io.*;
public class FileCopy2 {
	public static void main(String[] args) throws Exception {//예외처리 위임.
		//읽기 객체-fileinputstream
		InputStream is=new FileInputStream("Chrysanthemum.jpg");
		//쓰기 객체-fileoutputstream
		OutputStream os=new FileOutputStream("Chrysanthemum (3).jpg");
//		이 방법 느림여
		//outputstream-
		byte[] buffer=new byte[1024*8];//바이트 빠름
		
		long start=System.currentTimeMillis();
		
		while(true) {
			int inputdata=is.read(buffer);//버퍼크기만큼 읽어들임.
			if(inputdata==-1)break;
			os.write(buffer,0,inputdata);//버퍼를 0부터 인풋데이터 크기만큼.
		}
		long end=System.currentTimeMillis();
		long result=end-start;
		is.close();os.close();
		System.out.println("copy success!");
		System.out.println("작업걸린시간"+result);
	}

	}



