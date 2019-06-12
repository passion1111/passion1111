package ex05_io;
import java.io.*;
public class OutputStringex2 {
	public static void main(String[] args) throws Exception {
		File file=new File("test.txt");
		FileOutputStream fos=new FileOutputStream(file);
		DataOutputStream dos=new DataOutputStream(fos);
		
		dos.writeBoolean(true);
		dos.writeChar(65);//ASCII code->'A'
		dos.writeShort(100);
		dos.writeInt(5000);
		dos.writeLong(5000000);
		dos.writeFloat(50.134f);
		dos.writeDouble(5.4235235);
		
		//���۴� ���� �˾Ƽ� ��������� ���� �������ʴ´ٸ� ������ʿ䰡 �ֱ⋚���� ���°��� �ʿ��ϴ�.
		
		dos.flush();//���۸� ���� ����
		System.out.println("memo.txt���Ͽ�"+dos.size()+"byte save");//�ٵ� �������� ���Ϸκθ��� ���������� ������
		
		dos.close();
	}
}
