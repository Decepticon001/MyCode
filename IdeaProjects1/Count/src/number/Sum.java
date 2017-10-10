package number;

public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }
    public static int sum(int a) {
        if(a == 1){
            return 1;
        }else{
            return a+sum(a-1);
        }
    }
}
