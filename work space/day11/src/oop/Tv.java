package oop;

public class Tv {
	private int channel;  //멤버변수
	private String color;
	//멤버함수
	//constructor(생성자)method-멤버변수의 초기화담당,디폴트생성자
	//명시적으로 접근할수없음.
	
	public Tv() {
		channel=7;
		color="초록";
		System.out.println("default constructor call");
	}//매개변수2개짜리 생성자 함수
	public Tv(int channel,String color) {
		this.channel=channel;
		this.color=color;
		System.out.println("매개변수 2개짜리 생성자함수");//안불려짐.안불렀으니까 tv()로불렀을경우.
	}//매개변수2개짜리 생성자함수
	public Tv(String color) {
		this.channel=15;
		this.color=color;
		System.out.println("매개변수 1개짜리 생성자함수");
	}
	
	
	
	////////////////////////
	public int getChannel() { //멤버함수
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
		System.out.println("Tv의 색상은"+color+"\n 현재 채널: "+channel);
//		System.out.println("선호하는 채널은 : " 
//				+ getChannel() + ", TV 색상은 " + getColor());
		
//		System.out.println("선호하는 채널은 : " 
//				+ channel + ", TV 색상은 " + color);
		
		
	}
	
}
