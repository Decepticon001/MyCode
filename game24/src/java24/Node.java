package java24;



public class Node {
    public RationalNumber v;
    public String str;

    public Node(RationalNumber v) {
        this.v = v;
        double k = this.v.toValue();
        this.str = String.valueOf(k);
    }
    public Node(RationalNumber v, String s) {
        this.v = v;
        this.str = s;
    }

    public String toString(){
        return this.str;
    }

    public Node calc(String op,Node b){
        RationalNumber v2 = new RationalNumber(0);
        String s = "";
        switch (op){
            case "+":{
                v2 =  this.v.add(b.v) ;
                s = this.str + "+"  + b.str;
                break;
            }
            case "-":{
                v2 =  this.v.sub(b.v);
                s = this.str + "-"  + b.str;
                break;
            }
            case "*":{
                v2 =  this.v.mul(b.v);
                s = this.str + "*"  + b.str;
                break;
            }
            case "/":{
                v2 =  this.v.mod(b.v) ;
                s = this.str + "/"  + b.str;
                break;
            }

        }
        return  new Node(v2,s);
    }
}
