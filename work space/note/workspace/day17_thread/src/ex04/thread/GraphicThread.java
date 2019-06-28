package ex04.thread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JFrame;

public class GraphicThread 
			extends JFrame implements Runnable {
				// Frame : window
	
	int num, x, y;
	Color color;
	Random random;
	
	public GraphicThread(int num) { //생성자함수 - 초기화
		this.num = num;
		color = Color.red;
		random = new Random();
		
		setSize(500, 400); //프레임(화면) 크기 - 너비, 높이
		setVisible(true); //화면보여주기
		setLocation(300, 150);  //위치지정
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기
	}
		
	@Override
	public void run() { //스레드 실행부
		Rectangle rect = getBounds();
		
		for (int i = 0; i < num; i++) {
			x = random.nextInt(rect.width);
			y = random.nextInt(rect.height);
			
			repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} //for end
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		//g.fillOval(x, y, 10, 10);
		g.fillRect(x, y, 3, 3);
	}

	public static void main(String[] args) {
		//1
//		GraphicThread gframe = new GraphicThread(2000);
//		Thread t1 = new Thread(gframe);
//		t1.start();
		
		//2.
		new Thread(new GraphicThread(3000)).start();
	}
}







