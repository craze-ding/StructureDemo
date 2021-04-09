/*
 * @Descripttion :file对象操作方法 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-07 17:13:06
 * @FilePath     : \edu\github\io\file\FileMethodDemo.java
 */
package edu.github.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;

import edu.github.suffixfilter.FileterByHidden;


public class FileMethodDemo {
    public static void main(final String[] args) throws IOException {
        method1();
        method2();
        method3();
        method4();
        method5();
        method6();
        method7();
    
    }
    /**
     * 获取文件目录对象
     */
    private static void method7() {
        File file=new File("d:\\");
        // String[] list=file.list(new SuffixFilter(".txt"));
        File[] list=file.listFiles(new FileterByHidden());
        for( File s:list){
            System.out.println(s);
        }
    }
    /**
     * 获取目录内容
     */
    private static void method6() {
        /**
         * 调用list方法必须要保证封装的pathname是目录；
         * 否则发生NullPointerException
         *如果访问系统级目录也会报此异常。 
         * */
        // final File file=new File("C:\\");
        File file=new File("d:\\");
        //匿名内部类实现过滤器
        String[] list=file.list(new FilenameFilter(){
        public boolean accept(File dir,String name) {            
        //   过滤规则，pathname 是文件夹或者是.java结尾的文件
          return name.endsWith(".java");
      }
       });
    //    String[] list=file.list(new FileByJava());
        for(final String s:list){
            System.out.println(s);
        }

    }
    /**
     * 获取盘符和可用空间
     */
    private static void method5() {
        final File[] file=File.listRoots();
        final long[] space=new long[3];
        int i=0;
        for(final File f:file){
            System.out.println(f);
            System.out.println(f.getFreeSpace());
            space[i++]=f.getFreeSpace();
            // System.out.println(f.getUsableSpace());
            // System.out.println(f.getTotalSpace());
            
        }
        
    }
    /**
     * 重命名
     * @throws IOException
     */
    private static void method4() throws IOException {
        final File f=new File("test.mp3");
        f.createNewFile();
        f.renameTo(new File("p.mp3"));

    }
    /**
     * 判断
     */
    private static void method3() {
        final File f=new File("a.txt");
        final boolean f1=f.isFile();
        System.out.println(f1);
        System.out.println(f.isDirectory());

    }
    /**
     * 创建与删除
     * @throws IOException
     */
    private static void method2() throws IOException {
        //和输出流不一样，有不创建，不在就创建
        final File f=new File("file\\rt\\ui");
        // boolean f1=f.createNewFile();
        // System.out.println(f1);
        // boolean d=f.delete();
        // System.out.println(d);
        //创建多级目录
        final boolean f1=f.mkdirs();
        System.out.println(f1);
        

    }
    /**
     * 获取文件属性，name,len,time(最后修改)，path
     */
    private static void method1() {
        final File f=new File("test.txt");
        final String name=f.getName();
        final String path=f.getAbsolutePath();
        final long len=f.length();
        final long time=f.lastModified();
        final Date date=new Date(time);
        final DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        final String str_time=dateFormat.format(date);
        System.out.println("name"+":"+name);   
        System.out.println("time"+":"+str_time);   
        System.out.println("path"+":"+path);   
        System.out.println("len"+":"+len);
    }
}







