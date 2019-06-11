package ex01.oop;

public class TV {
	private int channel;  //�������
	private String color;
	
	//����Լ�
	//constructor(������) method - ������� �ʱ�ȭ ���, ����Ʈ �������Լ� 
	public TV() {  
		channel = 7;
		color = "green";
		System.out.println("default constructor call");
	}
	//�Ű����� 2��¥�� ������ �Լ� 
	public TV(int channel, String color) { 
		this.channel = channel;
		this.color = color;
		System.out.println("�Ű����� 2��¥�� ������ �Լ� ");
	}
	public TV( String color ) { 
		this.channel = 15;
		this.color = color;
		System.out.println("�Ű����� 1��¥�� ������ �Լ� ");
	}
	
	public int getChannel() { 
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
		System.out.println("TV�� ����: " + color + "\n���� ä��: " + channel);
//		System.out.println("��ȣ�ϴ� ä���� : " 
//				+ getChannel() + ", TV ������ " + getColor());
//		
//		System.out.println("��ȣ�ϴ� ä���� : " 
//				+ channel + ", TV ������ " + color);
	}
	
}
