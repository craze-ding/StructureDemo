/*
 * @Descripttion : 反射之调用构造函数-Constructor对象
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-15 23:37:48
 * @FilePath     : \edu\github\reflection\ConstructionDemo.java
 */
package edu.github.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import edu.github.bin.Persion;

public class ConstructionDemo {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        ConstructorDemo();
    }
    /**
     * @Descripttion: Constructor对象和Method非常类似，不同之处仅在于它是一个构造方法，并且，调用结果总是返回实例
     * @param        {*}
     * @return       {*}
     * @throws ClassNotFoundException
     */
    private static void ConstructorDemo() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        //获取构造方法
        // Constructor con1=Persion.class.getConstructor(String.class,int.class);
        //传入Class的完整类名获取class字节码文件
        Constructor con1=Class.forName("edu.github.bin.Persion").getConstructor(String.class,int.class);
        //调用构造方法实例化对象
        Persion p=(Persion)con1.newInstance("王五",23);
        System.out.println(p.toString());
        //结果：王五:23

    }
}
