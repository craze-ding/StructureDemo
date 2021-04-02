package edu.github.tool;

import edu.github.compartor.CompartorByLength;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @program: StructureDemo - 副本
 * @description: 集合工具类
 * @author: Craze
 * @create: 2021-03-31 09:27
 **/
public class CollecttionsDemo {
    public static void main (String[] args) {
//        methodInt();
        List<Integer> list=new ArrayList<> ();
        list.add (23);
        list.add (34);
        list.add (20);
        list.add (-2);
        list.add (89);
        list.add (67);

        List<String> str=new ArrayList<> ();
        str.add("ding");
        str.add("erty");
        str.add("defr");
        str.add("zhi");
        str.add("craze");
        str.add("jun");
        str.add("jun");

//        mySort(list);
//        System.out.println(list);
//        Reversed();//逆转
//        ReplaceDemo(str);//替换
        SreachDemo(str);
    }

    private static void methodString () {
        List<String> str=new ArrayList<> ();
        str.add("ding");
        str.add("erty");
        str.add("defr");
        str.add("zhi");
        str.add("craze");
        str.add("jun");
        str.add("jun");
        Collections.sort (str);
        System.out.println (str);
    }

    public static void methodInt(){
        List<Integer> list=new ArrayList<> ();
        list.add (23);
        list.add (34);
        list.add (20);
        list.add (-2);
        list.add (89);
        list.add (67);
        Collections.sort (list);
        System.out.println(list);

    }
    /**
    * @Description: 展示如何扩展比较范围
    * @Param: [list]
    * @return: void
    * @Author: Craze
    * @Date: 2021/3/31
    */
    public static  <T extends Comparable<? super T>> void mySort(List<T> list){
        for(int x=0;x<list.size ()-1;x++){
            for(int y=0;y< list.size ()-1-x;y++){
                if((list.get (y).compareTo (list.get (y+1))>0)){
                  swap(list,y,y+1);
//                    Collections.swap (list,x,y);
                }
            }
        }
    }
    /**
    * @Description: 泛型定义在静态上
    * @Param: [list, x, y]
    * @return: void
    * @Author: Craze
    * @Date: 2021/3/31
    */
    private static<W> void swap (List<W> list, int x, int y) {
        W temp=list.get (x);
        list.set (x, list.get (y));
        list.set (y,temp);
    }
    /**
     * @program: StructureDemo - 副本
     * @description: 自定义实现逆序
     * @author: Craze
     * @create: 2021-03-31 14:26
     **/
    public static void Reversed () {
         /*TreeSet<String> t=new TreeSet<> (new Comparator<String> () {
            @Override
            public int compare (String o1, String o2) {
                int temp=o2.compareTo (o1);
                return temp;
            }
        });//匿名内部类来创建比较器(自己实现)->底层原理*/
        TreeSet<String> t=new TreeSet<>  (Collections.reverseOrder (new CompartorByLength ()));
        t.add ("sygf");
        t.add ("ding");
        t.add ("craze");
        t.add ("edt");
        t.add ("tyu");
        t.add ("ax");
        System.out.println (t);
    }
    public static void ReplaceDemo(List<String> list){
        System.out.println(list);
//        Collections.replaceAll (list,"jun","haha");
        //set(indexOf("jun"),"haha")里面就这样
//        System.out.println (list);
        /*Collections.fill (list,"zhuzhu");
        System.out.println (list);*/
        Collections.shuffle (list);//洗牌
        System.out.println(list);
    }
    /**
     * @program: StructureDemo - 副本
     * @description: 演示集合框架binarySreach()
     * @author: Craze
     * @create: 2021-03-31 11:58
     **/
    public static void SreachDemo(List<String> str){
//        Collections.sort (str);
//        System.out.println(str);
        Collections.sort (str,new CompartorByLength ());//要怎么找就要怎么排好序,要统一标准
        System.out.println(str);
        int index=Collections.binarySearch (str,"ju4n",new CompartorByLength ());
        System.out.println(str);
        System.out.println("index"+"="+index);
        String max=Collections.max (str,new CompartorByLength ());
        System.out.println("max"+"="+max);
    }
}




