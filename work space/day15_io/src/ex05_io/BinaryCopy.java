package ex05_io;
import java.io.*;
public class BinaryCopy {


		public static void main(String[] args) {
			
			File src = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum (2).jpg");
			File dist = new File("C:\\KSS\\work space\\day15_io\\src\\ex05_io\\Chrysanthemum (2).jpg");
			
			FileInputStream fis = null; //������ �ܹ����̴ϱ� ��ǲ�ƿ�ǲ���θ������.
			FileOutputStream fos = null;
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			int c;
			
			try {
				fis = new FileInputStream(src); //�����Է¹���Ʈ ��Ʈ�� ����
				fos = new FileOutputStream(dist); //���� ��� ����Ʈ��Ʈ�� ����
				bis = new BufferedInputStream(fis); // ���� �Է½�Ʈ�� ����
				bos = new BufferedOutputStream(fos); // ���� ��½�Ʈ�� ����
				
				while( (c = bis.read()) != -1 ) {//�ϳ��ϳ� �о���
					bos.write((char)c );
				} // while end
				
				System.out.println("���� ���� ����");
				bis.close();
				bos.close();
				fis.close();
				fos.close();
				//������ �ݾƾ���.
			} catch (Exception e) {
				System.out.println("���� ���� ���� �߻�!!!");
				//e.printStackTrace();
			} //end try
			
		}

	}



