/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-07 20:48:11
 * @FilePath     : \edu\github\suffixfilter\SuffixFilter.java
 */
package edu.github.suffixfilter;

import java.io.File;
import java.io.FilenameFilter;
/**
 * @Descripttion: 过滤传来string后缀文件名
 * @param        {*}
 * @return       {*}
 */
public class SuffixFilter  implements FilenameFilter{
    private String suffix;
    
    @Override
    public boolean accept(File dir, String name) {
        // TODO Auto-generated method stub
        return name.endsWith(suffix);
    }

    public SuffixFilter(String suffix) {
        this.suffix = suffix;
    }
    
}
