package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.OrderItem;


@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	//GET , POST 나누어서 처리하는 method
	
	//화면보여주기 (GET)
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		return "order/OrderForm";
		
		//WEB-INF/view/order/OrderForm.jsp > view
	}
	
	//데이터 처리 (POST)
	@RequestMapping(method=RequestMethod.POST)
	public String submit(OrderCommand orderCommand){
		
//		System.out.println("orderCommand : " + orderCommand.toString());
//		System.out.println("orderCommand : " + orderCommand.getOrderItem().size());
//		
//		mav.sety
//		//검증하기
//		List<OrderItem> items = orderCommand.getOrderItem();
//		for(OrderItem item : items){
//			System.out.println(item.getItemid() + " / " + item.getNumber());
//		}
		//
		
		return "order/OrderCommitted";
		
		//WEB-INF/view/order/OrderCommitted.jsp > view
		//parameter 객체는 return view에서 사용가능
		//단 : view > orderCommand
	}
	
}






