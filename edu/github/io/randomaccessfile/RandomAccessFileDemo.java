/*
 * @Descripttion : 随机访问文件大小，可读可写，底层维护了byte[]
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 10:40:43
 * @FilePath     : \edu\github\io\randomaccessfile\RandomAccessFileDemo.java
 */
package edu.github.io.randomaccessfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        method1();
        // method2();
    }
    /**
     * @Descripttion: RandomAccessFile其实是将OutputStream,inputstram封装了。
     * @param        {*}
     * @return       {*}
     * @throws IOException
     */
    private static void method2() throws IOException {
       RandomAccessFile raf=new RandomAccessFile("rand.txt", "rw");
       raf.write("张三".getBytes());
       //只取低8位，因为是byte[]
    //    raf.write(97);
       raf.writeInt(609);
       raf.close();  
    }
    /**
     * @Descripttion: 
     * @param        {*}
     * @return       {*}
     * @throws IOException
     */
    private static void method1() throws IOException {
        RandomAccessFile raf=new RandomAccessFile(new File("C:\\Users\\30217\\Desktop\\StructureDemo", "rand.txt"), "rw");
        //这里有个小细节，我的默认码表是UTF-8所以中文是每个是3字节。 unicode是两个
        byte[] buf=new byte[6];
        raf.read(buf);
        String name=new String(buf);
        // raf.read(buf);
        //我在写入时int四个字节，我读时也要注意！
        int age=raf.readInt();
        System.out.println("name="+name+"age="+age);
    }
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 10:40:43
 * @FilePath     : \edu\github\io\randomaccessfile\RandomAccessFileDemo.java
 */
