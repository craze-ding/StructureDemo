/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-09 17:33:41
 * @FilePath     : \edu\github\io\print\PrintDemo.java
 */
package edu.github.io.print;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintDemo {
    public static void main(String[] args) throws IOException {

        method1();
        // method2();
    }

    /**
     * @Descripttion: 演示PrintStream
     * @param {*}
     * @return {*}
     * @throws IOException
     */
    private static void method2() throws IOException {
        // PrintStream ps=new PrintStream("print.txt");
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream out = new FileOutputStream("out.txt");
        PrintStream ps1 = new PrintStream(out, true);
        String line = null;
        while ((line = bis.readLine()) != null) {
            if ("exit".equals(line))
                break;
            ps1.println(line);

        }
        // 只读入低8位，也就是一个字节
        // ps.write(609);
        // 保持数据表现形式
        // ps.print(97);
        // ps.close();
        ps1.close();
    }

    /**
     * @Descripttion:
     * @param {*}
     * @return {*}
     * @throws IOException
     */
    private static void method1() throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter pw = new PrintWriter(System.out,true);
        PrintWriter pw = new PrintWriter(new FileWriter("writer.ini"),true);
        String line = null;
        while ((line = bis.readLine()) != null) {
            if ("exit".equals(line))
                break;
            // pw.write(line.toUpperCase());           
            pw.println(line.toUpperCase());
            // pw.flush();
        }
        pw.close();
       
    }

}
/*
 * @Descripttion :
 * 
 * @version : v1版本
 * 
 * @Author : 丁志军
 * 
 * @Date : 2021-04-09 17:33:41
 * 
 * @FilePath : \edu\github\io\print\PrintDemo.java
 */
