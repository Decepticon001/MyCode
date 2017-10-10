package expression;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< 9; i++){
            list.add(i);
        }
        int b = list.indexOf(0)+list.indexOf(1);
        System.out.println(b);
        list.set(0,9);
        System.out.println(list.indexOf(1));
        list.remove(1);
        for (int a : list){
            System.out.println(a);
        }

    }
}
