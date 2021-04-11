/*
 * @Descripttion : 按字节截取字符串（需要根据码表）
 *              比如说中文：utf 3byte 都为负
 *                          gbk 2byte 都为负
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 16:25:07
 * @FilePath     : \edu\github\io\elseIo\encoding\CutStringByByteTest.java
 */
package edu.github.io.elseIo.encoding;

import java.io.UnsupportedEncodingException;

public class CutStringByByteTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="ab你好dfg定制你";
        int len=str.getBytes("utf-8").length;
        for(int x=0;x<len;x++){
            System.out.println("借取"+(x+1)+"字节"+"结果是  "+cutString(str, x+1));
        }
    }
    public  static String cutString(String str,int len) throws UnsupportedEncodingException{
        //utf编码
        byte[] buf=str.getBytes("utf-8");
        int counts=0;
        for(int x=len-1;x>=0;x--){
            if(buf[x]<0){
                counts++;
            }
            else{
                break;
            }
        }
        if(counts%3==0){
            return new String(buf, 0,len,"utf-8");
        }
        else if(counts%3==2){
            return new String(buf, 0, len-2, "utf-8");
        }
        else{
            return new String(buf, 0, len-1, "utf-8");
        }
        
    } 
}
/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 16:25:07
 * @FilePath     : \edu\github\io\elseIo\encoding\CutStringByByteTest.java
 */
