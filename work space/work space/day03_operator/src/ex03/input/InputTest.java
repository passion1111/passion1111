package ex03.input;
import java.util.*;  //java.util.*처리하면 util전부 특정 클래스 util.Scanner로 구체적으로 받기도 가능
                                      //입력받기 class jdk5.0이상부터생김
									//그전에는 java.io<---input/output으로 받았음.
                       //javalang,extends object<-모든 클래스는 오브젝트 상속받음. 오브젝트는 기본으로적용
					//javalang제외한 모든 패키지는 import해줘야한다.
public class InputTest {
			public static void main(String[] args) {     //표준입력 System.in ,표준출력:System.out
				Scanner scan= new Scanner(System.in);  //입력그릇 생성
				System.out.print("정수 데이터 입력하세요 : "+ "");
				int su=scan.nextInt();
				
				System.out.println("\n\n 입력 받은 수 : " +su);
				
				
			}
	                      

}
