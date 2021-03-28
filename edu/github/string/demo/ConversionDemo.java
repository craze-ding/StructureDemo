package edu.github.string.demo;

public class ConversionDemo {
    public static void main(String[] args) {
        conversion();
    }
    public static void conversion(){
        String str="王五,李四,丁一";
        String[] s=str.split(",");
        for(int i=0;i<s.length;i++){           
            System.out.println(s[i]);
        }    
    }
}
