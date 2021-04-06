import java.io.FileWriter;
import java.io.IOException;

/*
 * @Descripttion: 
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-03 14:57:01
 */
public class FileWriterDemo {
    /**
     *
     */
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {

        FileWriter file =null ;
        try {
            //FileNotFoundException(统找不到指定的路径。)
            file=new FileWriter("demo.txt", true);// 加入ture就可以对文件进行续写
            file.write("dingzhijun" + LINE_SEPARATOR + "哈哈哈");
            file.write("这是真的");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //NullPointerException(文件对象创建失败,无法获取指针)
            if(file!=null){
                try {
                    file.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    throw new RuntimeException("关闭失败!");
                    // e.printStackTrace();
                }
            }
        }

    }

}