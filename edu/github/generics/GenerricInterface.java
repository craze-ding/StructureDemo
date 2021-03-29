package edu.github.generics;

public class GenerricInterface {
    public static void main(String[] args) {
        InterImp1 in=new InterImp1();
        in.show("hsha");
        InterImp2<Integer> i=new InterImp2<>();
        i.show(3);

    }
}
//* 泛型接口,将泛型定义在接口上 */
interface Inter<w>{
    public void show(w t);
}
class InterImp1 implements Inter<String>{
    public void show(String t){
        System.out.println(t);
    }
}
class InterImp2 <w> implements Inter<w>{
    public void show(w t){
        System.out.println(t);
    }
}
