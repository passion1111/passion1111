package ex07_file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class FileObjectSave2 implements Serializable {
	public class AppendingObjectOutputStream extends ObjectOutputStream {

		  public AppendingObjectOutputStream(OutputStream out) throws IOException {
		    super(out);
		  }

		  @Override
		  protected void writeStreamHeader() throws IOException {
		    // do not write a header, but reset:
		    // this line added after another question
		    // showed a problem with the original
		    reset();
		  }

		}
	public static void main(String[] args) throws IOException {
		// �̸� ���� �μ�
		String name = null;
		String position = null;
		String part = null;
		boolean con = true;
		

		/*
		 * FileObjectSave ������ �����ð��� �� ����� ��κ� �����մϴ�. ��� �Է����� �˷��ִ� boolean���� con��
		 * ���� ���� �Է��� �޽��ϴ�.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ObjectOutputStream oos1=null;
		File f = new File("C:\\\\Users\\\\user\\\\eclipse-workspace\\\\work space\\\\day15_io\\\\emp2.txt");

		try {
			FileOutputStream fos = new FileOutputStream(f, true); // append mode
			oos1 = new ObjectOutputStream(fos);
			AppendingObjectOutputStream a =new AppendingObjectOutputStream(out);
			a.writeStreamHeader();
			
	

			while (con) {
				System.out.println("----------------ȸ�� ���� �Է� �ϱ� ----------------------");
				System.out.print("�̸� >> ");
				name = br.readLine();
				System.out.print("���� >> ");
				position = br.readLine();
				System.out.print("�μ� >> ");
				part = br.readLine();

				oos1.writeObject(name);
				oos1.writeObject(position);
				oos1.writeObject(part);

				System.out.print("More Input? Y or N >> ");

				if (br.readLine().equalsIgnoreCase("N")) {
					con = false;
				}
				
			} // while end
			
			
			System.out.println("members.txt  save!!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			oos1.close();
		} // try end
	}
}

