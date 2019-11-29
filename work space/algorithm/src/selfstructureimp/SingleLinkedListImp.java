package selfstructureimp;
//현재 짜는 알고리즘의 문제 첫번쨰 노드는 삭제가 불가능 

import test.main;

public class SingleLinkedListImp {
//class Node있어야함  data를 넣어야함  일단 int로 구현 원래는 objet
// Node next=null
	public static void main(String[] args) {
		SingleLinkedListImp test=new SingleLinkedListImp();
		SingleLinkedListImp.Node head=test.new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delte(2);
		head.retrieve();
		head.delte(3);
		head.retrieve();
	}


private class Node{
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
	void delte(int d) {
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
			System.out.printf(n.data+"->");
			n=n.next; 
		}
		System.out.println(n.data);
	}
}
}
