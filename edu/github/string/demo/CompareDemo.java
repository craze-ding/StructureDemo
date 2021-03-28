package edu.github.string.demo;

public class CompareDemo {
    public static void main(String[] args) {
        compare(); 
    }
    public static void compare(){
        System.out.println("abc".compareTo("ABC"));
        //对象比较用自身方法,基本类型就是操作符
        String str=new String("abc");
        String s=str.intern();//
        System.out.println(str==s);

    }
    
}
