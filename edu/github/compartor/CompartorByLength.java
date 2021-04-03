/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-03 18:05:51
 */
package edu.github.compartor;

import java.util.Comparator;

/**
* @program: StructureDemo - 副本
*
* @description: 在演示交集合框架sort()比较器
*
* @author: Craze
*
* @create: 2021-03-31 11:06
**/
public class CompartorByLength implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        int temp=o1.length()-o2.length();
        return temp==0?o1.compareTo(o2):temp;
    }  
    
}
