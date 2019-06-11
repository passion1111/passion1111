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
//            System.out.println("= 접근시간테스트 ="); 
//            System.out.println("ArrayList :"+access(al));  //대량의 데이터추가시간이 1mil바게 안걸림.
//            System.out.println("LinkedList :"+access(ll));  //추가시간은 어레이리스트보다 오래걸림
//	  }
//
//      public stxatic void add(List list) { //어레이리스트와 링크드리스트를 다 담기 위해서 list타입으로담음.
//            for(int i=0; i<100000;i++) list.add(i+""); //10만개의 데이터생성
//      } 
//
//      public static long access(List list) { 
//            long start = System.currentTimeMillis(); //현재시스템이 가지고있는 시간을 가지고옴
//            for(int i=0; i<10000;i++) list.get(i); 
//            long end = System.currentTimeMillis();   //작업후의 시간 가지고 옮
//            return end - start;  //시간을 뺴서 걸린시간을 알아봄.
//      } 
//}