package com.nthforever;

/**
 * @author Nthforever
 * @date 2018/10/22
 */
public class Equal {

    public static void main(String[] args) {
        System.out.println(showEqual("aaaaaaaaaaa","aaabaaaaaaa"));
    }

    /**
     * 具有恒定比较时间的字符串比较函数
     * @param a
     * @param b
     * @return
     */
    private static boolean showEqual(String a,String b){
        long start = System.nanoTime();
        byte[] aa = a.getBytes();
        byte[] bb = b.getBytes();
        int diff = aa.length ^ bb.length;
        for (int i =0;i<aa.length && i< bb.length;i++) {
            diff |= aa[i] ^ bb[i];
        }
        long end = System.nanoTime();
        System.out.println("cost time : "+(end-start)+" nanoSeconds");
        return diff == 0;
    }
}
