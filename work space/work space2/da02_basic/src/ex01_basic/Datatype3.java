//*
package ex01_basic;

public class Datatype3 {
		//형변환 문자->int타입 불가 int 숫자로는가능 
		public static void main(String[] args) { //main<- ctr+spacebar
			short sh =32767; //-32768~32767 : 2byte
			int num=32769;  //-21억~21억 4byte
			//작은 자료형이 큰자료형에 들어갈떄 자동형변환이 들어감.(묵시적 형변환)
			num = sh;  //int(4byte) = short (2byte)
			
			System.out.println("sh= " +sh);
			System.out.println("num= " +num);

		   num=32769; //큰 자료형을 작은자료형으로 넣을려면 명시적 형변환이 필요함.
		   //그리고 데이터손실이 발생함.
		   sh=(short)num; //short(2byte)=num(4byte) 
		   System.out.println("sh= "+sh);
		   System.out.println("num= "+num);
		
		}
}

//*/

/*  

public class Datatype3 {
	//모든 자료형은 자신의 범위(크기)를 안벗어난다.
	public static void main(String[] args) { //main<- ctr+spacebar
		short sh = 32767;   //-32,768~32,767
		int num=50000; //-21억~21억
		
		System.out.println(sh+ " : " + num);
		num= -32769;
		/*sh= num;  < 에러뜨는이유는 sh가 2바이트를 넘어가기떄문*/
/*
		sh=(short)num;
		System.out.println(sh+ " : " + num); //결과예상할것.
		//-32769에서 1을 벗어났기떄문에 데이터끝값과 연결된값을호출
	}
}
*/

/*  */ // 왼쪽에 */ /*에 /하나씩 더 넣으면 주석토글이 가능함.

/* // 왼쪽에 */ /*에 /하나씩 더 넣으면 주석토글이 가능함.*/