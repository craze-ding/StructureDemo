/*
 * @Descripttion : 简单的编解码
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-11 15:17:32
 * @FilePath     : \edu\github\io\elseIo\encoding\EncodDemo.java
 */
package edu.github.io.elseIo.encoding;

import java.io.UnsupportedEncodingException;

public class EncodDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        GbkToUtfToBbk();
        // mabiao();
    }

    private static void mabiao() throws UnsupportedEncodingException {
        
     // byte[] buf = "丁志军".getBytes();
    // 编码——>
    byte[] buf = "丁漪".getBytes("utf-8");
    /**
     * 是因为我的默认码表 UTF-8 丁志军 UTF-8 编码为：-28 -72 -127 -27 -65 -105 -27 -122 -101 GBK:-74
     * -95 -42 -66 -66 -4
     */
    // for (byte b : buf) {
    // System.out.println(b);
    // }
    // gbk解
    String str1 = new String(buf, "gbk");
    // 发现不得行，乱码。所以我再用gbk编一下就拿到原来码表
    byte[] buf1 = str1.getBytes("gbk");
    // 解码——>
    String str = new String(buf1, "utf-8");
    System.out.println(str);
    // 用什么码表编九要用什么码表解！！！(utf-8)——(utf-8)
    // 但是现实中服务器只内置一张码表，所以一般都要在在本地用应用的码表解析出来：比如TomCat
    }

    private static void GbkToUtfToBbk() throws UnsupportedEncodingException {
        byte[] buf = "丁漪".getBytes("gbk");
        // utf-8解。在这里解码出现错误，码值已经改变，怎么都回不去
        String str1 = new String(buf, "utf-8");        
        // utf-8编 因为解是错的，再编也就不可能原来的码值
        byte[] buf1 = str1.getBytes("utf-8");
        String str = new String(buf1, "gbk");
        System.out.println(str);
    }

}
