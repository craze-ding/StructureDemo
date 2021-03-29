package edu.github.collection.set.treeset;

import java.util.Iterator;
import java.util.TreeSet;

import edu.github.bean.Worker;


public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Worker> te = new TreeSet<Worker>();//泛型只能指定为引用数据类型,要存int基本数据类型就得用integr类对象!!
        te.add(new Worker("lisi", 20));
        te.add(new Worker("wangwu", 15));//Worker cannot be    cast to java.lang.Comparable也是就是说compar()没法比较
        te.add(new Worker("zhangsang", 20));
        te.add(new Worker("lisi", 13));
        Iterator<Worker> it=te.iterator();
        while(it.hasNext()){
            Worker wo=it.next();
            System.out.println(wo.getName()+"--worker"+wo.getAge());
        }
        
    }

}
