package edu.github.map.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {

        String str = "aAd3c ^fgax 3dcfga!";
        Map<Character, Integer> tm = strTomap(str);
        String me = mapTostring(tm);
        System.out.println(me);
    }
    /**
     * 对一串字符串统计各个字母的词频
     * 小结:字母有自然顺序,数组符合这种映射关系;
     *      但是字符与个数不存在,他们可以通过map建立映射
     * @param tm
     * @return
     */
    private static String mapTostring(Map<Character, Integer> tm) {
        StringBuilder str = new StringBuilder();
        Iterator<Map.Entry<Character, Integer>> it = tm.entrySet().iterator();
        while (it.hasNext()) {
            // Character c=it.next().getKey();
            // Integer i=it.next().getValue();不可两次next()相当于指针往后移了两次,会出现数据错误;
            Map.Entry<Character, Integer> me = it.next();// 应该每次定位到一个映射关系,再获取key,value;
            str.append(me.getKey() + "(" + me.getValue() + ")");
        }
        return str.toString();
    }

    private static Map<Character, Integer> strTomap(String str) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> tm = new TreeMap<Character, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!(arr[i] >= 'a' && arr[i] <= 'z' || arr[i] >= 'A' && arr[i] <= 'Z')) {
                continue;
            }
            Integer value = tm.get(arr[i]);
            // if (value == null) {
                // tm.put(arr[i], 1);
            // } else {
                // tm.put(arr[i], value + 1);
            // }
            int count=1;
            if(value!=null){//优化一下,get()返回不为null,说明已经键,就加1;
                count=value+1;
            }
            tm.put(arr[i], count);
        }
        return tm;
    }
}
