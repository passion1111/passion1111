package ex07_stringbuffer;

public class StringBuffer2 {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("this");
		System.out.println(sb);
		
		sb.append(" is pecil");//append 문자열추가함수 뒤에서부터 채워짐. incert는 앞에서 추가
		System.out.println(sb);
		
		sb.insert(7, " my");//문자열삽입.
		System.out.println(sb);
		
		sb.replace(8, 10, "your");//문자열 변경 교체
		System.out.println(sb);
		
		sb.setLength(5);//크기만 짤려보이지 실제로는 메모리할당돼있
		System.out.println(sb);
		System.out.println(sb.capacity());//보면 20만큼있는걸로 확인할수가있어여.
	}

}
