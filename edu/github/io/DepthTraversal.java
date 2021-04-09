/*
 * @Descripttion : 深度遍历文件目录及删除目录
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-08 09:52:10
 * @FilePath     : \edu\github\io\DepthTraversal.java
 */
package edu.github.io;

import java.io.File;

public class DepthTraversal {
    public static void main(String[] args) {
        File file=new File("e:\\12");
        // traversal(file,0);
        remove(file);
    }
    private static void remove(File file) {
        //先遍历到最里面在从内到外删除
        File[] list=file.listFiles();
        for(File f:list){
            if(f.isDirectory()){
                remove(f);
            }
            else{
                System.out.println("文件删除"+f.delete());
            }
        }
        System.out.println("目录删除"+file.delete());
    }
    /**
     * @Descripttion: 遍历过程
     * @param        {File} file
     * @param        {int} len
     * @return       {*}
     */
    public static void traversal(File file,int len) {
        File[] list=file.listFiles();
        len++;
        for(int i=0;i<list.length;i++){
            if(list[i].isDirectory()){
                System.out.println(blank(len)+list[i].getName());
                traversal(list[i],len);
            }
            else{
                System.out.println(blank(len)+list[i].getName());
            }
        }
    }
    /**
     * @Descripttion: tree结构
     * @param        {int} len
     * @return       {*}
     */
    private static String blank(int len) {
        StringBuilder sb=new StringBuilder();
        sb.append("|--");
        for(int i=0;i<len;i++){
            sb.insert(0, "|  ");
        }
        return sb.toString();
    }
    
}
