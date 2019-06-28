//package quiz.gugudan;
//
//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.Panel;
//import java.awt.TextArea;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JFrame;
//
//public class GuGuDanOne extends JFrame {
//	TextArea ta;
//
//	public GuGuDanOne() {
//		setTitle("구구단 프로그램");
//		// setBounds(300, 200, 500, 400);
//		setSize(700, 400);
//		setLocation(300, 200); // 위치 지정
//		// this.pack();
//		setVisible(true);
//		setBackground(Color.BLUE);
//		setLayout(new FlowLayout()); // 배치관리자
//
//		Button[] b = new Button[9];
//		ta = new TextArea("구구단을\n입력하세요", 15, 20, TextArea.SCROLLBARS_BOTH);
//
//		for (int i = 1; i < b.length; i++) {
//			b[i] = new Button((i + 1) + "단");
//			b[i].addActionListener(new ActionListener() { // 버튼 이벤트 등록
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					Button target = (Button) e.getSource();
//					String caption = target.getActionCommand();
//
//					for (int j = 2; j <= b.length; j++) {
//
//						if (caption.equals(j + "단")) {
//							String msg = "";
//							for (int i = 1; i < 10; i++) {
//								msg += (" " + j + " X " + i + " = " + (j * i) + "\n");
//							}
//							ta.setText(msg);
//						} // if end
//					} // in for end
//				}// out for end
//			});
//		}
//
//		Panel p = new Panel();
//		for (int i = 1; i < 5; i++)
//			p.add(b[i]);
//		Panel p2 = new Panel();
//		for (int i = 5; i < 9; i++)
//			p2.add(b[i]);
//		Panel p3 = new Panel(new BorderLayout(5, 10));
//
//		p3.add("South", p2);
//		p3.add("North", p);
//
//		this.add("North", ta);
//		this.add("South", p3);
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기
//	} // 생성자함수
//
//	public static void main(String[] args) {
//		new GuGuDanOne();
//	}
//}
