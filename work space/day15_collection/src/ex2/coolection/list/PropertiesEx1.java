package ex2.coolection.list;
import java.util.*;
import java.io.*;

class PropertiesEx1 {
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();//properties는 key+value형태로 돼있음.
//										 

		// prop에 키와 값(key, value)을 저장한다.
		prop.setProperty("timeout","30");//유휴시간을위해
		prop.setProperty("language","kr");
		prop.setProperty("size","10");
		prop.setProperty("capacity","10");

		// prop에 저장된 요소들을 Enumeration을 이용해서 출력한다.
		Enumeration e = prop.propertyNames();//이름들을 가지고옴.

		while(e.hasMoreElements()) {//e값들을 다 뱉어냄.
			String element = (String)e.nextElement();//요소들 불러오고
			System.out.println(element + "="+ prop.getProperty(element));//밸류값 불러옴.
		}

		System.out.println();
		prop.setProperty("size","20");	// size의 값을 20으로 변경한다.
		System.out.println("size=" + prop.getProperty("size"));
		System.out.println("capacity=" + prop.getProperty("capacity", "20"));
		System.out.println("loadfactor=" + prop.getProperty("loadfactor", "0.75"));

		System.out.println(prop);	// prop에 저장된 요소들을 출력한다.
		prop.list(System.out);   // prop에 저장된 요소들을 화면(System.out)에 출력한다.
	}
}