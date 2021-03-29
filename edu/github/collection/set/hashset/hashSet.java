package edu.github.collection.set.hashset;

import java.util.HashSet;
import java.util.Iterator;

import edu.github.bin.Persion;

// import java.util.ArrayList;

public class hashSet {
    public static void main(String[] args) {
       /*  ArrayList arr=new ArrayList<>();
        arr.add(new Persion("ding", 12));
        arr.add(new Persion("zhi", 13));
        arr.add(new Persion("jun", 14));
        arr.add(new Persion("craze", 15)); */
        HashSet<Persion> ha=new HashSet<>();
                
        ha.add(new Persion("ding",21));
        ha.add(new Persion("zhi",22));
        ha.add(new Persion("jun",23));
        ha.add(new Persion("ding",21));
        Iterator<Persion> it=ha.iterator();
        while(it.hasNext()){
            Persion p=it.next();
            System.out.println(p.getName()+"---"+p.getAge());
        }        
    }
}
