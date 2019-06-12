package ex05_io;
import java.io.*;
public class FileCopy {
	public static void main(String[] args) throws Exception {//예외처리 위임.
		//읽기 객체-fileinputstream
		InputStream is=new FileInputStream("Chrysanthemum.jpg");
		//쓰기 객체-fileoutputstream
		OutputStream os=new FileOutputStream("Chrysanthemum (3).jpg");
//		이 방법 느림여
		//outputstream-
		long start=System.currentTimeMillis();
		
		while(true) {
			int inputdata=is.read();
			if(inputdata==-1)break;
			os.write(inputdata);
		}
		long end=System.currentTimeMillis();
		long result=end-start;
		is.close();os.close();
		System.out.println("copy success!");
		System.out.println("작업걸린시간"+result);
	}

	}



