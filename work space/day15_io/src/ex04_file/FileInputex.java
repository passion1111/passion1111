package ex04_file;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
public class FileInputex {
	public static void main(String[] args) {
		//throws FileNotFoundException ���� �߻�

Scanner sc = new Scanner(System.in);

try {
//	OutputStream os = new FileOutputStream("memo.txt"); //����� ���� �۾��ϴ� ������ ���� ����
//	OutputStream os = new FileOutputStream("C:\\KSS\\work space\\day15_io\\memo.txt");//������ ��������2��
	OutputStream os = new FileOutputStream("C:/KSS/work space/day15_io/memo.txt");//�������� /�̶�� �ѹ�
	while(true) {
		System.out.println("���ڿ� �Է� ��� : ");
		String str = sc.nextLine() + "\r\n"; //\r�� �� �������� Ŀ���� ���Բ��ϴ°�.
		
//		if( str.toUpperCase().equals("EXIT\r\n")) break;
		if( str.equalsIgnoreCase("EXIT\r\n")) break;
		os.write(str.getBytes()); //�о���� ���� str�� ����(getBytes())��ŭ ���ּ���.
	} //end while
	
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}

}
}
