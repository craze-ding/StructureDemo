/*
 * @Descripttion : 服务端多线程技术
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-14 18:30:31
 * @FilePath     : \edu\github\socket\stcp\ServiceMultithreading.java
 */
package edu.github.socket.stcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceMultithreading {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(33000);
        while (true) {
            Socket s = ss.accept();
            new Thread(new UploadService(s)).start();
        }
    }

}
/*
 * @Descripttion :
 * 
 * @version : v1版本
 * 
 * @Author : 丁志军
 * 
 * @Date : 2021-04-14 18:30:31
 * 
 * @FilePath : \edu\github\socket\stcp\ServiceMultithreading.java
 */
