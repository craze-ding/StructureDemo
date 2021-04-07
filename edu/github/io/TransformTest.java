package edu.github.io;
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-07 11:27:39
 * @FilePath     : \edu\github\io\TransformTest.java
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;




public class TransformTest {
    public static void main(String[] args) throws IOException {
      //   method1();
      //   method2();
      //   method3();
      //   method4();
      //   method5();
      //   method6();
        method7();
    }


/**
 * 
 * 指定编码表读文件，就不能使用fileread,它使用但是默认码表；
 * 要用outputsteanwriter接收字节流输出对象，该对象就是fileoutputsteam
 * @throws IOException
 */
private static void method7() throws IOException {
	InputStreamReader isr=new InputStreamReader(new FileInputStream("utf.txt"),"GBK");
	char[] buf=new char[10];
	int len=isr.read(buf);
	String str=new String(buf,0,len);
	System.out.println(str);
	isr.close();
	
}



private static void method6() throws IOException {
	OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("utf.txt"),"utf-8");
	osw.write("你好");
	osw.close();
}



private static void method5() throws IOException {
	OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("gbk.txt"),"GBK");
	osw.write("你好");
	osw.close();
}



private static void method4() throws IOException {
	    FileWriter fw=new FileWriter(" default.txt");
	    fw.write("你好"); 
	    fw.close();
}
/**
 * @throws IOException
     * 
     */
    private static void method3() throws IOException {
	    InputStream in=System.in;
	//     int ch=in.read();
	//     System.out.println(ch);
	//     int ch1=in.read();
	//     System.out.println(ch1);
	InputStreamReader isr=new InputStreamReader(in);
	int ch=isr.read();
	System.out.println((char)ch);
	System.out.println("哈哈");
	}
     /**
  * 需求：将从键盘键入的字符存储到文本文件中
  * 分析：源：
  *          控制台：system.in
  *       目的：
  *          磁盘：file
  *      是否是纯为本？
  *          源：不是 Inputstream
             目的：是 file
  *        要提高效率？
  *          缓冲区（转换流）
  *      确定体系里面的流对象
  *       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  * @throws IOException
  */
    private static void method2() throws IOException {
        //将从键盘键入的字符存储到文本文件中
        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("0.txt")));
        //将从文本文件的字符存储到打印到控制台
        // BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("0.txt")));
        // BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        //复制文件
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("0.txt")));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test.txt")));
        String line;
        while((line=br.readLine())!=null){
            bw.write(line.toUpperCase());
            if(line.equals("exit"))
                return ;
            bw.newLine();
            bw.flush();
        }
        
    }
    /**
     * 需求：将从键盘键入的字符输出到控制台
     * 分析：源：
     *          控制台：system.in
     *       目的：
     *          控制台：system.out
     *      是否是纯为本？
     *          
     *        要提高效率？
     *          缓冲区（转换流）
     *      确定体系里面的流对象
     *       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     * @throws IOException
     */
    private static void method1() throws IOException {
        //创建源输入字节流对象
        // InputStream is=System.in;
        //将字节流转换成字符流
        // InputStreamReader isr=new InputStreamReader(is);
        //创建缓冲区对象
        // BufferedReader br=new BufferedReader(isr);
        //增强写法   
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while((line=br.readLine())!=null){
            bw.write(line); 
            if(line.equals("exit"))
                break;
            // System.out.println(line.toString().toUpperCase());
            bw.newLine();
            bw.flush();         
        }
    }
}

/**
 * 需求：复制一个文本文件
 * 分析：1.明确源和目的
 *          源：磁盘：reader inputstream
 *          目的：磁盘：writer outputstream
 *      2.是否纯文本？
 *          源：是 fileread
 *          目的:是 filewriter
 *      3.明确设备
 *          源；磁盘：fileread
 *          目的；磁盘 filewrter
 *      4.是否要提高效率？
 *          是 加入buffered
 *       bufferedreader bur=new bufferedreader(new fileread("0.txt"));
 *       bufferedwriter buw=new bufferedwriter(new filewriter(1.txt));
 */
/**
 * 需求：将一个文本文件输入到控制台
 * 分析：1.明确源和目的
 *          源：控制台：reader 
 *          目的：磁盘： outputstream
 *      2.是否纯文本？
 *          源：是 fileread
 *          目的:是 outputstreamwriter
 *      3.明确设备
 *          源；磁盘：fileread
 *          目的；控制台 system.out
 *      4.是否要提高效率？
 *          是 加入buffered
 *       bufferedreader bur=new bufferedreader(new fileread("0.txt"));
 *       bufferedwriter buw=new bufferedwriter(new outputstreamwriter(system.out));
 */
/**
 * 需求：将键盘输入到文本文件
 * 分析：1.明确源和目的
 *          源：控制台：reader 
 *          目的：磁盘： outputstream
 *      2.是否纯文本？
 *          源：是 fileread
 *          目的:是 outputstreamwriter
 *      3.明确设备
 *          源；磁盘：fileread
 *          目的；控制台 system.out			
 *      4.是否要提高效率？
 *             要 转换
 *          是 加入buffered
 *       bufferedreader bur=new bufferedreader(new inputstreanmread(system.in));
 *       bufferedwriter buw=new bufferedwriter(new filewriter("test.txt"));
 * 		
 */





