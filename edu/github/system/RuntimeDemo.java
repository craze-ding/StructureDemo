/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-06 16:54:13
 */
package edu.github.system;

import java.io.IOException;


public class RuntimeDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * 
         * Runtime对象没有构造方法，说明不能创建对象。
         * 该类只提供一个静态方法返回该类对象。而且只有一个。
         * 说明runtime类使用了单例设计模式
        **/
      Runtime r=Runtime.getRuntime();
      Process p= r.exec("notepad.exe C:\\Users\\30217\\Desktop\\JavaDemo\\AbstactDemo.java");
      //让主线程睡眠5秒再自己醒来，方便观察到现象
      Thread.sleep(5000);
      //只能杀死runtime开启的进程
      p.destroy();

    }
}
