package sususu1;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OrderUI extends Frame{
	int input;
	int customerNum;
	int customerNum1;//1이 붙은 것은 UI에서 사용하는거 완료하면 1이 없는 변수는 지우자
	int productCode;
	int productCode1;
	int neededAmount;
	int neededAmount1;
	int total;
	double discountRate;
	double discountRate1;
	boolean stockCheck = false;
	boolean sujuListCheck = false;
	String basket = "고객번호\t상품코드\t주문수량\t주문가격[만원]\n";

	static ArrayList<Obtain> obtain = new ArrayList<Obtain>();
	static ArrayList<ObtainList> obtainList = new ArrayList<ObtainList>();
	static int i = 1;
	WareHouse tempWh;
	
	TextArea ta_obtain, ta_product, ta_sujuList;
	
	Label la_customerNum, la_customer, la_productCode, la_stock, la_discountRate;
	
	Button bu_check, bu_check2, bu_sujuinput, bu_sujuCancel, bu_sujuRegistration;
	
	TextField tf_customerNum, tf_productCode, tf_stockNum, tf_discountRate;
	
	
	public OrderUI() {
		
		tempWh = new WareHouse();
		ta_obtain = new TextArea("********************고객정보리스트**********************");
		ta_product = new TextArea("********************상품정보리스트**********************");
		ta_sujuList = new TextArea("********************수주입력리스트**********************");
		la_customerNum = new Label("고객번호");
		la_customer = new Label();
		la_productCode = new Label("상품코드");
		la_stock = new Label("현재 재고 = ");
		la_discountRate = new Label("할인율");
		bu_check = new Button("확인");
		bu_check2 = new Button("재고확인");
		bu_sujuinput = new Button("입력");
		bu_sujuRegistration = new Button("수주등록");
		bu_sujuCancel = new Button("수주취소");
		tf_customerNum = new TextField("고객번호를 입력하세요");
		tf_productCode = new TextField("상품코드를 입력하세요");
		tf_stockNum = new TextField("주문할 수량을 입력하세요");
		tf_discountRate = new  TextField("0");
		
		UIFrame();
	}
	
	public void UIFrame(){
		this.setSize(600, 500);
		ta_obtain.setSize(500, 150);
		ta_obtain.setLocation(50, 50);
		StringBuilder sb = new StringBuilder("");
		for (Customer customerInfo : PersonData.customerList) {
			sb.append(customerInfo.toString()+"\n");
		}
		ta_obtain.setText(sb.toString());
		
		
		bu_check.setSize(100, 25);
		bu_check.setLocation(440, 210);
		bu_check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_customerNum.requestFocus();
				tf_customerNum.selectAll();
				customerNum1 = Integer.parseInt(tf_customerNum.getText());
				if (customerNum1 > PersonData.customerList.size()|| customerNum1 <= 0) {
					Dialogss("고객 번호를 잘못 입력하셨습니다.");
				}else{
					remove(bu_check);
					UIFrame2();
				}	
				
			}
		});
		
		
		la_customerNum.setSize(50, 25);
		la_customerNum.setLocation(50, 210);
		
		
		tf_customerNum.setSize(200, 25);
		tf_customerNum.setLocation(220, 210);
		
		
		this.add(ta_obtain);
		this.add(la_customerNum);
		this.add(bu_check);
		this.add(tf_customerNum);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	
	public void UIFrame2(){
		this.setSize(600, 700);
		
		la_customer.setSize(600, 25);
		la_customer.setLocation(25, 280);
		la_customer.setText(PersonData.customerList.get(customerNum1 - 1).toString());
		
		ta_product.setSize(500, 150);
		ta_product.setLocation(50, 310);
		StringBuilder sb = new StringBuilder("");
		for (Product productInfo : WareHouse.productList) {
			sb.append(productInfo.toString()+"\n");
		}
		ta_product.setText(sb.toString());
		
		ta_sujuList.setSize(500, 100);
		ta_sujuList.setLocation(50, 545);
		
		bu_check2.setSize(100, 25);
		bu_check2.setLocation(440, 470);
		
		bu_check2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_productCode.requestFocus();
				tf_productCode.selectAll();
				productCode1 = Integer.parseInt(tf_productCode.getText());
				
				if(productCode1<1 || productCode1> WareHouse.productList.size()){
					Dialogss("상품코드를 제대로 넣어주세요");
					la_stock.setText("현재 재고 = 0");
					stockCheck = false;
				}else{
					la_stock.setText("현재 재고 = "+ WareHouse.productList.get(productCode1 - 1).stock.getStockAmount());
					stockCheck = true;
				}
			}
		});

		bu_sujuinput.setSize(100, 25);
		bu_sujuinput.setLocation(440, 520);
		
		bu_sujuinput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(stockCheck){
					neededAmount1 = Integer.parseInt(tf_stockNum.getText());
					if (WareHouse.productList.get(productCode1 - 1).stock.getStockAmount() < neededAmount1) {
						Dialogss("재고가 부족합니다.");
					}else if(neededAmount1 <=0){
						Dialogss("0이상의 값을 넣어주세요");
					
					}else{
						discountRate1 = Double.parseDouble(tf_discountRate.getText());
						if (discountRate1 >= 100) {
							Dialogss("할인율 100미만의 값을 입력해 주세요.");
						}else{
							
							basket += customerNum1
									+ "\t"+"\t"
									+ productCode1
									+ "\t"+ "\t"
									+ neededAmount1
									+ "\t"+ "\t"
									+ WareHouse.productList.get(
											productCode1 - 1)
											.getProductPrice()
									* (100 - discountRate1) / 100 * neededAmount1
									+ "\n";
							total += WareHouse.productList.get(
									productCode1 - 1).getProductPrice()
									* (100 - discountRate1) / 100 * neededAmount1;
							
							int changeStock = WareHouse.productList.get(productCode1 - 1).stock.getStockAmount() - neededAmount1;
							WareHouse.productList.get(productCode1 - 1).stock.setStockAmount(changeStock);
							la_stock.setText("현재 재고 = "+ WareHouse.productList.get(productCode1 - 1).stock.getStockAmount());
							///////여기서 set가 되야됨
							ta_sujuList.setText(basket+"Total Price : " + total +"만원");
							sujuListCheck =true;
							//////
							obtainList.add(new ObtainList(neededAmount1, discountRate1,productCode1));
						}
					}
					
				}else Dialogss("재고를 확인해야만 등록할수있습니다.");
				
				
			}
		});
		
		bu_sujuRegistration.setSize(100, 25);
		bu_sujuRegistration.setLocation(50, 665);
		
		bu_sujuRegistration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sujuListCheck){
					obtain.add(enrollObtain());
					tempWh.BackUpSave();
					setVisible(false);
					dispose();
					SujuMain.f.setVisible(true);
					obtainList.clear();
				}else Dialogss("수주를 하나이상 입력해야합니다.");
			}
		});
		
		
		bu_sujuCancel.setSize(100, 25);
		bu_sujuCancel.setLocation(440, 665);
		
		bu_sujuCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWh.DataRestore();
				Dialogss("수주취소");
				setVisible(false);
				dispose();
				obtainList.clear();
				SujuMain.f.setVisible(true);
			}
		});
		
		la_productCode.setSize(50, 25);
		la_productCode.setLocation(50, 470);
		
		la_stock.setSize(130, 25);
		la_stock.setLocation(50, 495);
		
		la_discountRate.setSize(50, 25);
		la_discountRate.setLocation(50, 520);
		
		
		tf_stockNum.setSize(200, 25);
		tf_stockNum.setLocation(220, 495);
		
		tf_productCode.setSize(200, 25);
		tf_productCode.setLocation(220, 470);
		
		tf_discountRate.setSize(200, 25);
		tf_discountRate.setLocation(220, 520);
		
		this.add(la_customer);
		this.add(ta_product);
		this.add(bu_check2);
		this.add(la_productCode);
		this.add(la_stock);
		this.add(tf_productCode);
		this.add(tf_stockNum);
		this.add(bu_sujuinput);
		this.add(la_discountRate);
		this.add(tf_discountRate);
		this.add(bu_sujuCancel);
		this.add(bu_sujuRegistration);
		this.add(ta_sujuList);
	}

	
	public void Dialogss(String error){
		Dialog info = new Dialog(this,"팝업",true);
		info.setSize(300, 110);
		info.setLocation(50, 20);
		info.setLayout(null);
		Dimension size = info.getSize();
		
		Label msg = new Label(error);
		Button btn = new Button("확인");
		
		msg.setLocation(size.width/2-140, 30);
		msg.setSize(280, 30);
		
		btn.setLocation(size.width/2-50, 60);
		btn.setSize(100, 30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				info.setVisible(false);
				info.dispose();

			}
		});
		info.add(msg);
		info.add(btn);
		info.setVisible(true);
	}
	
	public Obtain enrollObtain() {
		Obtain obtain = new Obtain(i++, new Date(),PersonData.customerList.get(customerNum1 - 1));
		obtain.setObtainlist(obtainList);
		Dialogss("수주 등록완료.");
		return obtain;
	}

}
