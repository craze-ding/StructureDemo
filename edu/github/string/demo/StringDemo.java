package edu.github.string.demo;
public class StringDemo {
    public static void main(String[] args) {
        /* StringDemo1();
        StringDemo2();  */
        int[] arr={1,2,3,4,5};
        System.out.println(ArrysToString(arr));
    }
    public static void  StringDemo1(){
        String str="dingzhijun";//常量池里创建一个对象
         str="craze";
        String s="craze";
        System.out.println(str==s);//字符串常量池,有就现成,没就创建;比较对象的哈希值
    }
    public static void  StringDemo2(){
        String str="dingzhijun";//常量池里创建一个对象
        String s=new String("dingzhijun");//堆内存里创建两个对象
        System.out.println(str==s);//字符串常量池,有就现成,没就创建;比较对象的哈希值      
        System.out.println(str.equals(s));//复写object类equals()用string特有(比较内容)
    }
    public static  String ArrysToString(int[] arr){
        StringBuilder str=new StringBuilder();
        str.append("[");
        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1){
                str.append(arr[i]).append(',');
            }
            else{
                str.append(arr[i]);
            }           
        }
        str.append(']');
        return str.toString();
    }
}
