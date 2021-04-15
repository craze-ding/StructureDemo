/*
 * @Descripttion : 线程任务对象
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-14 18:35:19
 * @FilePath     : \edu\github\socket\stcp\UploadService.java
 */
package edu.github.socket.stcp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadService implements Runnable {
    private Socket s;

    public UploadService(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        int counut=0;
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "..........connected");
        File dir = new File("C:\\Users\\30217\\Desktop\\test\\pci");      
        File file = new File(dir, ip + ".jpg");
        while (file.exists()) {
            file = new File(dir, ip + "(" + (++counut) + ")" + ".jpg");
        }
        FileOutputStream bufr=null;
        try {
            bufr = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        InputStream in=null;
        try {
            in = s.getInputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        OutputStream out=null;
        try {
            out = s.getOutputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] bufb = new byte[1024];
        // String line = null;
        int len = 0;
        try {
            while ((len = in.read(bufb)) != -1) {
                try {
                    bufr.write(bufb, 0, len);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            out.write("上传成功！".getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            bufr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
