package ex06_io;
import java.io.*;
public class ObjectoutputStreamEx2 {
	public static void main(String[] args) throws IOException {
		Grade vo=new Grade();
//		vo.setSubject("�̼�");
//		vo.setScore(80);
		
		vo.setSubject("����");
		vo.setScore(90);
		System.out.println(vo);
		
		OutputStream os=new FileOutputStream("grade.dat");
		ObjectOutputStream oos=new ObjectOutputStream(os);
		
		oos.writeObject(vo);
		oos.close();
		
	}
}
