package edu.github.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> coll=new ArrayList<>();
        demo(coll);
    }

    private static void demo(Collection<String> coll) {
        coll.add("ding");
        coll.add("zhi");
        coll.add("jun");
        System.out.println(coll);
        /* coll.remove("zhi");
        System.out.println(coll);
        coll.clear();
        System.out.println(coll); */
        for(Iterator<String> it=coll.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}
