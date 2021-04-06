/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-05 19:24:22
 */
package edu.github.io.charstream.buffered;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class BufferedReadDemo {
    public static void main(String[] args) throws IOException {
        // FileReader fr=new FileReader("demo.txt");
        // int len=0;
        // char[] str=new char[1024];
        // while((len=fr.read(str))!=-1){
        // System.out.println(new String(str,0,len));

        // }
        method();
    }
    
    private static void method() throws IOException {
        FileReader fr = new FileReader("demo.txt");
        // int len = 0;
        // char[] str = new char[1024];
        // while ((len = fr.read(str)) != -1) {
        // System.out.println(new String(str, 0, len));
        // }
        // }
        // BufferedReader br = new BufferedReader(fr);
        LineNumberReader ld=new LineNumberReader(fr);//bufferedreader的子类,当然他们这个体系都是装饰别人的.
        String str;
        ld.setLineNumber(100);
        while ((str = ld.readLine()) != null) {
            System.out.println(ld.getLineNumber()+str);
        }
        ld.close();

    }

}

/*
 * @Descripttion:
 * 
 * @version: X3版本
 * 
 * @Author: 丁志军
 * 
 * @Date: 2021-04-05 19:24:22
 */
