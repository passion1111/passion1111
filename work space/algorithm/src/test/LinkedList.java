package test;

import org.junit.Test;

import junit.framework.Assert;

public class LinkedList {	
			
	class Node{
		int data;
		Node next=null;
		Node(int d){
			this.data=d;
		}
		void append(int d) {
			Node end=new Node(d);
			Node n=this;
			while(n.next!=null) {
				n=n.next;
			}
			n.next=end;
		}
		
		void delete(int d) {
			Node n=this;
			while(n.next!=null) {
				if(n.next.data==d) {
					n.next=n.next.next;
				}else {
					n=n.next;
				}
			}
		}
		void retrieve() {
			Node n=this;
			while(n.next!=null) {
				System.out.print(n.data+"->");
				n=n.next;
			}
		System.out.println(n.data );
		}
		
	}
		//링크드리스트 
		//다음
		
		//배열은 물리적으로 이어져있음. 그리고 동적임. 
		
		//링크드리스트는  다음노드를 가르키기떄문에 삽입 삭제가 쉬움. 
		
		//검색은 오래걸릴수있음.
		
		
		//링크드리스트 단방향 양방향이 있음. 
		
		//단방향 링크드리스트 class node   , int node , node Next=null
		
	
	@Test
	public void linkedlisttest() {
		Node head=new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.append(5);
		head.retrieve();
		head.delete(3);
		head.retrieve();
	}
	
	
}
