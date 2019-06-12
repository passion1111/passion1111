package ex02_IO;

import java.io.IOException;
import java.io.InputStream;

public class KeyInput2 {
	public static void main(String[] args) throws IOException {
		InputStream is=System.in; //표준 입력
		int su1=0,s2=0;
		
		System.out.println("데이터 입력 끝은 ctr+z누르세요");
		while((su1=System.in.read())!=-1) {//-1은 값이 끝까지들어가면 -1이 리턴되니 -1이 아닐떄까지. 즉 계속 입력받음.
			System.out.print((char)su1+"\t");
			
		}
		System.out.println();
	}

}
