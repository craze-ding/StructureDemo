/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-07 20:31:07
 * @FilePath     : \edu\github\suffixfilter\FileByJava.java
 */
package edu.github.suffixfilter;

import java.io.File;
import java.io.FilenameFilter;

public class FileByJava implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {
        // TODO Auto-generated method stub
        return name.endsWith(".java");
    }
    
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-07 20:31:07
 * @FilePath     : \edu\github\io\file\FileByJava.java
 */
