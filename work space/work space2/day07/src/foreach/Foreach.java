package foreach;
//foreach,확장for문= for(자료형 변수명:배열명 또는 컬렉션명){ 반복실행문 }
// ex)for(int e:arr) 
public class Foreach {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7};
		
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i] + " "); //오름차순
			if( i == 3 ) break;
		}
		System.out.println("\n==============");
		
		for(int e:a) { //중간에 멈출수없음 ,무조건 오름차순
			System.out.println(e);
		}
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i] + " ");
	}
		System.out.println("\n내림차순 출력");
		for(int i= a.length-1 ; i >= 0 ; i--) {
			System.out.print(a[i] + " ");
		}

		
		
}
}
