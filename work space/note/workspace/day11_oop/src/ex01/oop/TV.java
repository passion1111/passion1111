package ex01.oop;

public class TV {
	private int channel;  //멤버변수
	private String color;
	
	//멤버함수
	//constructor(생성자) method - 멤버변수 초기화 담당, 디폴트 생성자함수 
	public TV() {  
		channel = 7;
		color = "green";
		System.out.println("default constructor call");
	}
	//매개변수 2개짜리 생성자 함수 
	public TV(int channel, String color) { 
		this.channel = channel;
		this.color = color;
		System.out.println("매개변수 2개짜리 생성자 함수 ");
	}
	public TV( String color ) { 
		this.channel = 15;
		this.color = color;
		System.out.println("매개변수 1개짜리 생성자 함수 ");
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
		System.out.println("TV의 색상: " + color + "\n현재 채널: " + channel);
//		System.out.println("선호하는 채널은 : " 
//				+ getChannel() + ", TV 색상은 " + getColor());
//		
//		System.out.println("선호하는 채널은 : " 
//				+ channel + ", TV 색상은 " + color);
	}
	
}
