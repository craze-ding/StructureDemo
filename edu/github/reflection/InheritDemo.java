/*
 * @Descripttion : 反射之获取继承关系
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-15 23:53:31
 * @FilePath     : \edu\github\reflection\InheritDemo.java
 */
package edu.github.reflection;

import java.util.HashMap;

public class InheritDemo {
    public static void main(String[] args) {
        // getSupClass();
        getInterfaceClass();
    }

    private static void getInterfaceClass() {
        Class s = HashMap.class;
        Class[] is = s.getInterfaces();
        for (Class c : is) {
            System.out.println(c);
        }
        /**
         * 有以下接口： 
         * interface java.util.Map 
         * interface java.lang.Cloneable 
         * interface java.io.Serializable
         */
    }

    private static void getSupClass() {
        Class iclass = Integer.class;
        Class fuinterger = iclass.getSuperclass();
        System.out.println(fuinterger);
        Class o = fuinterger.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());
        /**
         * 结果： class java.lang.Number class java.lang.Object null
         */

    }
}
