package method;

import java.util.Scanner;

public class Next {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=sc.next();//버퍼에 값이 있다 엔터치면 메모리상에 저장 
        sc.next();      //입력받은next에 스페이스바직전까지만 입력되는데 스페이스바 이후가 버퍼에 남아있어서 다음 
//		입력 명령어도 임시버퍼에 남아있어서 다음 입력까지 입력받지못하고 임시버퍼에 있던 값이 나가기떄문에
//	   스페이스 하나만이후의값들이 다음 입력값까지 전달되게됨.
//		sc.nextLine();
		String s2=sc.next();//
		
		System.out.println(name+","+s2);
		
		
		
		
	}

}
