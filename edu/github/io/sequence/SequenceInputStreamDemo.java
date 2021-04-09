/*
 * @Descripttion :将文件1.txt,2.txt,3.txt....数据合并到一个文件 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-09 20:08:40
 * @FilePath     : \edu\github\io\sequence\SequenceInputStreamDemo.java
 */
package edu.github.io.sequence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        method();
    }

    private static void method() throws IOException {
        /**
         * vector因为线程安全，集合效率不行！我们打算用arryalist()提高效率！
         * Vector<FileInputStream> v=new Vector<>();
         *  v.add(new FileInputStream("inf.ini"));
         *  v.add(new FileInputStream("out.txt")); 
         * v.add(new FileInputStream("print.txt"));
         * v.add(new FileInputStream("writer.ini"));
         * Enumeration<FileInputStream> e=v.elements();
         */
       
       
       
       //此方法是自己实现，也不是很明智，我们想到collections()集合工具类。  
        ArrayList<FileInputStream> list=new ArrayList<>();
        list.add(new FileInputStream("inf.ini"));
        list.add(new FileInputStream("out.txt"));
        list.add(new FileInputStream("print.txt"));
      /*   //迭代器的出现替代枚举里面遍历对象方法,当初枚举就是方法名太长就被 迭代器取代的*/
      /*   Iterator<FileInputStream> it=list.iterator(); */
      /*   Enumeration<FileInputStream> e=new Enumeration<FileInputStream>() */{

      /*       @Override */
      /*       public boolean hasMoreElements() { */
      /*           // TODO Auto-generated method stub */
      /*           return it.hasNext(); */
      /*       } */

      /*       @Override */
      /*       public FileInputStream nextElement() { */
      /*           // TODO Auto-generated method stub */
      /*           return it.next(); */
      /*       } */
      /*        */
      /*   };  */
        //拿collection（）方法最方便！
        Enumeration<FileInputStream> e=Collections.enumeration(list);
        SequenceInputStream sis = new SequenceInputStream(e);
        FileOutputStream fos = new FileOutputStream("seq.txt");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
            fos.flush();
        }
        sis.close();
        fos.close();
    }
}
}
/*
 * @Descripttion :
 * 
 * @version : v1版本
 * 
 * @Author : 丁志军
 * 
 * @Date : 2021-04-09 20:08:40
 * 
 * @FilePath : \edu\github\io\sequence\SequenceInputStreamDemo.java
 */
