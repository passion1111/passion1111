//*
package ex01.utilPackage;

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		StringTokenizer token = 
		new StringTokenizer("���=10|���ڷ�=3|������=1", "=|", true);		

		
		while( token.hasMoreTokens() ) { //���� ��Ұ� �ִ���?
			//System.out.println(token.nextToken());
			
			String str = token.nextToken();
			
			if( str.equals("=")) System.out.print("\t");
			else if( str.equals("|")) System.out.print("\n");
			else System.out.println(str);
			
		} // while end
	}
}
//*/


/*
package ex01.utilPackage;

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		StringTokenizer token = 
				new StringTokenizer("������/���¿�/����ȯ/�迵��", "/");		
		//new StringTokenizer("������ ���¿� ����ȯ �迵��");
		
		while( token.hasMoreTokens() ) {
			System.out.println(token.nextToken());
		}
	}
}
//*/