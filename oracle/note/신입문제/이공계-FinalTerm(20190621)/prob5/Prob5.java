package prob5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Prob5 {
	public static void main(String[] args) {
		String fileName = "./src/prob5/data.txt";
		makeVariable(fileName);
	}

	private static void makeVariable(String fileName) {
		int i=0;
		FileInputStream fs=null;
		File f=new File(fileName);
		BufferedInputStream bs=null;
		try {
			fs=new FileInputStream(f);
			bs=new BufferedInputStream(fs);
			
			while(bs.read()!=-1) {
				System.out.println((char)i
						);
				
			}
			System.out.println("3");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	
	}
}
