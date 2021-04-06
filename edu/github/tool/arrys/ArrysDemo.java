/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-06 16:54:13
 */
package edu.github.tool.arrys;


import java.util.Arrays;
import java.util.List;

public class ArrysDemo {
    public static void main(String[] args) {
        // method1();
        // method2();
        method3();
       
    }
    /**
     * @Descripttion: 
     * @param        {*}
     * @return       {*}
     */
    private static String MytoString(int[] a) {
        if (a == null)
        return "null";
    int iMax = a.length - 1;
    if (iMax == -1)
        return "[]";
    StringBuilder b = new StringBuilder();
    b.append('[');
    for (int i = 0; ; i++) {//中间省略条件判断，提高效率
        b.append(a[i]);
        if (i == iMax)
            return b.append(']').toString();
        b.append(", ");
    }
    }
    public static boolean MyContains(String[] str,String key){
        for(int i=0;i<str.length;i++){
            if(str[i].equals(key)){
                return true;
            }
        }
        return false;
    }
    private static void method1() {
        int[] arr={1,2,3,4,5};
        // System.out.println(Arrays.toString(arr));
        System.out.println(MytoString(arr));
    }

    private static void method2() {
        String[] str={"craze","ding","lisi","wangwu"};
        List<String> list=Arrays.asList(str);
        //自定义实现contains()方法。
        // boolean b=MyContains(str, "lisi");
        // System.out.println(b);
        //集合方法contains()方法更方便！
        // boolean b=list.contains("lisi");
        // System.out.println(b);
        //list.add("zhangsan");//UnsupportedOperationException(数组长度是固定，不能add(),remove())
        list.remove("lisi");

    }

    private static void method3() {
        int[] arr={1,2,3,4,5};
        List<int[]> list=Arrays.asList(arr);
        /**
         * 如果数组元素是对象，转集合时，直接存储；
         * 如果是基本数据类型，那么就将数组作为集合对象存储。
        **/
        // System.out.println(/* list+ */list.size());//"[[I@15db9742]----1“
    }

}
