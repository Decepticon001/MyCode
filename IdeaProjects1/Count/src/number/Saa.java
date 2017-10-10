package number;

public class Saa {
    public static void main(String[] args) {
        int a = count(4);
        System.out.println(a);
        System.out.println(count2(4));
        /*for (int i = 1;i<=10;i++){
            System.out.println(count(i));
        }*/
    }
    public static int count(int i) {
        if(i == 1 || i == 2){
            return 1;
        }else{
            return count(i-1)+count(i-2);
        }
    }
    public static int count2(int a){
        int x = 1;
        int y = 1;
        int sum = 0;
        if(a<=3){
            return 1;
        }else {
        for(int i = 0; i<a-3;i++){
            int s = y;
            y = x + y;
            x = s;
            sum = s + y;
            }
        }
        return sum;
    }
}
