package edu.github.string.demo;

public class Counter{    
    private StringBuffer count =new StringBuffer(0);
    public void add(int n) {
        synchronized(count) {
            count.append(n);
        }
        System.out.println(Thread.currentThread().getName()+"--生产者--"+count.toString()); 
    }
    public void dec( ) {
        synchronized(count) {
            count.delete(0, 1);
        }
        System.out.println(Thread.currentThread().getName()+"--消费者--"+count.toString());
    }
    public String get() {
        return count.toString();
    }
}