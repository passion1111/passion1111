package oop;

public class Tv {
	private int channel;  //�������
	private String color;
	//����Լ�
	//constructor(������)method-��������� �ʱ�ȭ���,����Ʈ������
	//��������� �����Ҽ�����.
	
	public Tv() {
		channel=7;
		color="�ʷ�";
		System.out.println("default constructor call");
	}//�Ű�����2��¥�� ������ �Լ�
	public Tv(int channel,String color) {
		this.channel=channel;
		this.color=color;
		System.out.println("�Ű����� 2��¥�� �������Լ�");//�Ⱥҷ���.�Ⱥҷ����ϱ� tv()�κҷ������.
	}//�Ű�����2��¥�� �������Լ�
	public Tv(String color) {
		this.channel=15;
		this.color=color;
		System.out.println("�Ű����� 1��¥�� �������Լ�");
	}
	
	
	
	////////////////////////
	public int getChannel() { //����Լ�
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void disp() {
		System.out.println("Tv�� ������"+color+"\n ���� ä��: "+channel);
//		System.out.println("��ȣ�ϴ� ä���� : " 
//				+ getChannel() + ", TV ������ " + getColor());
		
//		System.out.println("��ȣ�ϴ� ä���� : " 
//				+ channel + ", TV ������ " + color);
		
		
	}
	
}
