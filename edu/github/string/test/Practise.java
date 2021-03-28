package edu.github.string.test;
/** 
 * @author 丁志军
 * @version vs 1.0
 */
public class Practise {
    public static void main(String[] args) {
        // String[] arr = { "nba", "abc", "cba", "zz", "cq", "haha" };
        /*
         * sequence(arr); Print(arr);
         */
        // String arr="nbaerbatnbauinbaopnba";
        // System.out.println(sreash(arr,"nba"));
        /* String fu = "atryubfnsinsmduqwoipnfkwae";
        String zi = "yewfnsihjjsab";
        System.out.println(compare(fu, zi)); */
        System.out.println(myTrim("    ab   c  "));
    }
    /**
     * 冒泡法给字符串数组排序
     * @param arr 字符串数组
     */
    public static void sequence(String[] arr) {
        for (int n = 0; n < arr.length - 1; n++) {
            for (int i = 0; i < arr.length - 1 - n; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {// 字符串比较用方法
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 交换字符串数组中的两个字符串
     * 
     * @param arr 字符串数组
     * @param x   下标
     * @param y   下标
     */
    public static void swap(String[] arr, int x, int y) {
        String temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /**
     * 打印字符串
     * 
     * @param arr 字符串
     */
    public static void Print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]" + "=" + arr[i]);
        }
    }

    /**
     * 获取子串在整串中出现的次数
     * 
     * @param arr 整串
     * @param str 字串
     * @return 次数
     */
    public static int sreash(String arr, String str) {// 找目标子串
        int x = 0, count = 0;
        for (; x < arr.length();) {
            if (arr.indexOf(str, x) >= 0) {// 调用String对象indexOf()
                x = arr.indexOf(str, x);
                x = x + str.length();// 找到一个,往后字串长度再找,以此类推
                count += 1;
            }
        }
        return count;
    }
    /**
     * 获取两个字符串最大相同子串
     * @param fu 随便字符串
     * @param zi 随便字符串
     * @return 最大相同字符串
     */
    public static String compare(String fu, String zi) {
        String max = null, min = null;
        max = (fu.length() > zi.length()) ? fu : zi;
        min = max.equals(fu) ? zi : fu;
        /* System.out.println(max);
        System.out.println(min); */
        for (int i = 0; i < max.length(); i++) {
            for (int x = 0, y = min.length() - i; y < min.length() + 1; x++, y++) {
                String str = min.substring(x, y);
                if (max.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }
    /**
     * 模拟trim方法
     * @param str 头尾部带空格的字符串
     * @return 掐去空格的部分
     */
    public static String myTrim(String str){
        int start =0,end=str.length()-1;
        while(start<end && str.charAt(start)==' '){
            start++;
        }
        while(start<end && str.charAt(end)==' '){
            end--;
        }
        return str.substring(start, end+1);
    }
}
