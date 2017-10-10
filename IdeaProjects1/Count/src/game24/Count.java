package game24;

import java.util.*;

public class Count {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入四个数字");*/
        /*for (int i = 0;i < 4;i++){
            int a = scanner.nextInt();
            list.add(a);
        }*/
        list.add(6);
        list.add(6);
        list.add(6);
        list.add(6);
        count(list);
    }

    public static void count(List<Integer> list){
        List<Num> ls = find(list);
        Iterator<Num> it = ls.iterator();
        while(it.hasNext()){
            Num a = it.next();
            int i = 0;
            for (int r : list){
                if (r == a.getA()||r == a.getB()){
                    list.remove(i);
                }
                i++;
            }

            for (int u : count(a.getA(),a.getB())){
                list.add(u);
                if (list.size()==2){
                    List<Integer> lr = count(list.indexOf(0),list.indexOf(1));
                    if (lr.contains(24)){
                        System.out.println(1);
                    }else {
                        list.remove(list.indexOf(list.size()-1));
                        System.out.println(0);
                    }
                }else {
                    ls.clear();
                    count(list);
                }
            }
        }
    }
    public static List<Num> find(List<Integer> list){
        List<Num> ls = new ArrayList<>();
        int a;
        int b;
        for(int k = 0;k < list.size(); k++) {
            for (int i = 0; i < list.size(); i++) {
                if (k == i){
                    continue;
                }
                a = list.indexOf(k);
                b = list.indexOf(i);
                Num n = new Num(a,b);
                ls.add(n);
            }
        }
        return ls;
    }
    public static List<Integer> count(int a,int b){
        List<Integer> ls = new ArrayList<>();
        ls.add(a+b);
        ls.add(a-b);
        ls.add(b-a);
        ls.add(a*b);
        if (b!=0) {
            ls.add(a/b);
        }
        if (a!=0){
            ls.add(b/a);
        }
        return ls;
    }
}

