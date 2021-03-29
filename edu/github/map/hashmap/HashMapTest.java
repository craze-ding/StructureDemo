package edu.github.map.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import edu.github.bin.Student;

public class HashMapTest {
    public static void main(String[] args) {
        Set<Student> ha=CraetSet();
        CreatMap(ha);
    }

    private static Set<Student> CraetSet() {
        Set<Student> ha=new HashSet<>();
         
        ha.add(new Student("ding",21));
        ha.add(new Student("zhi",22));
        ha.add(new Student("jun",23));
        ha.add(new Student("ding",21));
        // Iterator it=ha.iterator();
        // while(it.hasNext()){
            // Persion p=(Persion)it.next();
            // System.out.println(p.getName()+"---"+p.getAge());
        // }
        return ha;        
    }

    private static void CreatMap(Set<Student> ha) {
        Map<String,Set<Student>> map=new HashMap<String,Set<Student>>();
        map.put("craze", ha);
        Iterator<Map.Entry<String,Set<Student>>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Set<Student>> me=it.next();
            Iterator<Student> se=me.getValue().iterator();
            while(se.hasNext()){
                Student stu=se.next();
                System.out.println(stu.getName()+"("+stu.getAge()+")");
            }
        }

    }
    
}
