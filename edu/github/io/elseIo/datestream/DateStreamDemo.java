/*
 * @Descripttion : 对基本数据类型操作
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 14:01:01
 * @FilePath     : \edu\github\io\elseIo\datestream\DateStreamDemo.java
 */
package edu.github.io.elseIo.datestream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DateStreamDemo {
    public static void main(String[] args) throws IOException {
        method1();
        method2();
    }
    /**
     * @Descripttion: writer 数据
     * @param        {*}
     * @return       {*}
     * @throws IOException
     */
    private static void method2() throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("datastream.txt"));
        dos.writeUTF("丁志军");
        dos.close();
        
    }

    private static void method1() throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream("datastream.txt"));
        String str=dis.readUTF();
        System.out.println(str);
        dis.close();
    }
    
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 14:01:01
 * @FilePath     : \edu\github\io\elseIo\datestream\DateStreamDemo.java
 */
