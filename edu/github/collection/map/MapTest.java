/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-02 18:47:00
 */
package edu.github.collection.map;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MapTest {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请输入数字!");
        int value=s.nextInt();
        String str= getWeek(value);
        String me=stringToMap(str);
        System.out.println(me);
        s.close();
    }

    private static String stringToMap(String str) {
        Map<String,String> map=new HashMap<String,String>();
        map.put("星期一", "wes");//建立星期表
        map.put("星期二", "tus");
        map.put("星期天", "sun");
        map.put("星期日", "sun");
        return map.get(str);
    }

    private static String getWeek(int value) {
        String[] str={"","星期一","星期二","星期三"};
        return str[value];
    }
       
}
