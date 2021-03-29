package edu.github.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.github.bean.Worker;
import edu.github.bin.Persion;
import edu.github.bin.Student;

public class GenericlimitDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arr1=new ArrayList<>();
        arr1.add(2);
        arr1.add(4);
        arr1.add(6);
        // printcollection(arr1);
        ArrayList<String> arr2=new ArrayList<>();
        arr2.add("lisi");
        arr2.add("zhangsang");
        arr2.add("wangwu");
        // printcollection(arr2);
        ArrayList<Worker> arr3=new ArrayList<>();
        arr3.add(new Worker("lisi", 22));
        arr3.add(new Worker("wamgwu", 11));
        arr3.add(new Worker("zhangsang", 00));        
        // printcollection(arr3);
        ArrayList<Student> arr4=new ArrayList<>();
        arr4.add(new Student("lisi", 33));
        arr4.add(new Student("wamgwu", 44));
        arr4.add(new Student("zhangsang", 55));      
        printcollection(arr4);
            
    }
    /**
     * 迭代打印集合中的元素
     * @param arr
     *///泛型的限定
     /* ? extends persion:接收persion对象的子类(上限)
      *  ? super E :接收E雷或E的父类.父类的父类 (下限)  
      *
      * @param arr
      */
    private static /* <T> T */void  printcollection(Collection<?extends Persion> /* <T>  */arr) {//collection<persion>=new arraylist<student>要保证两边泛型一致,如果只是实现一个体系就可以 ? extends persion
        Iterator<?>/* <T>  */it=arr.iterator();
        while(it.hasNext()){
            // T t=it.next();
            System.out.println(it.next());//只是打印的话就用通配符?来接收就好了
        }
        // T t=it.next();//获取t值可以被其他方法调用,在方法上定义泛型还是比较复杂.
        // return t;
    }

}
