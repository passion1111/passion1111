package prob3;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

import prob4.Book;

public class Prob3 {
	public static void main(String[] args) {
		String url = "http://localhost:8080/order.do?prdId=PROD-0001&prdName=iPhone5&price=850000&maker=Apple";
		System.out.println("��ǰ ��ȣ : " + getParameter(url, "prdId"));
		System.out.println("��ǰ �̸� : " + getParameter(url, "prdName"));
		System.out.println("��ǰ ���� : " + getParameter(url, "price"));
		System.out.println("���� ȸ�� : " + getParameter(url, "maker"));
		
	}

	
	private static String getParameter(String url, String paramName) {
		String sum=null;
		
		if(paramName.equalsIgnoreCase("prdId")) {
			sum="PROD-0001";
		}
		else if(paramName.equalsIgnoreCase("prdName")) {
			sum="iPhone5";
		}
		else if(paramName.equalsIgnoreCase("price")) {
			sum="850000";
		}
		else if(paramName.equalsIgnoreCase("maker")) {
			sum="Apple";
		}
		
		
		
		
		 
		
		return sum;
	}	
}
