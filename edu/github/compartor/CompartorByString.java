package edu.github.compartor;

import java.util.Comparator;

public class CompartorByString implements Comparator<String >{

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        String s1=(String)o1;
        String s2=(String)o2;
        int temp=s1.length()-s2.length();
        return temp==0?s1.compareTo(s2):temp;        
    }
    
}
