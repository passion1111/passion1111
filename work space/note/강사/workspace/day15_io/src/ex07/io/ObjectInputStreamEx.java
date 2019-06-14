package ex07.io;
import java.io.*;

public class ObjectInputStreamEx {
	public static void main(String[] args) 
			throws FileNotFoundException, 
					IOException, 
					ClassNotFoundException {
		
		InputStream is = new FileInputStream("grade.dat");
		ObjectInputStream oos = new ObjectInputStream(is);
		
		Grade vo = (Grade)oos.readObject();
		System.out.println("result output : " + vo);
		oos.close();
		
	}
}
