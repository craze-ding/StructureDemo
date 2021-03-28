package edu.github.map.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import edu.github.bin.Student;
import edu.github.compartor.CompartorByname;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Student,String> tm=new TreeMap<Student,String>(new CompartorByname());
        method(tm);
    }
    private static void method(TreeMap<Student,String> tm ) {
        tm.put(new Student("blisi", 22), "北京");
        tm.put(new Student("azhangsang", 32), "上海");
        tm.put(new Student("kwangwu", 45), "广州");
        tm.put(new Student("craze", 18), "成都");
        tm.put(new Student("rzhangsang", 32), "深圳");//hashcode(),equals()判断依据,equals()返回真不存;hashmap保证键唯一,前面的value被覆盖
        Set<Entry<Student,String>> s=tm.entrySet();
        Iterator<Entry<Student,String>> it=s.iterator();
        while(it.hasNext()){
            Map.Entry<Student,String> stu=it.next();
            System.out.println(stu.getKey()+":"+stu.getValue());//hash无序
        }
    
    }
}
