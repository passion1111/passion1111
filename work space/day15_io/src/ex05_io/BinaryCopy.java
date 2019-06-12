package ex05_io;
import java.io.*;
public class BinaryCopy {


		public static void main(String[] args) {
			
			File src = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum (2).jpg");
			File dist = new File("C:\\KSS\\work space\\day15_io\\src\\ex05_io\\Chrysanthemum (2).jpg");
			
			FileInputStream fis = null; //파일은 단방향이니까 인풋아웃풋따로만들어줌.
			FileOutputStream fos = null;
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			int c;
			
			try {
				fis = new FileInputStream(src); //파일입력바이트 스트림 연결
				fos = new FileOutputStream(dist); //파일 출력 바이트스트림 연결
				bis = new BufferedInputStream(fis); // 버퍼 입력스트림 연결
				bos = new BufferedOutputStream(fos); // 버퍼 출력스트림 연결
				
				while( (c = bis.read()) != -1 ) {//하나하나 읽어줌
					bos.write((char)c );
				} // while end
				
				System.out.println("파일 복사 성공");
				bis.close();
				bos.close();
				fis.close();
				fos.close();
				//썼으면 닫아야함.
			} catch (Exception e) {
				System.out.println("파일 복사 오류 발생!!!");
				//e.printStackTrace();
			} //end try
			
		}

	}



