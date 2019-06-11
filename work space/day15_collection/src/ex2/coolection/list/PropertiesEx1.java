package ex2.coolection.list;
import java.util.*;
import java.io.*;

class PropertiesEx1 {
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();//properties�� key+value���·� ������.
//										 

		// prop�� Ű�� ��(key, value)�� �����Ѵ�.
		prop.setProperty("timeout","30");//���޽ð�������
		prop.setProperty("language","kr");
		prop.setProperty("size","10");
		prop.setProperty("capacity","10");

		// prop�� ����� ��ҵ��� Enumeration�� �̿��ؼ� ����Ѵ�.
		Enumeration e = prop.propertyNames();//�̸����� �������.

		while(e.hasMoreElements()) {//e������ �� ��.
			String element = (String)e.nextElement();//��ҵ� �ҷ�����
			System.out.println(element + "="+ prop.getProperty(element));//����� �ҷ���.
		}

		System.out.println();
		prop.setProperty("size","20");	// size�� ���� 20���� �����Ѵ�.
		System.out.println("size=" + prop.getProperty("size"));
		System.out.println("capacity=" + prop.getProperty("capacity", "20"));
		System.out.println("loadfactor=" + prop.getProperty("loadfactor", "0.75"));

		System.out.println(prop);	// prop�� ����� ��ҵ��� ����Ѵ�.
		prop.list(System.out);   // prop�� ����� ��ҵ��� ȭ��(System.out)�� ����Ѵ�.
	}
}