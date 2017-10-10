package expression;

import java.util.Scanner;
import java.util.Stack;

public class Expression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<Character> number = new Stack<Character>();
        Stack<Character> oper = new Stack<Character>();
        for (int i = 0;i < s.length();i++){
            char a = (char)s.indexOf(i);
            if (String.valueOf(a).matches("[0-9]")){
                number.push(a);
            }
            if(String.valueOf(a).matches("[+,-,*,/]")){
                if (oper.isEmpty()){
                    oper.push(a);
                //}else if(oper.peek().compareTo(a)){

                }
            }
        }
    }
}
