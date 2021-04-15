/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-14 20:16:32
 * @FilePath     : \edu\github\socket\stcp\MyTomcat.java
 */
package edu.github.socket.stcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *   GET / HTTP/1.1
Host: 192.168.0.198:45001
Connection: keep-alive
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.72 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,;q=0.8,application/signed-exchange;v=b3;q=0.9
Accept-Encoding: gzip, deflate
Accept-Language: zh-CN,zh;q=0.9
 */


public class MyTomcat {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(45001);
        Socket s=ss.accept();
        String ip=s.getInetAddress().getHostAddress();
        System.out.println(ip+"....有请求响应需要处理！");
        InputStream in=s.getInputStream();
        byte[] bufin=new byte[1024];
        int len=0;
        while((len=in.read(bufin))!=-1){
            String str=new String(bufin, 0, len);
            System.out.println(str);
        } 
        PrintWriter out=new PrintWriter(s.getOutputStream(),true);
        out.write("12345");
        s.close();
        ss.close();
    }
}
