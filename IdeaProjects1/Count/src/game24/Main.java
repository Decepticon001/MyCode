package game24;

import game2401.RationalNumber;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // write your code here
        //单元测试
        Node[] arr = new Node[]{
                new Node(new RationalNumber(1)),
                new Node(new RationalNumber(2)),
                new Node(new RationalNumber(3)),
                new Node(new RationalNumber(4)),
        };

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }

        Node node1 = new Node(new RationalNumber(3));
        Node node2 = node1.calc("+", new Node(new RationalNumber(4)));
        System.out.println(node2);


        search_24(new Node[]{new Node(new RationalNumber(3)), new Node(new RationalNumber(8)),
                new Node(new RationalNumber(3)), new Node(new RationalNumber(4))});
    }

    static String[] op_list = new String[]{"+", "-", "*", "/"};

    static void search_24(Node[] arr) {

        int len = arr.length;
        if (len == 0) {
            System.out.println("empty array !");
            return;
        }
        if (len == 1) {
//            System.out.println(arr[0].v);
//            System.out.println(arr[0].str);
            if (arr[0].v.toValue() == 24.0) {
                System.out.println("find result:" + arr[0].str);
            }
            return;
        }
        List<Node[]> result_list = select_all_two(arr);

        for (Node[] arr2 : result_list) {
            for (int i = 0; i < op_list.length; i++) {

                String op = op_list[i];
                Node node2 = arr2[0].calc(op, arr2[1]);
                //Array.a
                //node2

                Node[] new_arr2 = concat(new Node[]{node2}, slice(arr2, 2));

                search_24(new_arr2);

            }
        }


    }


    public static Node[] slice(Node[] arr, int start) {

        Node[] new_result = new Node[arr.length - start];
        for (int i = start; i < arr.length; i++) {
            new_result[i - start] = arr[i];

        }
        return new_result;
    }

    public static Node[] concat(Node[] a, Node[] b) {
        int aLen = a.length;
        int bLen = b.length;
        Node[] c = new Node[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }


    static void debug_node_select(List<Node[]> result) {
        System.out.println("==");
        System.out.println("total:" + result.size());

        for (Node[] node_list : result) {
            printNodeList(node_list);
        }
    }

    public static void printNodeList(Node[] arr) {
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static List<Node[]> select_all_two(Node[] arr) {

        /**
         * 1,2,3,4
         * [
         * (1,2, 3,4),
         * (1,3, 2,4),
         * ]
         */

        List<Node[]> result = new ArrayList<>();
        if (arr.length <= 2) {
            result.add(arr.clone());
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                Node[] nodes = new Node[arr.length];
                nodes[0] = arr[i];
                nodes[1] = arr[j];
                break_label:
                for (int k = 0; k < arr.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    nodes[2] = arr[k];
                    if (arr.length < 4) {
                        result.add(nodes.clone());
                        break break_label;
                    }
                    for (int k2 = 0; k2 < arr.length; k2++) {
                        if (k2 == i || k2 == j || k2 == k) {
                            continue;
                        }
                        nodes[3] = arr[k2];
                        result.add(nodes.clone());
                    }
                }


            }
        }

        return result;


    }
}
