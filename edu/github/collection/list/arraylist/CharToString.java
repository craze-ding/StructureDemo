/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-07 11:18:22
 * @FilePath     : \edu\github\collection\list\arraylist\CharToString.java
 */
package edu.github.collection.list.arraylist;


import java.util.Arrays;

/**
 * 将字符数组转字符串
 */
public class CharToString {
    public static void main(String[] args) {
        Character[] c={'1','w','R',',','p'};
        Arrays.toString(c);
        // List<Character> list=new ArrayList<>();
        // Character[] temp= list.toArray(new Character[list.size()]);
        StringBuffer str5 = new StringBuffer();
        for (Character s : c) {
            str5.append(s);
        }
        System.out.println(str5.toString());
    }
}
