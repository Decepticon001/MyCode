package listTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.remove(1);
        list.add(3);
        list.add(6);
        System.out.println(list.contains(4));
        System.out.println(list.get(1));
        System.out.println(list.size());
        list.set(1,8);
        list.clear();

        for(int a:list){
            System.out.println(a);
        }
        List<Integer> lst = new LinkedList<Integer>();
        lst.add(6);
        lst.add(5);
        lst.add(1);
        lst.add(4);
        lst.add(2);
        Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()){
            if(itr.next()%2 == 0){
                itr.remove();
            }
        }
        for(int v:lst){

            System.out.println(v);
        }

    }
}
