import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-03 16:26:38
 */
/** 要求:复制一个文件到指定路径
 * 
 * 
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        // 创建存储数据对象
        FileWriter w = null;
        //用于读取已有文本文件,使得字符读取流与文件关联
        FileReader r = null;
        try {
            w = new FileWriter("test.txt");
            r = new FileReader("demo.txt");
            char[] str = new char[1024];
            int len = 0;
            //频繁读取操作
            while ((len = r.read(str)) != -1) {
                //String s = new String(str, 0, len);
                w.write(str,0,len);
                w.flush();
            }       
        } catch (IOException e) {
            // TODO: handle exception
            throw new RuntimeException("读写失败!");
        }finally{
            //关闭流资源
            if(r!=null)
            try {
                r.close();
            } catch (Exception e) {
                //TODO: handle exception
                throw new RuntimeException("读入内存失败!");
            }            
            if(w!=null)
            try {
                w.close();
            } catch (Exception e) {
                //TODO: handle exception
                throw new RuntimeException("写入硬盘失败!");
            }           
        }
    }
}
