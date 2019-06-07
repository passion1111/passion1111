package ex07_string;

public class MainEntry {
	public static void main(String[] args) {
		int x=999;
		String str="abc";
		System.out.println("str:"+str);
		char[] data= {'k','b','s'}; //<--하나하나들어가있는 data에
		str=new String(data);
		System.out.println(str);//str로 kbs찍게해줌
		
		String msg="csfdowqkf";
		System.out.println("korea"+msg);
		System.out.println(msg);
		
		msg=msg.concat("korea");//concat합치는거 문자열 결합
		System.out.println(msg);
		
		String str2="abcdef".substring(2);//중간값위치를 뽑아오는 함수.
		System.out.println(str2);//0부터배열시작이니까 cdef출력됩니다.
		
		str2="abcdefg241442342314213".substring(2, 5);//시작은 포함끝값은 미포함이다 n-1
		System.out.println(str2);
		
		System.out.println(msg+" :"+str2);//
	}
}
