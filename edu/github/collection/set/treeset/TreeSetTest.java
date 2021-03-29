package edu.github.collection.set.treeset;

import java.util.Iterator;
import java.util.TreeSet;

import edu.github.bin.Persion;
import edu.github.compartor.CompartorByname;

public class TreeSetTest {   

    /**
     * 比较器(集合有比较功能)和对象有比较功能以比较器为主!
     * 开发中以定义一个类实现compartor比较器
     * @param args
     */
    public static void main(String[] args) {
       TreeSet<Persion> t=new TreeSet<Persion>(new CompartorByname());
       t.add(new Persion("lisi", 20));
       t.add(new Persion("wangwu", 15));
       t.add(new Persion("zhangsang", 18));
       t.add(new Persion("lisi", 13));
       for(Iterator<Persion> it=t.iterator();it.hasNext();){
           Persion p=it.next();
           System.out.println(p.getName()+"---"+p.getAge());
       }
    }  
    
}
