package edu.github.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {
        List l=new ArrayList();
        // show(l);
        //read(l);
        haha(l);        
    }

    private static void haha(List l) {
        l.add("ding");
        l.add("zhi");
        l.add("jun");
        ListIterator it=l.listIterator();
        while(it.hasNext()){
            Object obj=it.next();
            if(obj.equals("zhi")){
                it.set("craze");
            }
            //System.out.println(it.next());
        }
        System.out.println(it.hasNext());
        System.out.println(it.hasPrevious());
        System.out.println(l);
    }

    private static void read(List l) {
        l.add("ding");
        l.add("zhi");
        l.add("jun");
        Iterator it=l.iterator();
        while(it.hasNext()){
            //System.out.println(it.next());

        }
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }

    private static void show(List l) {
        l.add("ding");
        l.add("zhi");
        l.add("jun");
        System.out.println(l.toString());
        l.add(2,"craze");
        System.out.println(l.toString());
        l.remove(2);
        System.out.println(l.toString());
        l.set(0, "haha");
        System.out.println(l.toString()); 
    }
}
