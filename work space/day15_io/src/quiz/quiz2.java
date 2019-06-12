package quiz;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
public class quiz2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(System.in);
		OutputStream os=new FileOutputStream("memo2.txt");
		
		String name,department,jobgrade;
		name=sc.nextLine()+"\t\n";
		department=sc.next()+"\t\n";
		jobgrade=sc.next()+"\r\n";
		
		
		try {
			
				
			
			os.write(name.getBytes());
			os.write(department.getBytes());
			os.write(jobgrade.getBytes());
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
}
