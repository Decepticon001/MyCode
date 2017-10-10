package count;


import java.util.LinkedList;
import java.util.Queue;

public class BiTree {
    Node root;
    public BiTree(){
        root = null;
    }


   public void addValue(Node node,int data){
       if (root==null){
           root = new Node(data);
       }else{
           if(node.data>data){
               if(node.left==null){
                   node.left = new Node(data);
               }else{
                   addValue(node.left,data);
               }
           }else{
               if (node.right==null){
                   node.right = new Node(data);
               }else{
                   addValue(node.right,data);
               }
           }
       }
   }
   public void preOrder(Node node){
       if(node != null){
           System.out.print(node.data+" ");
           preOrder(node.left);
           preOrder(node.right);
       }


    }
    public void InOrder(Node node) {
        if (node != null) {
            InOrder(node.left);
            System.out.print(node.data+" ");
            InOrder(node.right);
        }
    }
    public void postOrder(Node node){
            if(node != null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data+" ");
            }
        }
    public void search(Node root,int a){
        if (root.data == a) {
                System.out.println("存在" + root.data);
            } else if (a > root.data) {
                root = root.right;
                if(root != null) {
                    search(root, a);
                }else{
                    System.out.println("不存在");
                }
            } else if (a < root.data) {
                root = root.left;
                if(root!=null) {
                    search(root, a);
                }else{
                    System.out.println("不存在");
                }
        }/*else{
                System.out.println("不存在");
        }*/
    }
    public void find(Node root ,int a,int b) {
        if (root != null) {
            if (root.data > a && root.data < b) {
                System.out.print(root.data+" ");
            }
            find(root.left, a, b);
            find(root.right, a, b);
        }
    }
    public void listAll(Node node) {
        Queue<Node> q = new LinkedList<Node>();
        /**
         * for(Node n:q){
         *      if(n被标记){
         *          System.out.print(n.data);
         *          q.poll;
         *          if(n.left!=null)
         *          q.add(n.left);
         *          if(n.right!=null)
         *          q.add(n.right);
         *      }else{
         *          break;
         *      }
         * }
         *
         */
    }
}
