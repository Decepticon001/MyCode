package number;

import java.util.Arrays;
import java.util.Random;

public class Number {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int N = 10000000;
        int[] arr = new int[N];
        int j = 1;
        for (int i = 0; i<N;i++){
            arr[i] = j;
            j++;
        }
        int c = 0;
        int[] arrs = new int[N];
        String s = Arrays.toString(arr);
        System.out.println(s);
        boolean[] b = new boolean[N];
        //System.out.println(b[1]);
        for(int a = 0;a<N;a++){
            int index = (int)(Math.random()*N);
            c++;
            if(!b[index]) {
                b[index] = true;
                arrs[a] = arr[index];

            }else{
                a--;
                continue;
            }

        }
        String s1 = Arrays.toString(arrs);
        System.out.println(s1);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println(time);
        System.out.println(1.0*c/N);
    }
}
