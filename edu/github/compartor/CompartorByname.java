package edu.github.compartor;

import java.util.Comparator;

import edu.github.bin.Persion;

public class CompartorByname implements Comparator<Persion >{ //persion对象可以用,其子类student也可以

    /** 
     * 构造比较器
     * 小的先迭代!!也就是先取出来
     */
    @Override
    public int compare(Persion o1, Persion o2) {
        
        Persion p1=(Persion)o1;
        Persion p2=(Persion)o2;
        int temp=p1.getName().compareTo(p2.getName());
        return temp==0?p1.getAge()-p2.getAge():temp;
    //    return -1;//二叉树只管你返回的正负,不要固化实际数值大小!!
    }
    
}
