package sususu1;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends Frame{
	Button sujuWrite, end, sujuListRead, sujuListCheck, customeradd, productadd;
	TextArea sujuList;
	Dimension size;
	OrderUI ui;
	//OrderUI ui1= new OrderUI();
	public MainFrame(){
		
		this.setSize(500, 500);
		size = this.getSize(); 
		sujuWrite = new Button("수주입력");
		end = new Button("종료");
		sujuListRead = new Button("수주명세출력");
		customeradd = new Button("회원추가");
		productadd = new Button("상품추가");
		sujuWrite.setSize(100, 50);
		end.setSize(100, 50);
		sujuListRead.setSize(100, 50);
		customeradd.setSize(100, 50);
		productadd.setSize(100, 50);
		//Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		sujuWrite.setLocation(size.height/2-50, size.height/2-150);
		
		end.setLocation(size.height/2-50, size.height/2+50);

		sujuListRead.setLocation(size.height/2-50, size.height/2-100);
		
		customeradd.setLocation(size.height/2-50, size.height/2);
		
		productadd.setLocation(size.height/2-50, size.height/2-50);

		
		sujuWrite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ui = new OrderUI();
			}
		});
		
		end.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ui.dispose();
			}
		});
		
		sujuListRead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SujuListDialog();
				
			}
		});
		
		customeradd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerAddDialog();
			}
		});
		
		productadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProductAddDialog();
				
			}
		});
		
		this.add(sujuWrite);
		this.add(end);
		this.add(sujuListRead);
		this.add(customeradd);
		this.add(productadd);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void SujuListDialog(){
		Dialog info = new Dialog(this,"수주명세",true);
		info.setSize(400, 400);
		info.setLocation(50, 20);
		info.setLayout(null);
		Dimension size1 = info.getSize();
		
		sujuList = new TextArea();
		sujuList.setSize(300, 300);
		sujuList.setLocation(50, 50);
		
		
		StringBuilder sb = new StringBuilder("");
		for(Obtain ou : ui.obtain){
			sb.append(ou.toString()+"\n");
		}
		sujuList.setText(sb.toString());
		
		sujuListCheck = new Button("확인");
		sujuListCheck.setSize(100, 40);
		sujuListCheck.setLocation(size1.width/2-50, size1.height-50);
		
		sujuListCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				info.setVisible(false);
				info.dispose();
			}
		});
		
		info.add(sujuList);
		info.add(sujuListCheck);
		info.setVisible(true);
	}
	
	public void CustomerAddDialog(){
		Dialog info = new Dialog(this,"회원등록",true);
		TextField cuname = new TextField();
		TextField cuaddress = new TextField();
		TextField cuphoneno = new TextField();
		Label la_name = new Label("이름 : ");
		Label la_address = new Label("주소 : ");
		Label la_phoneno = new Label("전화번호 : ");
		Button ok = new Button("등록");
		
		info.setSize(500, 400);
		cuname.setSize(100, 25);
		cuaddress.setSize(100, 25);
		cuphoneno.setSize(200, 25);
		la_name.setSize(100, 25);
		la_address.setSize(100, 25);
		la_phoneno.setSize(100, 25);
		ok.setSize(100, 40);
		
		info.setLocation(50, 20);
		cuname.setLocation(50, 75);
		cuaddress.setLocation(50, 125);
		cuphoneno.setLocation(50, 175);
		la_name.setLocation(50, 50);
		la_address.setLocation(50, 100);
		la_phoneno.setLocation(50, 150);
		ok.setLocation(200, 350);

		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonData.PersonAdd(cuname.getText(), cuaddress.getText(), cuphoneno.getText());
				info.setVisible(false);
				info.dispose();
			}
		});
		
		info.setLayout(null);
		
		info.add(la_phoneno);
		info.add(la_address);
		info.add(la_name);
		info.add(cuphoneno);
		info.add(cuaddress);
		info.add(cuname);
		info.add(ok);
		info.setVisible(true);
	}
	
	public void ProductAddDialog(){
		Dialog info = new Dialog(this,"상품등록",true);
		TextField pdname = new TextField();
		TextField pdprice = new TextField();
		TextField pdstock = new TextField();
		Label la_name = new Label("상품이름 : ");
		Label la_price = new Label("상품가격 : ");
		Label la_phstock = new Label("상품수량 : ");
		Button ok = new Button("등록");
		
		info.setSize(500, 400);
		pdname.setSize(100, 25);
		pdprice.setSize(100, 25);
		pdstock.setSize(200, 25);
		la_name.setSize(100, 25);
		la_price.setSize(100, 25);
		la_phstock.setSize(100, 25);
		ok.setSize(100, 40);
		
		info.setLocation(50, 20);
		pdname.setLocation(50, 75);
		pdprice.setLocation(50, 125);
		pdstock.setLocation(50, 175);
		la_name.setLocation(50, 50);
		la_price.setLocation(50, 100);
		la_phstock.setLocation(50, 150);
		ok.setLocation(200, 350);

		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				WareHouse.ProductAdd(pdname.getText(), Integer.parseInt(pdprice.getText()), Integer.parseInt(pdstock.getText()));
				info.setVisible(false);
				info.dispose();
			}
		});
		
		info.setLayout(null);
		
		info.add(la_phstock);
		info.add(la_price);
		info.add(la_name);
		info.add(pdstock);
		info.add(pdprice);
		info.add(pdname);
		info.add(ok);
		info.setVisible(true);
	}
	
}
