/*
 * @Descripttion : math数学方法
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-08 15:16:12
 * @FilePath     : \edu\github\math\MathDemo.java
 */
package edu.github.math;


public class MathDemo {
    public static void main(String[] args) {

        method1();
        method2();
        method3();
    }

    private static void method3() {
        // 四舍五入
        // int reult=(int) Math.round(1.2);
        // 取上限
        // int reult= (int) Math.ceil(1.2);
        // 取下限
        // int reult= (int) Math.floor(1.2);
        // 产生一个0~1不含1的伪随机数
        Double reult = Math.random();
        System.out.println(reult);
    }
    
    private static void method2() {
        // NumberFormat currency=NumberFormat.getPercentInstance();
    }
    private static void method1() {

    }

}
