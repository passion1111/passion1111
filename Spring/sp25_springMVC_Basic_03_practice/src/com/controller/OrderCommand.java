package com.controller;

import java.util.List;
import com.model.OrderItem;

public class OrderCommand {
	private List<OrderItem> orderItem;

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
	//ADD 3건
	//public void TEST(){
	//	orderItem.add(new OrderItem())
	//}
	/*
	 총 주문 3건이 경우 만들어지는 데이터 
	  
	 주문1건 
	 orderItem[0].itemid
	 orderItem[0].number
	 orderItem[0].remark
	 
	 주문1건 추가
	 orderItem[1].itemid
	 orderItem[1].number
	 orderItem[1].remark
	 
	 
	 주문1건 추가
	 orderItem[2].itemid
	 orderItem[2].number
	 orderItem[2].remark
	*/
}
