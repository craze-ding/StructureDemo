package edu.github.string.test;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack { 

    public static void main(String[] args) {
        LinkedList li=new LinkedList<>();
        //Scanner s = new Scanner(System.in);
        push(li);
        String str=pop(li);
      
    }

    private static String pop(LinkedList li) {
        return null;
    }

    private static void push(LinkedList li) {
              
            li.addFirst("ding");
            li.addFirst("zhi");
            li.addFirst("jun");
            li.addFirst("craze");
           System.out.println(li);
                     
      
    }
    
}
