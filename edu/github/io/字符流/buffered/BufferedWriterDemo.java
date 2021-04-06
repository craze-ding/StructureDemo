/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-05 18:45:04
 */
package edu.github.io.字符流.buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("demo.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("abcdef");
        bw.newLine();
        bw.write("haha");
        bw.flush();
        bw.close();
       
        
    }
    
}
