package ex05_io;
import java.io.*;
public class FileCopy2 {
	public static void main(String[] args) throws Exception {//����ó�� ����.
		//�б� ��ü-fileinputstream
		InputStream is=new FileInputStream("Chrysanthemum.jpg");
		//���� ��ü-fileoutputstream
		OutputStream os=new FileOutputStream("Chrysanthemum (3).jpg");
//		�� ��� ������
		//outputstream-
		byte[] buffer=new byte[1024*8];//����Ʈ ����
		
		long start=System.currentTimeMillis();
		
		while(true) {
			int inputdata=is.read(buffer);//����ũ�⸸ŭ �о����.
			if(inputdata==-1)break;
			os.write(buffer,0,inputdata);//���۸� 0���� ��ǲ������ ũ�⸸ŭ.
		}
		long end=System.currentTimeMillis();
		long result=end-start;
		is.close();os.close();
		System.out.println("copy success!");
		System.out.println("�۾��ɸ��ð�"+result);
	}

	}



