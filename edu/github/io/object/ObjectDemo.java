/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-10 21:02:51
 * @FilePath     : \edu\github\io\object\ObjectDemo.java
 */
package edu.github.io.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.github.bin.Persion;
import edu.github.bin.Student;

public class ObjectDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // method1();
        method2();
    }

    /**
     * @Descripttion: 序列化对象
     * @param {*}
     * @return {*}
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static void method1() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));
        oos.writeObject(new Persion("ding", 23));
        oos.writeObject(new Student("craze", 12));

        oos.close();
        /**
         * NotSerializableException 要实现Serializable接口
         */
    }

    /**
     * @Descripttion: 反序列化对象
     * @param {*}
     * @return {*}
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    private static void method2() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
        for (int i = 0; i < 2; i++) {
            Object obj = ois.readObject();
            Persion p = (Persion) obj;
            System.out.println(p.toString());
        }        
        ois.close();
        /**
         * 
         * 用于验证序列化对象的发送者和接收者是否已加载与该序列化兼容的对象的类(不通过就抛InvalidClassException)
         * 所以要加id号
         */
    }
}
/*
 * @Descripttion :
 * 
 * @version : v1版本
 * 
 * @Author : 丁志军
 * 
 * @Date : 2021-04-10 21:02:51
 * 
 * @FilePath : \edu\github\io\object\ObjectDemo.java
 */
