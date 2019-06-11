package ex05.inheritance;

import java.util.Scanner;

class TV {
	private String color;
	private int channel;

	public TV() {
		color = "red";
		channel = 3;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getChannel() {
		return channel;
	}

	public void display() {
		System.out.println("\n\ncolor : " + getColor() + " channel : " + getChannel());
	}
	
	@Override
	public String toString() {
		return "TV의 색상: " + color + "\t현재 채널: " + channel ; 
	}
	
} // TV end

public class TVMain {
	public static void main(String[] args) {
		TV t = new TV();
		Scanner sc = new Scanner(System.in);
		System.out.print("Color : ");
		t.setColor(sc.next());
		System.out.print("Channel : ");
		t.setChannel(sc.nextInt());
		t.display();
		System.out.println(t); //아래와 같은 상황
		//System.out.println(t.toString());
	}
} // TVMain end





