/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-02 18:47:00
 */
package edu.github.collection.map.hashmap.linkedhashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LInkedHashMapDemo {
    public static void main(String[] args) {
    HashMap<Integer,String> hm=new LinkedHashMap<Integer,String>();
    hm.put(7,"craze");  //怎么输入就怎么输出 
    hm.put(12,"zhnagsang");   
    hm.put(9,"wangwu");   
    hm.put(10,"lisi");
    Iterator<Map.Entry<Integer,String>> it=hm.entrySet().iterator();
    while(it.hasNext()){
        Map.Entry<Integer,String> me=it.next();
        System.out.println(me.getKey()+"---"+me.getValue());
    }  
}
}
