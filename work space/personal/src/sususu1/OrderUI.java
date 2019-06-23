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
	int customerNum1;//1�� ���� ���� UI���� ����ϴ°� �Ϸ��ϸ� 1�� ���� ������ ������
	int productCode;
	int productCode1;
	int neededAmount;
	int neededAmount1;
	int total;
	double discountRate;
	double discountRate1;
	boolean stockCheck = false;
	boolean sujuListCheck = false;
	String basket = "����ȣ\t��ǰ�ڵ�\t�ֹ�����\t�ֹ�����[����]\n";

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
		ta_obtain = new TextArea("********************����������Ʈ**********************");
		ta_product = new TextArea("********************��ǰ��������Ʈ**********************");
		ta_sujuList = new TextArea("********************�����Է¸���Ʈ**********************");
		la_customerNum = new Label("����ȣ");
		la_customer = new Label();
		la_productCode = new Label("��ǰ�ڵ�");
		la_stock = new Label("���� ��� = ");
		la_discountRate = new Label("������");
		bu_check = new Button("Ȯ��");
		bu_check2 = new Button("���Ȯ��");
		bu_sujuinput = new Button("�Է�");
		bu_sujuRegistration = new Button("���ֵ��");
		bu_sujuCancel = new Button("�������");
		tf_customerNum = new TextField("����ȣ�� �Է��ϼ���");
		tf_productCode = new TextField("��ǰ�ڵ带 �Է��ϼ���");
		tf_stockNum = new TextField("�ֹ��� ������ �Է��ϼ���");
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
					Dialogss("�� ��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
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
					Dialogss("��ǰ�ڵ带 ����� �־��ּ���");
					la_stock.setText("���� ��� = 0");
					stockCheck = false;
				}else{
					la_stock.setText("���� ��� = "+ WareHouse.productList.get(productCode1 - 1).stock.getStockAmount());
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
						Dialogss("��� �����մϴ�.");
					}else if(neededAmount1 <=0){
						Dialogss("0�̻��� ���� �־��ּ���");
					
					}else{
						discountRate1 = Double.parseDouble(tf_discountRate.getText());
						if (discountRate1 >= 100) {
							Dialogss("������ 100�̸��� ���� �Է��� �ּ���.");
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
							la_stock.setText("���� ��� = "+ WareHouse.productList.get(productCode1 - 1).stock.getStockAmount());
							///////���⼭ set�� �Ǿߵ�
							ta_sujuList.setText(basket+"Total Price : " + total +"����");
							sujuListCheck =true;
							//////
							obtainList.add(new ObtainList(neededAmount1, discountRate1,productCode1));
						}
					}
					
				}else Dialogss("��� Ȯ���ؾ߸� ����Ҽ��ֽ��ϴ�.");
				
				
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
				}else Dialogss("���ָ� �ϳ��̻� �Է��ؾ��մϴ�.");
			}
		});
		
		
		bu_sujuCancel.setSize(100, 25);
		bu_sujuCancel.setLocation(440, 665);
		
		bu_sujuCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWh.DataRestore();
				Dialogss("�������");
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
		Dialog info = new Dialog(this,"�˾�",true);
		info.setSize(300, 110);
		info.setLocation(50, 20);
		info.setLayout(null);
		Dimension size = info.getSize();
		
		Label msg = new Label(error);
		Button btn = new Button("Ȯ��");
		
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
		Dialogss("���� ��ϿϷ�.");
		return obtain;
	}

}
