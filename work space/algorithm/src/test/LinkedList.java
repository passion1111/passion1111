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
		//��ũ�帮��Ʈ 
		//����
		
		//�迭�� ���������� �̾�������. �׸��� ������. 
		
		//��ũ�帮��Ʈ��  ������带 ����Ű�⋚���� ���� ������ ����. 
		
		//�˻��� �����ɸ�������.
		
		
		//��ũ�帮��Ʈ �ܹ��� ������� ����. 
		
		//�ܹ��� ��ũ�帮��Ʈ class node   , int node , node Next=null
		
	
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
