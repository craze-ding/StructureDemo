/*
 * @Descripttion:复制一个txt文本. 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-05 21:12:12
 */
package edu.github.io.charstream.buffered;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCopyTest {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("demo.txt");
        MyBufferedReader br=new MyBufferedReader(fr);
        FileWriter fw=new FileWriter("test.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        // int ch=0;
        // while((ch=br.read())!=-1){
            // bw.write((char)ch);
            // bw.flush();
        // }
        String str;
        
        while((str=br.MyreadLine())!=null){
            bw.write(str);
            bw.flush();
            bw.newLine();            
        }
        br.close();
        bw.close();        
    }
}






