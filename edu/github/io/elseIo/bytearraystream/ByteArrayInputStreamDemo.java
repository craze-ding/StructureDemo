/*
 * @Descripttion : 都在内存中操作数据
 *                  关闭资源无效，因为没有调用底层资源
 *                  也不抛异常
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 14:00:18
 * @FilePath     : \edu\github\io\elseIo\bytearraystream\ByteArrayInputStreamDemo.java
 */
package edu.github.io.elseIo.bytearraystream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        ByteArrayInputStream bis=new ByteArrayInputStream("dingzhijun".
        getBytes());
        writerdemo(bis);
        // readdemo(bis);
    }
    /**
     * @param bis2
     * @Descripttion: writer内存数据
     * @param        {*}
     * @return       {*}
     */
    private static void readdemo() {
        ByteArrayInputStream bis=new ByteArrayInputStream("dingzhijun".getBytes());

    }

    private static void writerdemo(ByteArrayInputStream bis) {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        int ch=0;
        while((ch=bis.read())!=-1){
            bos.write(ch);
        }
        System.out.println(bos.toString());
    }
    
}
