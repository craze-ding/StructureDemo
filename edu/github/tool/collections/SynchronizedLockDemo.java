package edu.github.tool.collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @program: StructureDemo - 副本
 * @description: 给非同步的集合加锁
 * @author: Craze
 * @create: 2021-03-31 15:47
 **/
public class SynchronizedLockDemo {
    public static void main (String[] args) {
        //非同步的集合
        List list=new ArrayList ();
        //返回同步的集合
        List li=MyCollection.synList (list);
    }
}
class MyCollection{
    public static List synList(List list){
        return new MyList(list);
    }
    private static class MyList implements  List{
        private  List list;
        private  static final  Object lock=new Object ();
        MyList(List list){
            this.list=list;
        }

        @Override
        public int size () {
            return 0;
        }

        @Override
        public boolean isEmpty () {
            return false;
        }

        @Override
        public boolean contains (Object o) {
            return false;
        }

        @Override
        public Iterator iterator () {
            return null;
        }

        @Override
        public Object[] toArray () {
            return new Object[0];
        }

        @Override
        public Object[] toArray (Object[] a) {
            return new Object[0];
        }

        @Override
        public boolean add (Object o) {
            synchronized (lock){//加同步锁
                return list.add (o);
            }
        }

        @Override
        public boolean  remove (Object o) {
            synchronized (lock){//加同步锁
                return list.remove (o);
            }
        }

        @Override
        public boolean addAll (Collection c) {
            return false;
        }

        @Override
        public boolean addAll (int index, Collection c) {
            return false;
        }

        @Override
        public void clear () {

        }

        @Override
        public Object get (int index) {
            return null;
        }

        @Override
        public Object set (int index, Object element) {
            return null;
        }

        @Override
        public void add (int index, Object element) {

        }

        @Override
        public Object remove (int index) {
            return null;
        }

        @Override
        public int indexOf (Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf (Object o) {
            return 0;
        }

        @Override
        public ListIterator listIterator () {
            return null;
        }

        @Override
        public ListIterator listIterator (int index) {
            return null;
        }

        @Override
        public List subList (int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public boolean retainAll (Collection c) {
            return false;
        }

        @Override
        public boolean removeAll (Collection c) {
            return false;
        }

        @Override
        public boolean containsAll (Collection c) {
            return false;
        }

    }
}
