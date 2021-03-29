package edu.github.generics;



import edu.github.bean.ToolGeneric;


public class GenericDefineDemo {
    public static void main(String[] args) {//自定义泛型类
    ToolGeneric<String> t=new ToolGeneric<>();
    // t.setC("craze");
    // Student stu=/* (Student) */t.getC();
    t.show(new Integer(4));
    ToolGeneric.method("haha");
    }
}
