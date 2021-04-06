package edu.github.io.字符流;

import java.io.FileReader;
import java.io.IOException;

/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-03 15:41:14
 */
public class FileReadDemo {
    public static void main(String[] args) {
        FileReader file=null;
        try {
            file=new FileReader("demo.txt");
            // int ch=0; 单个字符来取          
            // while((ch=file.read())!=-1){
                // System.out.println((char)ch);                
            // }
            char[] str=new char[1024];//按指定长度字符串来取,1024的整数倍最好
            int len=0;          
            while((len=file.read(str))!=-1){
                System.out.println(new String(str,0,len));
            }
        } catch (IOException e) {
            //TODO: handle exception
        }finally{
            if(file!=null)
            try {
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
