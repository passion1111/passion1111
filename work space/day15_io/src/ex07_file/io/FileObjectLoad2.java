package ex07_file.io;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class FileObjectLoad2{
	public static void main(String[] args) throws Exception {
		String name = null;
		String position = null;
		String part = null;
		boolean con = true;

		/*
		 * FileObjectLoad�� Save�� ���������� �����ð��� �� �ڵ�� ��κ� ����մϴ�. try-catch������
		 * catch���� ��¦ �ٲ��ָ� ������ �ذ�˴ϴ�
		 */
		

		File f = new File("C:\\Users\\user\\eclipse-workspace\\work space\\day15_io\\emp2.txt");
		FileInputStream fis1 = null;
		FileInputStream fis2=null;
		
		ObjectInputStream bis = null;
		
		fis1 = new FileInputStream(f);
		
		bis = new ObjectInputStream(fis1);
		
		try {
			

			System.out.println("    >> ȸ�� ���� << \n");
			System.out.println("�̸� \t ���� \t �μ�");
//			objectStream=new AppendableObjectOutputStream;
			while (con) {
				

				name = (String) bis.readObject();
				position = (String) bis.readObject();
				part = (String) bis.readObject();
				System.out.print(name + "\t" + position + "\t" + part + "\t");
				System.out.println();
			}

			/*
			 * �̺κп��� (String) bis.read()�� bis��ü�� ���� �������� �� �ִ��� Ȯ���ϸ� �Է°��� �ϳ��� �з���
			 * �Էµ˴ϴ�.
			 */

		} catch (EOFException e) {
			// ������ ���� �����ϸ� EOFException�� �߻��մϴ�
			// �� ���ܸ� ó�����ָ� ���������� ó���˴ϴ�!
			System.out.println();
			System.out.println("Success Load File!");
		} finally {
			bis.close();
		} // try end
	}
}
