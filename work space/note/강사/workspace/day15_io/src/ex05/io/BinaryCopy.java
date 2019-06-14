package ex05.io;
import java.io.*;

public class BinaryCopy {
	public static void main(String[] args) {
		
//		File src = new File("C:\\Windows\\explorer.exe");
		File src = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg");
		File dist = new File("C:/th129_java_web_app_developer/Jellyfish.png");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		int c;
		
		try {
			fis = new FileInputStream(src); //�����Է¹���Ʈ ��Ʈ�� ����
			fos = new FileOutputStream(dist); //���� ��� ����Ʈ��Ʈ�� ����
			bis = new BufferedInputStream(fis); // ���� �Է½�Ʈ�� ����
			bos = new BufferedOutputStream(fos); // ���� ��½�Ʈ�� ����
			
			while( (c = bis.read()) != -1 ) {
				bos.write((char)c );
			} // while end
			
			System.out.println("���� ���� ����");
			bis.close();			bos.close();
			fis.close();			fos.close();
			
		} catch (Exception e) {
			System.out.println("���� ���� ���� �߻�!!!");
			//e.printStackTrace();
		} //end try
		
	}

}









