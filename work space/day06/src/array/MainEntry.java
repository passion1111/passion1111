package array;

public class MainEntry {
	public static void main(String[] args) {
		char[] ch;//�迭 ���� �����Ͱ� �������ִ� heap������ �ּ�����.,��������
		ch=new char[4];  //�迭 ����,�޸𸮿� �Ҵ� 4����Ʈ������ �ֳ��ϸ� char�� 1����Ʈ�ϱ�.
		
		
		char[] ch2=new char[4]; //�迭 ���� �� ����
		//�迭 �ʱ�ȭ
		ch[0]='J';
		ch[1]='A';
		ch[2]='V';
		ch[3]='A';
		//3.
		char[] ch3= {'J','A','V','A'};

//�迭�� ���� ���
		System.out.println("ch3[]= "+ch[2]);
		
		//�迭�� ����(ũ��)
		System.out.println("�迭�� ����(ũ��) : "+ch2.length);//length�� �ʵ�.
		System.out.println("\n======");
		for(int i=0;i<4;i++) //�迭�� ���� ���� �־����.
			System.out.println("ch["+i+"]="+ch[i]);
		//for����
	System.out.println("\n======");  
	for(int i=0;i<ch.length;i++)  //���� ������� ����� ��������.
		System.out.println("ch["+i+"]="+ch[i]);
	//for����..
	System.out.println("\n======");//�迭�� ���̸� ���ϴ��ʵ� length�̿���
	for(int i=0;i<ch3.length;i++)  //���� ������� ����� ��������.
		System.out.println("ch["+i+"]="+ch3[i]);
	System.out.println(ch3.length);
}
	
	}
