package selfstructureimp;


public class LinkedListReverse {
	private static   Node KthToLast(Node first,int k) {
		Node n=first;
		int total=1;
		while(n.next!=null) {
			total++;
			n=n.next;
		}
		n=first;
		for(int i=1;i<total-k+1;i++) {
			n=n.next;
		}
		return n;
		}
		 Node header;
		private static class Node{
			int data;
			Node next=null;
		}
		LinkedListReverse(){
			header=new Node();
		}
		void append(int d) {
			Node end=new Node();
			end.data=d;
			Node n=header;
			while(n.next!=null) {
				n=n.next;
			}
			n.next=end;
		}
		void delte(int d) {
			Node n=header;
			while(n.next!=null) {
				if(n.next.data==d) {
					n.next=n.next.next;
				}else {
					n=n.next;
				}
			}
		}
		void retrieve() {
			Node n=header.next;
			while(n.next!=null) {
				System.out.printf(n.data+"->");
				n=n.next; 
			}
			System.out.println(n.data);
		}

public static void main(String[] args) {
	LinkedListReverse list=new LinkedListReverse();
	list.append(2);
	list.append(5);
	int k=2;
	Node kth=KthToLast(list, k);
}
}

	

