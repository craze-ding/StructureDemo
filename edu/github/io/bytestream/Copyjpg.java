/*
 * @Descripttion：通过字节流对象复制一张图片
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-06 17:46:03
 */
package edu.github.io.bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copyjpg {
    public static void main(String[] args) throws IOException {
        copy_1();
        copy_2();
        copy_3();
    }

    private static void copy_1() throws IOException {
        // 创建读入字节流对象，并且与文件相关连
        FileInputStream fis = new FileInputStream("C:\\Users\\30217\\Pictures\\pexels-engin-akyurt-6849098.jpg");
        // 创建读入缓冲区对象
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 创建写入磁盘字节流对象
        FileOutputStream fos = new FileOutputStream("1.jpg");
        // 创建写入缓冲区
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] b = new byte[1024];
        // int len = 0;
        while ((/* len = */ bis.read(b)) != -1) {
            bos.write(b);
            // 用到缓冲区记得要刷新
            bos.flush();
        }
        bos.close();
        bis.close();

    }

    private static void copy_2()  throws IOException{
        // 创建读入字节流对象，并且与文件相关连
        FileInputStream fis = new FileInputStream("C:\\Users\\30217\\Pictures\\pexels-engin-akyurt-6849098.jpg");
        // 创建读入缓冲区对象
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 创建写入磁盘字节流对象
        FileOutputStream fos = new FileOutputStream("2.jpg");
        // 创建写入缓冲区
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // byte[] b = new byte[1024];
        int ch = 0;
        while ((ch = bis.read()) != -1) {
            bos.write(ch);
            // 用到缓冲区记得要刷新
            bos.flush();
        }
        bos.close();
        bis.close();
    }

    private static void copy_3() throws IOException{
        // 创建读入字节流对象，并且与文件相关连
        FileInputStream fis = new FileInputStream("C:\\Users\\30217\\Pictures\\pexels-engin-akyurt-6849098.jpg");
        // 创建读入缓冲区对象
        // BufferedInputStream bis = new BufferedInputStream(fis);
        // 创建写入磁盘字节流对象
        FileOutputStream fos = new FileOutputStream("3.jpg");
        // 创建写入缓冲区
        // BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] b = new byte[1024];
        // int len = 0;
        while ((/* len = */ fis.read(b)) != -1) {
            fos.write(b);
            // 用到缓冲区记得要刷新
            // fos.flush();
        }
        fos.close();
        fis.close();
    }
}
