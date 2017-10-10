package listTest;

import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        String s = "12132431qda2312fsdfs121231weww";
        Stack<String> ss = new Stack<>();
        Stack<String> ss1 = new Stack<>();
        for (int i = 0; i < s.length();i++){
            String s3 = String.valueOf(s.charAt(i));
            if (s3.matches("[a-z]")){
                ss.push(s3);
            }else {
                ss1.push(s3);
            }
        }
        for (String d:ss){
            System.out.print(d);
        }
        System.out.println("--------------");
        for (String e:ss1){
            System.out.print(e);
        }
     }
}
