package count;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,7,3,5,3,9,2,5,2,4,3,6,2,9,3,5,3,9,2,8,0,9,2,3,7,9,6,3,8,7};
        BiTree bt = new BiTree();

        for (int i = 0;i<a.length;i++){
            bt.addValue(bt.root,a[i]);
        }
       /* bt.preOrder(bt.root);
        System.out.println();*/
        bt.InOrder(bt.root);
        System.out.println();
       /* bt.postOrder(bt.root);*/
        System.out.println();
        bt.search(bt.root,4);
        bt.find(bt.root,1,5);
        System.out.println();
        bt.listAll(bt.root);
    }
}
