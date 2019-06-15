package personal2_practice_oop2;

public class Node{
       protected Node left;
       private Object data;
       protected Node right;

       public Node(Object data) {
              left =null;
              right =null;
              this.data = data;
       }

       public Object getData(){
              return this.data;
       }
}


