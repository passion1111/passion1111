
package personal2_practice_oop2;


public class Main1 {

    public static void main(String[] args) {
           BinaryTree bt = new BinaryTree();

           Node n7 = bt.makeBT(null, "D", null);
           Node n6 = bt.makeBT(null, "C", null);
           Node n5 = bt.makeBT(null, "B", null);
           Node n4 = bt.makeBT(null, "A", null);
           Node n3 = bt.makeBT(n6, "/", n7);
           Node n2 = bt.makeBT(n4, "*", n5);
           Node n1 = bt.makeBT(n2, "-", n3);

           System.out.print("preorder : ");
           bt.preorder(n1);
           System.out.println();

           System.out.print("inorder : ");
           bt.inorder(n1);
           System.out.println();

           System.out.print("postorder : ");
           bt.postorder(n1);
           System.out.println();
    }
}
