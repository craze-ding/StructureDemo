/*
 * @Descripttion : 反射之访问获取修改字段
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-15 21:52:47
 * @FilePath     : \edu\github\reflection\FieldDemo.java
 */
package edu.github.reflection;

import java.lang.reflect.Field;

import edu.github.bin.Persion;
import edu.github.bin.Student;

public class FieldDemo {
    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        // AccessField();
        // AccessFieldValue();
        SetAccessFieldValue();
    }

    private static void SetAccessFieldValue() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Persion p = new Persion("旺财");
        Class pclass = p.getClass();
        Field f = pclass.getDeclaredField("name");
        f.setAccessible(true);
        f.set(p, "哈哈");
        System.out.println(p.getName());
    }

    private static void AccessFieldValue()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Object p = new Persion("旺财");
        Class pclass = p.getClass();
        Field f = pclass.getDeclaredField("name");
        // 调用Field.setAccessible(true)的意思是，别管这个字段是不是public，一律允许访问
        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value.toString());
        // 结果：IllegalAccessException
        // 因为name被定义为一个private字段，正常情况下，Main类无法访问Person类的private字段

    }

    private static void AccessField() throws NoSuchFieldException, SecurityException {
        Class stuclass = Student.class;
        /**
         * NoSuchFieldException 获取public字段，but我的name字段是private的；
         */
        // System.out.println(stuclass.getDeclaredField("name"));
        System.out.println(stuclass.getDeclaredField("score"));
        // 结果：public int edu.github.bin.Student.score
        /**
         * 根据字段名获取当前类的某个field不管是public，private,还是其他权限
         */
        System.out.println(stuclass.getDeclaredField("grade"));
        // 结果：private java.lang.String edu.github.bin.Persion.name
    }
}
