/*
 * @Descripttion : 获取指定目录下指定扩展名（保护子目录）并将这些文件的绝对路径保存到文件中
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-09 15:56:30
 * @FilePath     : \edu\github\io\Test.java
 */
package edu.github.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        /**
         * 小插曲：我在指定要遍历的目录是c盘时，jvm给我抛了NullPointerException,原因是有访问不到的文件，就是权限不够。
         * 换了其他就正常出结果了
         * 
         */
        File file=new File("e:\\Java资料");
        //创建匿名内部类过滤器
        FilenameFilter filter=new FilenameFilter(){

            @Override
            public boolean accept(File dir, String name) {
                // TODO Auto-generated method stub
                //后缀名为.avi返回
                return name.endsWith(".avi");
            }
            
        };
        List<File> list=new ArrayList<>();
        //指定目录下输出文件
        File lastfile=new File(file, "test.txt"); 
        DepthTraversal(file, filter, list);
        writerTofile(list,lastfile);
    }
    /**
     * @Descripttion: 将list<file>每个文件路径名写入到test.txt中
     * @param        {List<File>} list
     * @param        {File} lastfile
     * @return       {*}
     */
    private static void writerTofile(List<File> list, File lastfile) throws IOException {
        BufferedWriter bw=null;
        try {
            bw=new BufferedWriter(new FileWriter(lastfile));
            for(File file:list){
                bw.write(file.getAbsolutePath());
                bw.newLine();
                bw.flush();                
            }
        } catch (IOException e) {
            //TODO: handle exception
            throw new RuntimeException("写入失败");            
        }
        finally{
            if(bw!=null)
            try {
                bw.close();
            } catch (Exception e) {
                //TODO: handle exception
                throw new RuntimeException("关闭失败");
            }
               
        }

    }
    /**
     * @Descripttion:对指定目录进行深度遍历，并且按指定过滤器过滤，符合条件保存在list集合中 
     * @param        {File} file
     * @param        {FilenameFilter} filter
     * @param        {List<File>} list
     * @return       {*}
     */
    private static void DepthTraversal(File file,FilenameFilter filter,List<File> list) {       
        File[] filels=file.listFiles();
        for(int i=0;i<filels.length;i++){
            if(filels[i].isDirectory()){
                //递归遍历
                DepthTraversal(filels[i],filter,list);
            }
            else{
                //将符合条件的文件存储到集和中
                if(filter.accept(filels[i],filels[i].getName())){
                    list.add(filels[i]);
                }
            }
        }
    }
    
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-09 15:56:30
 * @FilePath     : \edu\github\io\Test.java
 */
