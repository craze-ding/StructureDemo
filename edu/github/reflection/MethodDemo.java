/*
 * @Descripttion : 反射之调用方法
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-15 22:52:30
 * @FilePath     : \edu\github\reflection\MethodDemo.java
 */
package edu.github.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.github.bin.Persion;
import edu.github.bin.Student;

public class MethodDemo {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // AccessMethod();
        polymorphic();
        // AccessMethodValue();
        // AccessStaticMethodValue();
        SetAccessMethodValue();
    }
private static void polymorphic() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    //获取persion的tostring()
    Method p=Persion.class.getMethod("toString", null);
    //对student的调用tostring
    p.invoke(new Student());
    /**
     * 使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）.
     */

    }
/**
 * 对Method实例调用invoke就相当于调用该方法，invoke的第一个参数是对象实例，即在哪个实例上调用该方法，后面的可变参数要与方法参数一致，否则将报错
 * @throws NoSuchMethodException
 * @throws SecurityException
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException
 */
    private static void AccessStaticMethodValue() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //已知integer.parseInt()是static()
        Method m=Integer.class.getMethod("parseInt", String.class);
        //调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null
        Integer n=(Integer)m.invoke(null, "1234");
        System.out.println(n);
    }

    private static void SetAccessMethodValue() {
    }

    private static void AccessMethodValue() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Persion p=new Persion("李四",12);
        Class pclass=p.getClass();
        Method m=pclass.getMethod("getName", null);
        String name=(String) m.invoke(p, null);
        System.out.println(name);
        //结果：李四
    }

    private static void AccessMethod() throws NoSuchMethodException, SecurityException {
        //因为是通过反射技术拿对象，第一步都是拿class字节码文件
        Class pclass=Persion.class;
        Method m1=pclass.getMethod("setName", String.class);
        //结果：public void edu.github.bin.Persion.setName(java.lang.String)
        Method m2=pclass.getDeclaredMethod("setAge", int.class);
        //结果:private void edu.github.bin.Persion.setAge(int)
        Method m3=pclass.getMethod("getName", null);
        //结果：public java.lang.String edu.github.bin.Persion.getName()
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
       
    }
}
/*
 * @Descripttion :
 * 
 * @version : v1版本
 * 
 * @Author : 丁志军
 * 
 * @Date : 2021-04-15 22:52:30
 * 
 * @FilePath : \edu\github\reflection\MethodDemo.java
 */
