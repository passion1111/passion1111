package selfstructureimp;

//SingleLinkedListimp는 Node가 데이터를 지칭하는것이면서 동시에  링크드리스트의 대표인데
//이경우 데이터를 삭제하면 전이나 다음노드가 삭제한 노드를 가르킬경우 문제가 발생
//SinleLinkedListimp1에서 데이터를 가르키는부분을 header로 만들고 
//전체적인 데이터를LinkedListClass로 감싸주는부분만 다르게 구현
//요약하면 singlinkedlistimp1에서는 첫번쨰 노드가 삭제불가능이였는데 지금은 해결
import test.main;

public class SingleLinkedListImp2 {
	public static void main(String[] args) {
		LinkedList link=new LinkedList();
		link.append(1);
		link.append(2);
		link.append(3);
		link.append(4);
		link.append(5);
		link.append(6);
		link.retrieve();
		link.delte(1);
		link.retrieve();
		
	}

}

  class LinkedList{
	 Node header;
	private static class Node{
		int data;
		Node next=null;
	}
	LinkedList(){
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
}