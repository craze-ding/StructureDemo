/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-02 18:47:00
 * @FilePath     : \edu\github\bin\Student.java
 */
package edu.github.bin;

public class Student extends Persion{ 
    public int score;
    private int grade;
    
    
    private static final long serialVersionUID = 1L;
    public Student(){
        super();
    }  
    public Student(String name,int age){
        super(name,age); //让父类去初始化      
    }
    public String toString(){//实现功能,写自己的内容
        System.out.println("哈哈");
        return "student"+"----"+super.getName()+":"+super.getAge();
    }   
}
