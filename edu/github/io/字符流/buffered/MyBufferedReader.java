/*
 * @Descripttion: 自定义实现filrread.readline()方法.-----实际是设计模式中的装饰器模式(以下是真正的装饰器,以完善)
 * @version: X3版本
 * @Author: 丁志军
 * @Date: 2021-04-05 21:31:36
 */
package buffered;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class MyBufferedReader extends Reader {
    private /* File */Reader r;
    private char[] arr=new char[1024];
    private int count=0;
    private int pos;
    
    public int Myread( ) throws IOException{
        if(count==0){
            count=r.read(arr);
            pos=0;
        }
        if(count==-1)
        return -1;
        char ch=arr[pos++];
        count--;
        return ch;
    }
    public String MyreadLine( ) throws IOException{
        StringBuilder sb=new StringBuilder();
        int ch=0;
        while((ch=Myread( ))!=-1){
            //回车,不换行,还是属于同一行!
            if((char)ch=='\r')  
                continue;
            //换行的标志
            if((char)ch=='\n')
                return sb.toString();
            sb.append((char)ch);
        }
        //健壮性判断,如果最后没有'\n',但是有数据,就是用户回退了.
        if((sb.toString()).length()>0)
            return sb.toString();
        return null;        
    }
    public MyBufferedReader(/* File */Reader r) {
        this.r = r;
    }    

    
    public void Myclose() throws IOException {
        r.close();
    }
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub
        
    }
    
}






