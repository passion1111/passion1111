package ex06_io;
import java.io.*;


public class ObjectInputStreamEx {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		InputStream is=new FileInputStream("grade.dat");
		ObjectInputStream ois=new ObjectInputStream(is);
		
		Grade vo=(Grade)ois.readObject();
		System.out.println("result output:\t"+vo);
		is.close();ois.close();
	
	}

}
