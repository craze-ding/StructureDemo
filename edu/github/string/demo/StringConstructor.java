package edu.github.string.demo;

public class StringConstructor{
    public static void main(String[] args) {
      StringConstructor1();
      StringConstructor2();
    }
    public static void  StringConstructor1(){
      char[] arr={'a','2','b','d','1'};
      String str=new String(arr,1,3);
      System.out.println("str="+str);
      System.out.println(str.length());
      System.out.println(str.indexOf(98, 0));
      System.out.println(str.indexOf(98));      
    }
    public static void  StringConstructor2(){
      byte[] arr={65,97,66,98,67,99};
      String str=new String(arr);
      System.out.println(str);
      System.out.println(str.subSequence(2, 4));
    }
}