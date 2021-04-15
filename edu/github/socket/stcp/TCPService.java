/*
 * @Descripttion :服务端设置
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-13 20:22:52
 * @FilePath     : \edu\github\socket\stcp\TCPService.java
 */
package edu.github.socket.stcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPService {
    public static void main(String[] args) throws IOException {
        //创建服务端socket服务
        ServerSocket ss=new ServerSocket(34678);
        Socket s=ss.accept();
        System.out.println(s.getInetAddress().getHostAddress()+".....connected");
        //创建读取客户端发来的数据对象
        BufferedReader clientout=new BufferedReader(new InputStreamReader(s.getInputStream()));
        //创建给客户端发送处理好的数据
        PrintWriter service=new PrintWriter(s.getOutputStream(),true);
        //写到本地文件中
        BufferedWriter bufin=new BufferedWriter(new FileWriter("servic.txt"));
        //创建数据转接器
        String line=null;
        while((line=clientout.readLine())!=null){
            // System.out.println(line);
            // service.println(line.toUpperCase());
            //这样文件可能自带exit,所以这太烂了！
            // if(line.equals("exit"))
                // break;
            bufin.write(line);
            bufin.newLine();            
        }
        service.println("上传成功！");
        bufin.close();
        s.close();
        ss.close();        
    }
}
