/*
 * @Descripttion : 客户端设置
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-13 20:24:39
 * @FilePath     : \edu\github\socket\stcp\TCPClient.java
 */
package edu.github.socket.stcp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        //创建socket客户端对象
        Socket s=new Socket(InetAddress.getByName("127.0.0.1"), 34678);
        //从键盘录入数据
        // BufferedReader bufout=new BufferedReader(new InputStreamReader(System.in));
        //从文件上传数据       
        BufferedReader bufout=new BufferedReader(new FileReader("seq.txt"));
        //往服务端发送数据
        PrintWriter clientout=new PrintWriter(s.getOutputStream(),true);
        //从服务器读取数据,在这里转换的都是文本数据
        // BufferedReader serviceout=new BufferedReader(new InputStreamReader(s.getInputStream()));
        //创建转接数据的容器
        String line=null;
        while((line=bufout.readLine())!=null){
            //堵塞式方法，如果没有换行标记就一直等待，并且要刷新flush（），
            if(line.equals("exit"))
                break;
            //打印向服务端要发的数据
            clientout.println(line);
            //接收服务端处理好的数据
            // String value=serviceout.readLine();
            //显示在控制台
            // System.out.println(value);
        }
        //给服务器发送关闭连接标志
        // clientout.println("exit");
        //返回上传成功字样
        //直接告诉服务端结束了
        s.shutdownOutput();
        BufferedReader serviceout=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String value=serviceout.readLine();
        System.out.println(value);
        bufout.close();
        s.close();
        
    }
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-13 20:24:39
 * @FilePath     : \edu\github\socket\stcp\TCPClient.java
 */
