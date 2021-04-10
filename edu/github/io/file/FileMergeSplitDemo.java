/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-10 15:21:31
 * @FilePath     : \edu\github\io\file\FileMergeSplitDemo.java
 */
package edu.github.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

import edu.github.suffixfilter.SuffixFilter;

/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-10 15:21:31
 * @FilePath     : \edu\github\io\file\FileMergeSplitDemo.java
 */
public class FileMergeSplitDemo {
    private static final int SIZE = 1024*1024;
    

    public static void main(String[] args) throws IOException {
        File dri=new File("C:\\Users\\30217\\Desktop\\pexels-francesca-zama-6523461.jpg");
        File file=new File("d:\\partfiles\\12");
        // System.out.println(file.getParent());
        // filesplit(dri);
        filemerge(file);
       
    }

    private static void filemerge(File dri) throws IOException {
        //首先读取配置信息
        Properties p=new Properties();
        File[] properties=dri.listFiles(new SuffixFilter(".properties"));
        FileInputStream fis=new FileInputStream(properties[0]);
        p.load(fis);
        int counts=Integer.parseInt(p.getProperty("counts"));
        String name=p.getProperty("name");
        //搜寻碎片文件要用到过滤器
        File[] partfiles=dri.listFiles(new SuffixFilter(".part"));
        //做数量判断，数目不对就不给合并
        // System.out.println(partfiles.length);
        // if(partfiles.length!=counts-1){
            // 自定义异常
            // throw new NumberWrongException("数目少了或数目多了");           
        // }
        if(partfiles.length!=(counts-1)){
            //自定义异常
            throw new NumberWrongException("数目少了或数目多了");
        }
        ArrayList<FileInputStream> list=new ArrayList<>();
        for(int i =0;i<counts-1;i++){
            list.add(new FileInputStream(partfiles[i]));
            // list.add(new FileInputStream(new File(dri, i+".part")));
        }
        Enumeration<FileInputStream> e=Collections.enumeration(list);
        SequenceInputStream s=new SequenceInputStream(e);
        byte[] buf=new byte[SIZE];
        int len=0;
        FileOutputStream fos=new FileOutputStream(new File(dri, name));
        while((len=s.read(buf))!=-1){
            fos.write(buf, 0, len);                     
        }
        s.close();
        fos.close();
    }
    /**
     * @Descripttion: 切割文件
     * @param        {File} dri
     * @return       {*}
     */
    private static void filesplit(File dri) throws IOException {
        FileInputStream fis=new FileInputStream(dri);
        FileOutputStream fos=null;       
        // int fshu=(int)Math.ceil(Math.ceil(dri.length())/SIZE);        
        /**
         * 这里拿到将要切的个数，可以返回给用户再决定程序进不进行？
         * 这里size暂时是固定，最好由用户指定。
         */
        byte[] buf=new byte[SIZE];
        int len=0;
        int count=0;
        File fist=new File("d:\\partfiles\\12");
        if(!fist.exists()){
            // fist.createNewFile();
            fist.mkdirs();
        }
        while((len=fis.read(buf))!=-1){
            count++;
            //切割好的文件存放在目标文件同一级目录
            // fos=new FileOutputStream(new File(dri.getParent(),count+".part"));
            //   也可以指定
            fos=new FileOutputStream(new File(fist,count+".part"));
            fos.write(buf, 0, len);            
        }
        //往磁盘中写入配置信息
        Properties p=new Properties();
        fos=new FileOutputStream(new File(fist,(++count)+".properties"));
        p.setProperty("counts", count+"");
        p.setProperty("name", dri.getName());
        p.store(fos, "comligtions");
        fis.close(); 
        fos.close();   
    }
}