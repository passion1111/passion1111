package array;

public class MainEntry {
	public static void main(String[] args) {
		char[] ch;//배열 선언 데이터가 가지고있는 heap영역의 주소저장.,참조변수
		ch=new char[4];  //배열 생성,메모리에 할당 4바이트들어가있음 왜냐하면 char는 1바이트니까.
		
		
		char[] ch2=new char[4]; //배열 선언 및 생성
		//배열 초기화
		ch[0]='J';
		ch[1]='A';
		ch[2]='V';
		ch[3]='A';
		//3.
		char[] ch3= {'J','A','V','A'};

//배열의 내용 출력
		System.out.println("ch3[]= "+ch[2]);
		
		//배열의 길이(크기)
		System.out.println("배열의 길이(크기) : "+ch2.length);//length는 필드.
		System.out.println("\n======");
		for(int i=0;i<4;i++) //배열의 길이 직접 넣어야함.
			System.out.println("ch["+i+"]="+ch[i]);
		//for끝남
	System.out.println("\n======");  
	for(int i=0;i<ch.length;i++)  //길이 상관없이 출력이 가능해짐.
		System.out.println("ch["+i+"]="+ch[i]);
	//for끝남..
	System.out.println("\n======");//배열의 길이를 구하는필드 length이용함
	for(int i=0;i<ch3.length;i++)  //길이 상관없이 출력이 가능해짐.
		System.out.println("ch["+i+"]="+ch3[i]);
	System.out.println(ch3.length);
}
	
	}

