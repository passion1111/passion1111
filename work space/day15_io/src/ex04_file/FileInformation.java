package ex04_file;
import java.io.*;
import java.util.Date;
public class FileInformation {

	public static void main(String[] args) throws IOException {//����ó�� ����
		File file=null;
		byte[] fileName=new byte[100];
		String strname;
		System.out.println("file name=");//�����-memo.txt
//		//��� ��δ� �̸�.Ȯ���ڸ� ������ �Ǵµ� �����δ� �� ��������Ѵ�.
//		C:\KSS\work space\day15_io\memo.txt ���� ���
		System.in.read(fileName);//���ܹ߻�
		strname=new String(fileName).trim();//������ �о ���� �̸� �޾ƿ�.
		//������ �����̸�.Ȯ���ڴ�������
		file = new File(strname);//�������Լ� file�ҷ��� api����
		
		//��� ��δ� �̸�.Ȯ���ڸ� ������ �Ǵµ� �����δ� �� ��������Ѵ�.
		
		System.out.println("���� ��� : "+file.getAbsolutePath());
		System.out.println("ǥ�� ��� : "+file.getCanonicalPath());
		System.out.println("���� ������ : "+new Date(file.lastModified()));
		System.out.println("���� ũ�� : "+file.length());
		System.out.println("�б� �Ӽ� : "+file.canRead());
		System.out.println("���� �Ӽ� : "+file.canWrite());
		System.out.println("���� ��� : "+file.getPath());
		System.out.println("���� �Ӽ� : "+file.isHidden());
		
	}
}
