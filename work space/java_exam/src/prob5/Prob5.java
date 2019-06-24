package prob5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class Prob5 {
	public static void main(String[] args) throws IOException {
		String fileName = "data.txt";
		makeVariable(fileName);
		
	}

	private static void makeVariable(String fileName) throws IOException {
		int i=0;
		String ProdNo = null;
		String ProdName = null;
		String Price = null;
		String Amount= null;
		String Maker= null;
		String RegDate= null;
		
		File f = new File(fileName);
		FileReader fr=new FileReader(f);
		BufferedReader reader=new BufferedReader(fr);
		
		try {
			fr = new FileReader(f);
			reader = new BufferedReader(fr);
//			
			
			
			while((i=reader.read())!=-1) {
				
				 ProdNo = reader.readLine().toLowerCase()+"\r\n";
				ProdName= reader.readLine().toLowerCase()+"\n";
				Price= reader.readLine().toLowerCase()+"\n";
				Amount= reader.readLine().toLowerCase()+"\n";
				 Maker= reader.readLine().toLowerCase()+"\n";
				RegDate= reader.readLine().toLowerCase()+"\n";
//				if(fr.equals("\n")) {
//					ProdNo+=(char)i;
//				}
				
				
				if(fr.equals("\n")) {
					
				}
			}
			
			System.out.print(ProdNo);
			System.out.print(ProdName);
			System.out.print(Price);
			System.out.print(Amount);
			System.out.print(Maker);
			System.out.print(RegDate);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
		} 
	}
	}
