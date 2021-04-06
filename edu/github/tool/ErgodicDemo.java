
package edu.github.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
* @program: StructureDemo - 副本
*
* @description: 演示高级for()遍历或迭代Array,单例集合
*
* @author: Craze
*
* @create: 2021-04-01 08:53
**/
public class ErgodicDemo {
    public static void main(String[] args) {
        ergodic1();
        ergodic2();
    }

    private static void ergodic2() {
        List<String> list=new ArrayList<>();
        list.add("ding");
        list.add("zhi");
        list.add("jun");
        list.add("craze");
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //有局限性，高级for()只用取·迭代。不适合用于对取到的元素进行操作。
        // for(String s:list){
            // System.out.println(s.toString());
        // }

    }
    /**
     * 问：可以使用高级for()遍历map集合吗？不能直接用，但是可以将map转换单列的set,就ok.
    **/
    private static void ergodic1() {
        Map<Integer,String> map=new HashMap<>();
        map.put(1, "ding");
        map.put(2, "zhi");
        map.put(3, "jun");
        map.put(4, "craze");
        Iterator<Entry<Integer,String>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> m=it.next();
            Integer in=m.getKey();
            String s=m.getValue();
            System.out.println(in+"---"+s);
        }
        for(Map.Entry<Integer,String> m:map.entrySet()){
            Integer in=m.getKey();
            String s=m.getValue();
            System.out.println(in+"--entryset--"+s);
        }
        for(Integer in:map.keySet()){
            String s=map.get(in);
            System.out.println(in+"--keyset-"+s);
        }
        for(String s:map.values()){            
            System.out.println(s);
        }
    }
}
