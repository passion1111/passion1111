package selfcheck;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter {
Deque<Integer> dq;
	public RecentCounter() {
		dq=new ArrayDeque<Integer>();
	}
	public int ping(int t) {
		int v=t-3000;
		while(!dq.isEmpty()&&dq.peekFirst()<v) {
			System.out.println(dq.pollFirst());
//			dq.pollFirst();
		}
		dq.offerLast(t);
		return dq.size();
	}
	
	public static void main(String[] args) {
		RecentCounter rs=new RecentCounter();
		int size=rs.ping(1000);
		System.out.println(size);
		System.out.println(rs.ping(3000));
		rs.dq.add(1000);
		rs.dq.add(4000);
		rs.dq.add(4000);
		System.out.println(rs.ping(5000));
		System.out.println(rs.ping(3000));
		System.out.println(rs.dq.toString());
	}
}
