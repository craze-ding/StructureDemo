package edu.github.bin;

public class Student extends Persion{ 
    public Student(){
        super();
    }  
    public Student(String name,int age){
        super(name,age); //让父类去初始化      
    }
    public String toString(){//实现功能,写自己的内容
        return "student"+"----"+super.getName()+":"+super.getAge();
    }   
}
