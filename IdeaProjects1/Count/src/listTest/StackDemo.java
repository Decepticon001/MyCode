package listTest;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        for (int i = 0 ; i < 10 ; i ++){
            s.push(i);
        }
        int r = s.pop()+s.pop();
        System.out.println(r);
        int c = s.peek();
        Stack<Integer> s2 = new Stack<>();
        //int d = s.pop();
        //System.out.println(d);
        while(s.peek()!=3){
            int f= s.pop();
            s2.push(f);
        }
        System.out.println("-----------------------");
        System.out.println(c);
        System.out.println("-----------------------");
        for (int a : s){
            System.out.println(a);
        }
        System.out.println("-----------------------");
        for (int a : s2){
            System.out.println(a);
        }
    }
}
