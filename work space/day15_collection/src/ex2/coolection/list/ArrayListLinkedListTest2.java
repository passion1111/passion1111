//package ex2.coolection.list;
//import java.util.*; 
//
//public class ArrayListLinkedListTest2 { 
//      public static void main(String args[]) { 
//            ArrayList al = new ArrayList(1000000); 
//            LinkedList ll = new LinkedList(); 
//	       add(al);
//            add(ll);
//
//            System.out.println("= ���ٽð��׽�Ʈ ="); 
//            System.out.println("ArrayList :"+access(al));  //�뷮�� �������߰��ð��� 1mil�ٰ� �Ȱɸ�.
//            System.out.println("LinkedList :"+access(ll));  //�߰��ð��� ��̸���Ʈ���� �����ɸ�
//	  }
//
//      public stxatic void add(List list) { //��̸���Ʈ�� ��ũ�帮��Ʈ�� �� ��� ���ؼ� listŸ�����δ���.
//            for(int i=0; i<100000;i++) list.add(i+""); //10������ �����ͻ���
//      } 
//
//      public static long access(List list) { 
//            long start = System.currentTimeMillis(); //����ý����� �������ִ� �ð��� �������
//            for(int i=0; i<10000;i++) list.get(i); 
//            long end = System.currentTimeMillis();   //�۾����� �ð� ������ ��
//            return end - start;  //�ð��� ���� �ɸ��ð��� �˾ƺ�.
//      } 
//}