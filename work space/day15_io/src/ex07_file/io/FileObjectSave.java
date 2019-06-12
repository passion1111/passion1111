package ex07_file.io;

import java.io.*;

public class FileObjectSave {
	public static void main(String[] args) throws IOException {
		String name = null;
		String id = null;
		String pwd = null;
		boolean gender = true;
		int age =0;
		String phone = null;
		String temp = null;
		
		/*InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//사용자가 키보드로부터 입력받을 그릇
		ObjectOutputStream  oos = null;// 객체로 써줄것.
		File f = new File("members.txt");//저장할것.
		
		try {
			FileOutputStream fos = new FileOutputStream(f, true);  //append mode 기존에있던 파일 지우지않는것.
			
			oos = new ObjectOutputStream(fos);
			
			System.out.println("--------------------회원 정보 입력 하기 ------------------------------");
			System.out.print("이름 >> ");  		name = br.readLine();
			System.out.print("ID >> "); 			 id = br.readLine();
			System.out.print("Password >> "); 	 pwd = br.readLine();
			
			System.out.print("성별 m,f >> ");  		temp = br.readLine(); //String타입의 버퍼역할
			if( temp.toLowerCase().equals("m"))   	gender = true; //남녀인지
			else 		gender = false;
			
			System.out.print("나이 >> ");  		age = Integer.parseInt( br.readLine() );
			System.out.print("전화번호 >> ");  	phone = br.readLine();
			oos.writeObject(name);
			oos.writeObject(id);
			oos.writeObject(pwd);
			oos.writeObject(gender);
			oos.writeObject(age);
			oos.writeObject(phone);
			System.out.println("members.txt  save!!!");		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			oos.close();
		} // try end
	}
}






