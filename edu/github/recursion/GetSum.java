/*
 * @Descripttion : 递归练习。使用时要注意递归次数，否则容易抛StackOverFlowError
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-08 10:36:14
 * @FilePath     : \edu\github\recursion\GetSum.java
 */
package edu.github.recursion;

public class GetSum {
    public static void main(String[] args) {
       int result=getsum(100);
       System.out.println(result);
       Tobin(6);
    }
    /**
     * @Descripttion: 获取一个数的二进制位
     * @param        {*}
     * @return       {*}
     */
    private static void Tobin(int i) {
        if(i>0){          
            System.out.println(i%2);
            Tobin(i/2);           
        }
    }
    /**
     * @Descripttion: 递归实现累加
     * @param        {*}
     * @return       {*}
     */
    private static int getsum(int i) {
       if(i==1)
            return 1;
        else
            return i+getsum(i-1);
        
    }
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-08 10:36:14
 * @FilePath     : \edu\github\recursion\GetSum.java
 */
