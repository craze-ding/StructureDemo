
/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-03 18:05:51
 */
package edu.github.tool.collections;
import edu.github.compartor.CompartorByLength;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: StructureDemo - 副本
 * @description: 集合框架sort()重载加入Comparable参数
 * @author: Craze
 * @create: 2021-03-31 11:00
 **/
public class ComparableDemo {
    public static void main (String[] args) {
        List<Integer> list=new ArrayList<> ();
        list.add (23);
        list.add (34);
        list.add (20);
        list.add (-2);
        list.add (89);
        list.add (67);

        List<String> str=new ArrayList<> ();
        str.add("ng");
        str.add("rty");
        str.add("dgefr");
        str.add("zrewhi");
        str.add("crazewqe");
        str.add("jun");
        str.add("junqwwq");

       Collections.sort (str,new CompartorByLength ());

//        Collections.sort (str,new CompartorByLength ());

        mySort (str,new CompartorByLength ());
        System.out.println(str);
    }/**
    * @Description: 自定义实现sort()比较器
    * @Param: [list, com]
    * @return: void
    * @Author: Craze
    * @Date: 2021/3/31
    */
    public static <T> void mySort(List<T> list, Comparator<? super T> com ){
        for(int x=0;x<list.size ()-1;x++){
            for(int y=0;y< list.size ()-1-x;y++){
                if(com.compare (list.get (y),list.get (y+1))>0){
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


}
