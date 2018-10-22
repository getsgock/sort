package com.nthforever;

/**
 * @author Nthforever
 * @date 2018/10/22
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{3,5,8,1,22,54,4,9,34,43,11,44};

        int[] ints = bottomsort(a);
        for (int i=0;i<ints.length;i++){
            System.out.print(ints[i]);
            System.out.print(",");
        }
    }

    /**
     * 上浮  自底向上冒泡  每次都从尾部开始，至头部
     * @param array
     * @return
     */
    private static int[] bubbleSort(int[] array){
        for (int i= 0 ;i < array.length -1;i++){
            for (int j = array.length -1;j > i ;j--){
                if (array[j] < array[j-1])  {
                    array[j] = array[j] ^ array[j-1];
                    array[j-1] = array[j-1] ^ array[j];
                    array[j] = array[j] ^ array[j-1];
                }
            }
        }
        return array;
    }

    /**
     * 下沉   自顶向下沉 每次都从下标0开始，至尾部
     * @param array
     * @return
     */
    private static int[] bottomsort(int[] array){
        for (int i=0;i<array.length - 1;i++){
            for (int j =0;j<array.length - i - 1;j++){
                if (array[j] > array[j+1])  {
                    array[j] = array[j] ^ array[j+1];
                    array[j+1] = array[j+1] ^ array[j];
                    array[j] = array[j] ^ array[j+1];
                }
            }
        }
        return array;
    }
}
