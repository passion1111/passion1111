package selfstructureimp;


public class LinkedListQuestion1 {
//정렬돼있지않은 링크드리스트의 중복되는 값 제거  
//	단 ,버퍼사용X
//3->2->1->2->4 
//버퍼를 사용한다면  HashSet사용 
//hashset의 next이용 값 있을경우 제거하고 앞뒤노드 연결해주면 됨 
//그렇게되면 3 2 1 4 이렇게 출력되고 공간복잡도는 O(n)
//시간복잡도 또한 한번만 검색하니까 O(n)

//버퍼라는애가없으면 포인터로 해결 비교값 n과  비교할 대상 R 
//R은 n을 제외하고 값들을 중복값 지우기 시작
	
	
	//공간은 O(1) 시간복잡도는 O(n^2) 
	public static void main(String[] args) {
		LinkedListQuestion1 lq=new LinkedListQuestion1();
		LinkedListQuestion1.LinkedList ll=lq.new LinkedList();
		ll.append(2);
		ll.append(1);
		ll.append(3);
		ll.append(5);
		ll.append(4);
		ll.append(2);
		ll.append(1);
		ll.append(1);
		ll.append(1);
		ll.retrieve();
		ll.remoceDups();
		ll.retrieve();
		
	}
	
	private static class Node{
		int data;
		Node next=null;
	}
	 class LinkedList{
		 Node header;
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
		void remoceDups() {
			Node n=header;
			while(n!=null &&n.next!=null) {
				Node r=n;
				while(r.next!=null) {
					if(n.data==r.next.data) {
						r.next=r.next.next;//
					}else {
						r=r.next;
					}
				}
				n=n.next;
			}
		}
	}

}
