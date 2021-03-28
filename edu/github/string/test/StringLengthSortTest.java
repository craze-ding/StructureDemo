package edu.github.string.test;

import java.util.Iterator;
import java.util.TreeSet;

import edu.github.compartor.CompartorByString;

public class StringLengthSortTest {
    public static void main(String[] args) {
        //字符串自然排序我们不需要,我们构造一个比较器.
        TreeSet t=new TreeSet(new CompartorByString());
        t.add("ding");
        t.add("craze");
        t.add("harris");
        t.add("jun");
        t.add("ahi");
        t.add("hahaw12");
        for(Iterator it=t.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}
    





