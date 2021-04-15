/*
 * @Descripttion : 多线程+socket实现聊天程序
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-13 16:03:52
 * @FilePath     : \edu\github\socket\sudp\UDPChat.java
 */
package edu.github.socket.sudp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 *这里要事先准备好本地C:\Windows\System32\drivers\etc host ip 地址
 测试时发现自己搞的域名主机解析不了，jvm抛出UnknownHostException（抛出以表示无法确定主机的IP地址。）
 没办法，就用127.0.0.1了，还有就是在测试时应该发生阻塞现象了，应该时端口被windowns占用了。比如：10000，10001
 测试到34678成功有了预期结果
 */
public class UDPChat {
    public static void main(String[] args) throws SocketException {
        
        DatagramSocket send=new DatagramSocket();
        DatagramSocket receive=new DatagramSocket(34678);        
        
        Send s=new Send(send);
        Receive r=new Receive(receive);
        
         new Thread(s).start();
         new Thread(r).start();
        

    }

}

class Send implements Runnable {
    private DatagramSocket ds;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        try {           
           
            //键盘录入数据
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String line=null;
            
            while((line=br.readLine())!=null){
                
                byte[] buf=line.getBytes();                
                //封装数据对象
                DatagramPacket dp=new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1") , 34678);
                //发送数据包
                ds.send(dp);
                if(line.equals("exit"))
                    break;
            }
            ds.close();   
    
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }

    public Send(DatagramSocket ds) {
        this.ds = ds;
    }

}
class Receive implements Runnable{
    private  DatagramSocket ds;
    
    @Override
    public void run() {
        // TODO Auto-generated method stub

            try {
                while(true){
                    byte[] buf=new byte[1024];
                    //创建接收数据包对象
                    DatagramPacket dp=new DatagramPacket(buf,buf.length);
                    ds.receive(dp);
                    String ip=dp.getAddress().getHostName();
                    int port=dp.getPort();
                    String text=new String(dp.getData(), 0,dp.getLength());
                    System.out.println(ip+":"+port+":"+text);
                    if(text.equals("886")){
                        System.out.println("退出聊天室！");
                        break;
                    }
                    
                   }
                   ds.close();
            } catch (Exception e) {
                //TODO: handle exception
            }             
    }
     //创建socket接收服务
    public Receive(DatagramSocket ds) {
        this.ds = ds;
    }

}