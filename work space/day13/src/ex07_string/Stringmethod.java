package ex07_string;

public class Stringmethod {
	public static void main(String[] args) {
		String s1="happyhappy";
		String s2="SEOSEO";
	
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());//�ؽ� -1852589344
		System.out.println(s2.replace("EO", "OO"));
		System.out.println(s2.hashCode());//�ؽ� -1852589344
		System.out.println(s2);//������ �ؽ��ּҾȹٲ�. �ٲٰ�ʹٸ�?
		s2=s2.replace("EO", "OO");
		System.out.println(s2.hashCode());//-1843353824 ���� �ٲ�.
		System.out.println("************************************");
		s1=s1.concat(s2);//���ڿ� ����
//		s1=s1+s2;   //���� �Ʒ��� ���������.
		System.out.println(s1);//happyhappySOOSOO
		System.out.println("******************************");
		String s3=new String("     ab         cd         ");
		System.out.println(s3.length());//���ڿ����� 27
		s3=s3.trim();//�� �� ������ �����Ҽ������� �߰����ִ� ������ ���Ű��Ұ����ϴ�.
		System.out.println(s3);
		System.out.println(s3.length());// ���ڿ����� 13
	
		String s4=new String("ab /cddw/232323 /wqddwqwdq /232323");
//		String[] s5=s4.split(" ");  //split " "  ������ ������
//		for(int i=0;i<s5.length;i++) {
//			System.out.println("�и���"+i+"�� ���ڿ�:"+s5[i]);
		
		String[] s5=s4.split("/");  //split "/"  ������ ������
		for(int i=0;i<s5.length;i++) {
			System.out.println("�и���"+i+"�� ���ڿ�:"+s5[i]);
		}//for end
		System.out.println("==============");
		String s6="123-456-789";
		String[] s7=s6.split("-");
		for(int i=0;i<s7.length;i++) {
			System.out.println("�и���"+i+"�� ���ڿ�:"+s7[i]);
		}//for end
		
		String s8="231231wdqwddwq wqdwd qw qdwqd 23";
		char ch=s8.charAt(10);
		System.out.println(ch);
		
		s8=s8.substring(5);//5������ ������
		System.out.println(s8);
		s8=s8.substring(5, 7); //���۰����� ���� ������.
		System.out.println(s8);
		System.out.println("====================================");
		
		System.out.println("�ҹ��ڷ� �ٲ㼭 ����غ���.toLowerCase() :"+s2.toLowerCase());
		System.out.println("�ҹ��ڷ� �ٲ㼭 ����غ���.toLowerCase() :"+s1.toUpperCase());
		System.out.println(s2);//���� �ٲ�������
		
		System.out.println(s1.length());
		char[] ch2=s1.toCharArray();
		for(int i=0;i<s1.length();i++) {
			System.out.print(ch2[i]+"\t");
		}
	
	}
}

