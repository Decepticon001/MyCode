package test;



public class Test1 {
    public static void main(String[] args) {
        int b = 6;
        int d = 4;
        int c = 0;
        lableA:
        for (int i = 1 ; i <= d ; i++){
            for (int k = 1; k <= b ; k++){
                if (b*i == d*k){
                    //fz = (a*i) + (c*k);
                    //fm = b*i;
                    c = b*i;
                    break lableA;
                }
            }
        }
        System.out.println(c);
    }
}
