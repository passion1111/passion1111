package ex03.Interface;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//Bus bus = new Bus();
		Trasport t = new Bus();
		t.move();
		t.stop();
	}
}
