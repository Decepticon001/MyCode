package cal;

import java.util.Stack;

/**
 * 表达式计算
 * 中缀表达式转换为后缀表达式，进行表达式运算
 */
public class Postfix {
    public static void main(String[] args) {
        String s1 = "3*(3+2)+3*7*2*(2+1)";
        //String s2 = "14+5*32*12+*+";
        StringBuilder s2 = ch(s1);
        System.out.println(s2);
        String reg = "[0-9]";
        /**
         * 扫面接收的字符串，数字直接入栈，遇到运算符，弹出前两个数字进行运算，并将结果压入栈
         *
         */
        Stack<Integer> s = new Stack<>();//创建一个栈用来保存数字
        for (int i = 0;i<s2.length();i++){
            String a = String.valueOf(s2.charAt(i));//扫描接收到的后缀表达式
            if (a.matches(reg)){
                s.push(Integer.valueOf(a));//如果扫描到的元素是数字直接压入栈中
            }else if (a.equals("+")){//如果是运算符则弹出栈顶俩个元素进行相应的运算再将结果压入栈中
                int v = s.pop()+s.pop();
                s.push(v);
            }else if (a.equals("-")){
                int v = s.pop() - s.pop();
                s.push(v);
            }else if (a.equals("*")){
                int v = s.pop() * s.pop();
                s.push(v);
            }else if (a.equals("/")){
                int v = s.pop()/s.pop();
                s.push(v);
            }
        }
        //最后获得栈顶元素即为结果
        int r = s.peek();
        System.out.println(r);
    }

    /**
     * 接收一个中缀表达式字符串转换为后缀表达式字符串并返回
     * @param str
     * @return
     */
    public static StringBuilder ch(String str){
       // Stack<String> s = new Stack();//s：用来保存输出的后缀表达式的栈
        StringBuilder stb = new StringBuilder();//输出字符串
        Stack<String> s1 = new Stack();//用来储存运算符的栈
        s1.push("#");//将运算符栈先压入“#”，防止之后在在弹出的时候调用peek（）会报空栈异常
        for(int i = 0;i<str.length();i++) {
            String a = String.valueOf(str.charAt(i));//扫描表达式每一个字符并转换为字符串类型
            if (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/")) {//判断是否是运算符
                if (s1.peek().equals("#")){//如果栈内没有其他运算符，直接压入栈
                    s1.push(a);
                }else if (s1.peek().equals("*")||s1.peek().equals("/")){
                    /*
                       如果栈顶运算符为“×”或者“/”，那么弹出运算符直到一个优先级低于本次扫描到的元素
                       或者栈内没有其他运算符，或者遇到一个作括号，并将弹出的元素依次保存到输出栈内
                     */
                    while (!s1.peek().equals("#")){
                        if (s1.peek().equals("(")){
                            break;
                        }
                        if (a.equals("+")||a.equals("-")){
                            String s3 = s1.pop();//s3表示从s1弹出的运算符
                            //s.push(s3);
                            stb.append(s3);
                        }else{
                            if(s1.peek().equals("+")||s1.equals("-")){
                                break;
                            }
                            String s3 = s1.pop();
                            //s.push(s3);
                            stb.append(s3);
                        }
                    }
                    s1.push(a);//将本次扫描到的运算符压入栈
                }else if (s1.peek().equals("+")||s1.peek().equals("-")){
                    if (a.equals("+")||a.equals("-")){
                        while (!s1.equals("#")){
                            if (s1.peek().equals("(")){
                                break;
                            }
                            String s3 = s1.pop();
                            //s.push(s3);
                            stb.append(s3);
                        }
                        s1.push(a);
                    }else {
                        s1.push(a);
                    }
                }else{
                    s1.push(a);
                }
            }else if (a.equals("(")){
                /*
                如果扫描到左括号，直接入运算符栈
                 */
                s1.push(a);
            }else if (a.equals(")")){
                /*
                如果扫描到右括号那么弹出运算符保存到输出栈直到遇到的第一个左括号
                 */
                while(!s1.peek().equals("(")){
                    String s2 = s1.pop();
                    //s.push(s2);
                    stb.append(s2);
                }
                s1.pop();
            }else{
                //s.push(a);
                stb.append(a);
            }
        }
        /*
            将运算符栈内其他运算符依次弹出压入输出栈内
         */
        while (!s1.peek().equals("#")){
            String f = s1.pop();
            //s.push(f);
            stb.append(f);
        }
        /*
        遍历输出栈，拼接成字符串并返回
         */
        /*String s5 = "";
        for (String s4:s){
            s5 += s4;
        }*/
        return stb;
    }
}
