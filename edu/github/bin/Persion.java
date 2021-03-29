package edu.github.bin;

public class Persion implements Comparable<Object> {
    private String name;
    private int age;

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
