package ex04_file;
import java.io.*;
import java.util.Date;
public class FileInformation {

	public static void main(String[] args) throws IOException {//예외처리 위임
		File file=null;
		byte[] fileName=new byte[100];
		String strname;
		System.out.println("file name=");//상대경로-memo.txt
//		//상대 경로는 이름.확장자만 적으면 되는데 절대경로는 다 적어줘야한다.
//		C:\KSS\work space\day15_io\memo.txt 절대 경로
		System.in.read(fileName);//예외발생
		strname=new String(fileName).trim();//위에서 읽어낸 파일 이름 받아옴.
		//실행후 파일이름.확장자눌러보기
		file = new File(strname);//생성자함수 file불러냄 api참조
		
		//상대 경로는 이름.확장자만 적으면 되는데 절대경로는 다 적어줘야한다.
		
		System.out.println("절대 경로 : "+file.getAbsolutePath());
		System.out.println("표준 경로 : "+file.getCanonicalPath());
		System.out.println("최종 수정일 : "+new Date(file.lastModified()));
		System.out.println("파일 크기 : "+file.length());
		System.out.println("읽기 속성 : "+file.canRead());
		System.out.println("쓰기 속성 : "+file.canWrite());
		System.out.println("파일 경로 : "+file.getPath());
		System.out.println("숨김 속성 : "+file.isHidden());
		
	}
}
