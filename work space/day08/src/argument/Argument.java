package argument;
//입력받을 그릇은 scanner도있지만
//String[] args도 입력받을 그릇이다.
public class Argument {
	public static void main(String[] args) {//매개변수(인수)에 값을 전달
		
		System.out.println(args[0]);
		String str=args[1];
		System.out.println(str);
	}//run as로 구분하는방법은 spacebar로 구분하거나 엔터키로 구분.
//	args를 새로운 배열그릇으로 가능
//	그리고 javac 파일명 적고 스페이스바 한다음에 배열에 값넣어서 해야하는데 이클립스는 간단하게 가능하더라.
	

}
