/*用于读取指定流，你读过来我就写，木有我就等呗
 * @Descripttion : 管道的输入输出是关联在一起的，跟以前流对象分开不同。所以这个对象要结合多线程技术读写同时进行，从而避免了阻塞（死锁）。
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 14:02:04
 * @FilePath     : \edu\github\io\elseIo\pipedstream\PipedStreamDemo.java
 */
package edu.github.io.elseIo.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
    public static void main(String[] args) throws IOException {
      PipedInputStream input=new PipedInputStream();
      PipedOutputStream output=new PipedOutputStream();
      input.connect(output);
      new Thread(new Input(input)).start();
      new Thread(new Output(output)).start();      
    }      
}
class Input implements Runnable{
    private PipedInputStream in;

    public Input(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            byte[] buf=new byte[1024];
            int len=in.read(buf);
            String s=new String(buf, 0, len);
            System.out.println("S="+s);
            in.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
class Output implements Runnable{
    private PipedOutputStream out;

    public Output(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(5000);
            out.write("好啊好啊".getBytes());
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 14:02:04
 * @FilePath     : \edu\github\io\elseIo\pipedstream\PipedStreamDemo.java
 */
