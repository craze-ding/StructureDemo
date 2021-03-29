package edu.github.string.test;


import java.util.LinkedList;
import java.util.Scanner;

public class Stack { 

    public static void main(String[] args) {
        LinkedList<String> li=new LinkedList<>();
        Scanner s = new Scanner(System.in);       
        String str=push(li);
        System.out.println(str);
        s.close();
    }

    private static String pop(LinkedList<String> li) {        
        return li.pollFirst();
    }

    private static String push(LinkedList<String> li) {
              
            li.addFirst("ding");
            li.addFirst("zhi");
            li.addFirst("jun");
            li.addFirst("craze");
            System.out.println(li);
                     
            return pop(li);
    }
    
}
