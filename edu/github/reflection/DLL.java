/*
 * @Descripttion : 动态加载class的特性
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-15 21:41:00
 * @FilePath     : \edu\github\reflection\DLL.java
 */
package edu.github.reflection;

import edu.github.bin.Persion;

public class DLL {
    public static void main(String[] args) {
        /**
         * 我们可以知道jvm给main()传一个?我忘记了，就是为了启动主线程，将main()入栈；
         */
        System.out.println(args);//[Ljava.lang.String;@15db9742
        System.out.println(args.length);//args.length=0
        if (args.length > 0) {//条件不满足
            create(args[0]);//如果没有执行create()方法，那么Person.class根本就不会被加载
        }
    }
    static void create(String name) {
        Persion p = new Persion(name);
        System.out.println(p);
    }
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-15 21:41:00
 * @FilePath     : \edu\github\reflection\DLL.java
 */
