/*
 * @Descripttion : 读入键盘的数据
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-06 22:39:54
 * @FilePath     : \edu\github\io\ReadKey.java
 */
package edu.github.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadKey {
    public static void main(String[] args) throws IOException {
        method1();
        method2();
        method3();
    }

    private static void method3() throws IOException {
        InputStream in = System.in;
        int ch = in.read();
        System.out.println(ch);
        int ch1 = in.read();
        System.out.println(ch1);// windown中'\r'
        int ch2 = in.read();
        System.out.println(ch2);// windown中‘\n’
        // in.close();//默认输入输出设备不用关
    }
    /**
     * 选用stringbuilder()
     * @throws IOException
     */
    private static void method2() throws IOException {
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();
        // 定义读取到的字节的变量，并且循环获取
        int ch = 0;
        while ((ch = in.read()) != -1) {
            // 回车符 '\r' 不存
            /**
             * 我们平时编写文件的回车符(即：回车键 )应该确切来说叫做回车式的换行符。
             * 
             * 即我们的换行符通过键盘上的回车键来实现。
             * 
             * 也即键盘上的回车键是用来进行实现换行符的。
             * 
             * 也即键盘上的回车键不是用来进行实现回车符的。
             */
            if (ch == '\r')
                continue;
            if (ch == '\n') {
                String temp = sb.toString();
                if ("exit".equals(temp)) {
                    return;
                }
                System.out.println(temp.toUpperCase());
                // 输出完立即清StringBuilder.
                sb.delete(0, sb.length());
            } else {
                sb.append((char) ch);
            }
        }

    }
    /**
     * 选用arryslist()来存储字符，相比而言比较复杂一点
     * @throws IOException
     */
    private static void method1() throws IOException {
        InputStream in = System.in;
        // StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        // 定义读取到的字节的变量，并且循环获取
        int ch = 0;
        while ((ch = in.read()) != -1) {
            if (ch == '\r')
                continue;
            if (ch == '\n') {
                // String temp = sb.toString();
                Character[] temp = list.toArray(new Character[list.size()]);
                //去除逗号
                StringBuffer str5 = new StringBuffer();
                for (Character s : temp) {
                    str5.append(s);
                }
                if ("exit".equals(str5.toString())) {
                    return;
                }
                System.out.println(str5.toString().toUpperCase());
                // 输出完立即清StringBuilder.
                // sb.delete(0, sb.length());
                list.clear();
            } else {
                // sb.append((char) ch);
                list.add((char) ch);
            }
        }

    }
}
