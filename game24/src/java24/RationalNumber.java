package java24;

public class RationalNumber {
    private int a;
    private int b;
    private String str;
    public RationalNumber(int a){
        this(a,1);
    }
    public RationalNumber(int a, int b){
        int f = lcd(a,b);
        if (f>1){
            a=a/f;
            b=b/f;
        }
        this.a = a;
        this.b = b;

        this.str = a +"/"+b;
    }

    @Override
    public String toString() {
        return str;
    }

    public double toValue(){
        return 1.0*a/b;
    }

    public RationalNumber add(RationalNumber r){
        int fz = 0;
        int fm = 0;
        String s1 ;
        /*System.out.println("r:"+this.str);
        System.out.println("r:"+this.str.charAt(0));
        System.out.println("r1:"+r.str);
        System.out.println("r1:"+Integer.valueOf(r.str.charAt(0)));*/
        int a = this.a;
        int b = this.b;
        int c = r.a;
        int d = r.b;
        lableA:
        for (int i = 1 ; i <= d ; i++){
            for (int k = 1; k <= b ; k++){
                if (b*i == d*k){
                    //System.out.println("a="+a);
                    //System.out.println("c="+c);
                   fz = (a*i) + (c*k);
                   fm = b*i;
                   break lableA;
                }
            }
        }

        return new RationalNumber(fz,fm);
    }
    public static int lcd(int a,int b){
        int c = Math.min(a,b);
        for (int i = c;i>0;i--){
            if(a%i==0&&b%i==0){
                return i;
            }
        }
        return 1;
    }

    public RationalNumber sub(RationalNumber r){
        int fz = 0;
        int fm = 0;
        int a = this.a;
        int b = this.b;
        int c = r.a;
        int d = r.b;
        lableA:
        for (int i = 1 ; i <= d ; i++){
            for (int k = 1; k <= b ; k++){
                if (b*i == d*k){
                    //System.out.println("a="+a);
                   // System.out.println("c="+c);
                    fz = (a*i) - (c*k);
                    fm = b*i;
                    break lableA;
                }
            }
        }
        return new RationalNumber(fz,fm);
    }

    public RationalNumber mul(RationalNumber r){
        int fz;
        int fm;
        int a = this.a;
        int b = this.b;
        int c = r.a;
        int d = r.b;
        fz = a*c;
        fm = b*d;
        return new RationalNumber(fz,fm);
    }

    public RationalNumber mod(RationalNumber r){
        int fz;
        int fm;
        int a = this.a;
        int b = this.b;
        int c = r.a;
        int d = r.b;
        fz = a*d;
        fm = b*c;
        return new RationalNumber(fz,fm);
    }
}
