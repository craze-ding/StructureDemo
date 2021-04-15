/*
 * @Descripttion : 上传图片之客户端
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-14 16:26:41
 * @FilePath     : \edu\github\socket\stcp\UploadPicClient.java
 */
package edu.github.socket.stcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadPicClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 33000);
        FileInputStream fis = new FileInputStream("1.bmp");
        OutputStream out = s.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        s.shutdownOutput();
        InputStream in = s.getInputStream();
        byte[] bufin = new byte[1024];
        int l = in.read(bufin);
        String str = new String(bufin, 0, l);
        System.out.println(str);
        fis.close();
        in.close();
        out.close();
    }

}
