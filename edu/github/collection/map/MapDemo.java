package edu.github.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {         
        Map<Integer, String> m = new HashMap<>();
        keySetDemo(m);//通过键获取到相应值
        entrySetDemo(m);//通过映射关系获取键和值
        valuesDemo(m);//直接获取值
    }

    private static void valuesDemo(Map<Integer, String> m) {
        m.put(66, "dingzhijun");
        m.put(66, "craze");
        m.put(65, "lisi");
        m.put(64, "zhangsang");
        Collection<String> con = m.values();
        Iterator<String> it = con.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void entrySetDemo(Map<Integer, String> m) {
        m.put(66, "dingzhijun");
        m.put(66, "craze");
        m.put(65, "lisi");
        m.put(64, "zhangsang");
        Set<Map.Entry<Integer, String>> me = m.entrySet();
        Iterator<Map.Entry<Integer, String>> io = me.iterator();// map.enrey()接口中的静态内部接口成员类
        while (io.hasNext()) {
            Map.Entry<Integer, String> en = io.next();
            System.out.println(en.getKey() + "----" + en.getValue());
        }
    }

    public static void keySetDemo(Map<Integer, String> m) {
        m.put(66, "dingzhijun");
        m.put(66, "craze");
        m.put(65, "lisi");
        m.put(64, "zhangsang");
        System.out.println(m.put(66, "wangwu"));//map.put()相同键时返回键前一个值
        System.out.println(m.get(66));
        Set<Integer> s = m.keySet();
        Iterator<Integer> it = s.iterator();
        while (it.hasNext()) {
            System.out.println(m.get(it.next()));
        }

    }
}
