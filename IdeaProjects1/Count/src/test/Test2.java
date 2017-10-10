package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class Test2 {
    public static void main(String[] args) {

        long  a = 1l;
        BigDecimal bd = new BigDecimal(a);
        System.out.println(bd);
        for (int i = 1; i<=1000; i++){
            bd = bd.multiply(new BigDecimal(i));
        }

        System.out.println(bd);
    }
}
