/*
package quiz.sawon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Sawon {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		OutputStream os = new FileOutputStream("Sawon_Output.txt");
	
		while(true){
			
			System.out.println("1. 회원등록 2. 프로그램 끝내기");
			int choice = sc.nextInt();
			
			if ( choice==2 ) break;
			
			System.out.println("이름 :");
			String name = sc.next()+ "  ";
			
			System.out.println("직급 :");
			String level = sc.next()+ "  ";
			
			System.out.println("부서 :");
			String part = sc.next()+ "  ";
				
			os.write(name.getBytes());
			os.write(level.getBytes());
			os.write(part.getBytes());
		
		}
	}
}
//*/

//*


package quiz.sawon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Sawon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new FileWriter("Sawon.txt"));
		String name, level, dept;
		int pay =0;

		try{
			while(true){
				System.out.println("이름, 직급, 부서, 급여 를 입력하세요,\n q누르면 최종생성");
				name = br.readLine();
				
				if(name.equals("q")){
					System.out.println("생성되었습니다");
					break;
				}
				
				level = br.readLine();
				dept = br.readLine();
				pay = Integer.parseInt(br.readLine());

				String str = "name : "+name+"\r\nlevel : "+level+"\r\ndept : "+dept+"\r\npay : " + pay +"\r\n";
				System.out.println();

				writer.write(str);

			}
		}catch(IOException ie){ ie.printStackTrace(); }

		finally{
			try{ writer.close(); }
			catch(Exception e){ e.printStackTrace(); }

		}
	}
}
//*/