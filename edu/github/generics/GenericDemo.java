package edu.github.generics;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        arr.add("lisi");
        arr.add("zhangsang");
        arr.add("wangwu");
        arr.add("craze");
        //arr.add(2);
        Iterator<String> it=arr.iterator();
        while(it.hasNext()){
            String str=it.next();
            System.out.println(str);
        }
    }
}
