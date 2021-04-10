/*
 * @Descripttion : 
 * @version      : v1版本
 * @Author       : 丁志军
 * @Date         : 2021-04-02 18:47:00
 * @FilePath     : \edu\github\bin\Persion.java
 */
package edu.github.bin;

import java.io.Serializable;

public class Persion implements Comparable<Object>,Serializable {
    /**
     *transient(短暂的)不想写入磁盘中但又不是共有数据
     */
    private static final long serialVersionUID = 1L;
    private /* transient */ String  name;
    private /* static */ int age;
    //将被静态修饰的成员变量反序列化将不能被保持！！！只有内存中才被写入磁盘
    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Persion() {
        super();
    }

    public int hashCode() {
        // System.out.println(this.toString() + "--hashcode--");
        return name.hashCode() + age * 39;//尽可能保证hashcode值唯一,就不用equals()减少运算量
        // return 100;
    }

    public boolean equals(Object obj) {//当hshcode相同了,就必须要equals判断内容是否相同,相同后面的不存,不同就挂载;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Persion)) {//健壮性判断要传persion类型,不是就报异常,中断程序
            throw new ClassCastException("类型错误");
        }
        //System.out.println(this.toString()+"--equals--"+obj.toString());
        Persion p = (Persion) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

   public String toString() { // System用到了toString();所以也要覆盖 
        return name + ":" + age;
    }

    @Override
    public int compareTo(Object o) {//改变引用对象实现逆序
        Persion p=(Persion)o;
            /*  if(this.age<p.age){ */
            /*     return 1;  */
            /*  }  */
            /*  if(this.age>p.age){  */
            /*      return -1; */
            /*  }  */
            /*  return 0;      */
        int temp=this.age-p.age; 
        return temp==0?this.name.compareTo(p.name):temp; 
        // int temp=this.name.compareTo(p.name);
        // return temp==0?this.age-p.getAge():temp;
    }

}
