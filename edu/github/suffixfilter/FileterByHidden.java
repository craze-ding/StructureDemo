/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-07 21:01:38
 * @FilePath     : \edu\github\suffixfilter\FileterByHidden.java
 */
package edu.github.suffixfilter;

import java.io.File;
import java.io.FileFilter;
/**
 * @Descripttion: 过滤目录文件对象
 * @param        {*}
 * @return       {*}
 */
public class FileterByHidden implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        // TODO Auto-generated method stub
        //不是隐藏的文件对象返回真
        return !pathname.isHidden();
    }
    
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-07 21:01:38
 * @FilePath     : \edu\github\suffixfilter\FileterByHidden.java
 */
