package edu.github.string.demo;
import java.util.Arrays;

public class IntegeDateDemo {
    private static final String SPACE_STRING=" ";
    public static void main( String[] args) {
        String str="12   33 76   09 -1 0   23 88   34  ";
        String[] str_arrys=stringToArrys(str);
        int[] int_arrys=stringToArrys(str_arrys);
        int_arrys=sortArrys(int_arrys);
        String arrys_string=arrysTostring(int_arrys);
        System.out.println(arrys_string);
    }
    /**
     * 将int数组转换成string
     * @param int_arrys
     * @return
     */
    private static String arrysTostring(int[] int_arrys) {
        StringBuilder arrys_string=new StringBuilder();
        for(int i=0;i<int_arrys.length;i++){
            if(i!=int_arrys.length){
                arrys_string.append(int_arrys[i]).append(SPACE_STRING);
            }
            else{
                arrys_string.append(int_arrys[i]);
            }
        }
        return arrys_string.toString();
    }

    /**
     * 将int数组排序
     * @param int_arrys
     * @return
     */
    private static int[] sortArrys(int[] int_arrys) {
         Arrays.sort(int_arrys);
        return int_arrys;
    }
    /**
     * 将字符串数组转换整型数组
     * @param str_arrys
     * @return
     */
    private static int[] stringToArrys(String[] str_arrys) {
        int[] int_arrys=new int[str_arrys.length];
        for(int i=0;i<str_arrys.length;i++){
            int_arrys[i]= Integer.parseInt(str_arrys[i]);
        }
        return int_arrys;
    }
    /**
     * 将字符串转换成字符串数组
     * @param str
     * @return
     */
    private static String[] stringToArrys(String str) {
        String[] str_arrys=str.split(SPACE_STRING+"+");//可以识别多个空格
        return str_arrys;
    }   
    
}
