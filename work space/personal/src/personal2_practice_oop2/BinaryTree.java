package personal2_practice_oop2;


public class BinaryTree {

	 private Node root;

     public BinaryTree() {
            this.root = null;
     }

     public Node makeBT(Node bt1, Object data, Node bt2){

            Node newNode = new Node(data);
            newNode.left = bt1;
            newNode.right =bt2;

            return newNode;
     }

     public void preorder(Node root){
            if(root != null){
                   System.out.print(root.getData());
                   preorder(root.left);
                   preorder(root.right);
            }
     }

     public void inorder(Node root){
            if(root != null){
                   inorder(root.left);
                   System.out.print(root.getData());
                   inorder(root.right);
            }
     }

     public void postorder(Node root){
            if(root != null){
                   postorder(root.left);
                   postorder(root.right);
                   System.out.print(root.getData());
            }
     }

}

