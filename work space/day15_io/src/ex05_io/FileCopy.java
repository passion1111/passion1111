package ex05_io;
import java.io.*;
public class FileCopy {
	public static void main(String[] args) throws Exception {//����ó�� ����.
		//�б� ��ü-fileinputstream
		InputStream is=new FileInputStream("Chrysanthemum.jpg");
		//���� ��ü-fileoutputstream
		OutputStream os=new FileOutputStream("Chrysanthemum (3).jpg");
//		�� ��� ������
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
		System.out.println("�۾��ɸ��ð�"+result);
	}

	}



