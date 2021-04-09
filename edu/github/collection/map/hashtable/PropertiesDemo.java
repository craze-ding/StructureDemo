/*
 * @Descripttion : Properties用法
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-08 11:34:22
 * @FilePath     : \edu\github\collection\map\hashtable\PropertiesDemo.java
 */
package edu.github.collection.map.hashtable;



import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;




import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        Properties pop = new Properties();
        // method2(pop);
        // method1(pop);
        // method3(pop);
        // method4(pop);
        method5(pop);
    }
    /**
     * @Descripttion: 获取应用程序使用次数，到达一定次数就不让用
     * @param        {Properties} pop
     * @return       {*}
     * @throws IOException
     */
    private static void method5(Properties pop) throws IOException {
              
        /**
         * 关联配置文件并封装file对象(windowns常用.ini;java中是.properties)
         * 简单配置用properties
         * 复杂就用xml
         */
        File comfig=new File("comfig.properties");
        //健壮性判断
        if(!comfig.exists()){
            comfig.createNewFile();
        }
        //创建字节流读取配置文件
        FileInputStream fis=new FileInputStream(comfig);
        //通过properties对象操作数据
        pop.load(fis);
        //获取次数
        String value=pop.getProperty("time");
        int count=0; 
        if(value!=null){  
            count=Integer.parseInt(value);
            if(count>=5)
                throw new RuntimeException("使用次数已到上限！请购买授权！");
        }
        count++;
        int cshu=5-count;
        System.out.println("还有"+cshu+"次");
        //将次数存储到集合中
        pop.setProperty("time",Integer.toString(count));
        //创建字节流写入到配置文件中保存起来,此文件将覆盖先前的配置文件
        FileOutputStream fos=new FileOutputStream(comfig);
        pop.store(fos, "comfigtiom");
        fis.close();
        fos.close();             
    }

    /**
     * @Descripttion: 存储与取出
     * @param {Properties} pop
     * @return {*}
     */
    private static void method4(Properties pop) {
        pop.setProperty("craze", "23");
        pop.setProperty("zhangsan", "15");
        pop.setProperty("lisi", "男");
        pop.setProperty("wangwu", "成都");
        pop.setProperty("dingyi", "学生");
        pop.setProperty("craze", "56");// 要修改的话就直接覆盖
        Set<String> keys = pop.stringPropertyNames();
        for (String key : keys) {
            String vaule = pop.getProperty(key);
            System.out.println(key + "=" + vaule);
        }

    }

    /**
     * @Descripttion: 通过list()方法将此属性列表打印到指定的输出流
     * @param {Properties} pop
     * @return {*}
     */
    private static void method3(Properties pop) {
        pop.setProperty("craze", "23");
        pop.setProperty("zhangsan", "15");
        pop.setProperty("lisi", "男");
        pop.setProperty("wangwu", "成都");
        pop.setProperty("dingyi", "学生");
        /**
         * 向控制台输出本平台属性信息（键值对都是string) file.separator \ line.separator
         */
        pop = System.getProperties();
        System.out.println("哈哈" + LINE_SEPARATOR + "craze");
        // pop.list(System.out);
    }

    /**
     * @Descripttion:将Properties()集合的键值对写入磁盘； 将磁盘的配置信息读入控制台
     * @param {Properties} pop
     * @return {*}
     * @throws IOException
     */
    private static void method2(Properties pop) throws IOException {
        pop.setProperty("craze", "23");
        pop.setProperty("zhangsan", "15");
        pop.setProperty("lisi", "男");
        pop.setProperty("wangwu", "成都");
        pop.setProperty("dingyi", "学生");
        // FileWriter file=new FileWriter("inf.ini");
        // FileOutputStream file=new FileOutputStream("inf.ini");
        // pop.store(file, " inf");
        //带有中文需要用字符流，否则会出现编码错误
        // FileInputStream fis=new FileInputStream("inf.ini");
        
        
        
        FileReader fw=new FileReader("inf.ini");
        pop.load(fw);
        pop.list(System.out);
        /** 
        * 自己实现store()
        File file=new File("inf.ini");
        if(!file.exists()){
            file.createNewFile();
        }
       
        BufferedReader bis=new BufferedReader(new FileReader(file));
        
        String line=null;
        while((line=bis.readLine())!=null){
            if(line.startsWith("#"))
                continue;
            // System.out.println(line);
            pop.setProperty(inf[0], inf[1]);
        }
        pop.list(System.out);
        **/
        
    }
    /**
     * @Descripttion: 修改配置信息
     * @param        {Properties} pop
     * @return       {*}
     * @throws IOException
     */
    private static void method1(Properties pop) throws IOException {
        File file=new File("inf.ini");
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedReader bis=new BufferedReader(new FileReader(file));
 
        String line;
        //读取文件
        while((line=bis.readLine())!=null){
            if(line.startsWith("#"))
                continue;
            // System.out.println(line);
            String[] inf=line.split("=");
            //将文件中的键值对存储到properties对象中
            pop.setProperty(inf[0], inf[1]);
        }
        //通过集合修改要修改的值
        pop.setProperty("dingyi","教授");
        //验证是否修改成功
        pop.list(System.out);
        FileWriter file1=new FileWriter("inf.ini");
        // pop.store(file1,"信息");避免注释中文
        pop.store(file1,"inftion");
        bis.close();       
       
    }
}
/*
 * @Descripttion :
 * 
 * @version : v1版本
 * 
 * @Author : 丁志军
 * 
 * @Date : 2021-04-08 11:34:22
 * 
 * @FilePath : \edu\github\collection\map\hashtable\PropertiesDemo.java
 */
