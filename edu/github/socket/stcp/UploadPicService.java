/*
 * @Descripttion : 上传图片之服务端
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-14 16:27:28
 * @FilePath     : \edu\github\socket\stcp\UploadPicService.java
 */
package edu.github.socket.stcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Driver;

public class UploadPicService {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(33000);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "..........connected");
        File dir = new File("C:\\Users\\30217\\Desktop\\test\\pci");
        if (dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, ip + ".jpg");

        FileOutputStream bufr = new FileOutputStream(file);
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        byte[] bufb = new byte[1024];
        // String line = null;
        int len = 0;
        while ((len = in.read(bufb)) != -1) {
            bufr.write(bufb, 0, len);
        }
        out.write("上传成功！".getBytes());
        bufr.close();
        in.close();
        out.close();
    }
}
/*
 * @Descripttion :
 * 
 * @version : v1版本
 * 
 * @Author : 丁志军
 * 
 * @Date : 2021-04-14 16:27:28
 * 
 * @FilePath : \edu\github\socket\stcp\UploadPicService.java
 */
