package ex07_string;

public class MainEntry {
	public static void main(String[] args) {
		int x=999;
		String str="abc";
		System.out.println("str:"+str);
		char[] data= {'k','b','s'}; //<--�ϳ��ϳ����ִ� data��
		str=new String(data);
		System.out.println(str);//str�� kbs�������
		
		String msg="csfdowqkf";
		System.out.println("korea"+msg);
		System.out.println(msg);
		
		msg=msg.concat("korea");//concat��ġ�°� ���ڿ� ����
		System.out.println(msg);
		
		String str2="abcdef".substring(2);//�߰�����ġ�� �̾ƿ��� �Լ�.
		System.out.println(str2);//0���͹迭�����̴ϱ� cdef��µ˴ϴ�.
		
		str2="abcdefg241442342314213".substring(2, 5);//������ ���Գ����� �������̴� n-1
		System.out.println(str2);
		
		System.out.println(msg+" :"+str2);//
	}
}
