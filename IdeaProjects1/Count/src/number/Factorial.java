package number;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(6));
        System.out.println(factorial2(6));
    }
    public static int factorial(int a){
        int f=1;
        for (int i = 1;i<=a;i++){
            f*=i;
        }
        return f;
    }
    public static int factorial2(int a){
        if(a==1){
            return 1;
        }else{
            return factorial2(a-1)*a;
        }
    }
}
