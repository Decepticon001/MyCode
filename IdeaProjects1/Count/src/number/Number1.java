package number;

import java.util.Arrays;

public class Number1 {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int N = 10000000;
        int c = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        String s = Arrays.toString(arr);
        System.out.println(s);
        for (int j = 0; j < N; j++) {
            int index = (int) (Math.random() * N);
            int a = arr[j];
            arr[j] = arr[index];
            arr[index] = a;
            c++;
        }
        String s1 = Arrays.toString(arr);
        System.out.println(s1);
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println(time);
        System.out.println(1.0*c/N);
    }
}
