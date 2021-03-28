package edu.github.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import edu.github.bin.Student;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Student,String> hm=new HashMap<Student,String>();
        method(hm);
    }

    private static void method(HashMap<Student, String> hm) {
        hm.put(new Student("lisi", 22), "北京");
        hm.put(new Student("zhangsang", 32), "上海");
        hm.put(new Student("wangwu", 45), "广州");
        hm.put(new Student("craze", 18), "成都");
        hm.put(new Student("zhangsang", 32), "深圳");//hashcode(),equals()判断依据,equals()返回真不存;hashmap保证键唯一,前面的value被覆盖
        Set<Student> s=hm.keySet();//取得student类的键set
        Iterator<Student> it=s.iterator();
        while(it.hasNext()){
            Student stu=it.next();
            System.out.println(stu.getName()+":"+stu.getAge()+"---"+hm.get(stu));//hash无序
        }
    }
   
  
}
