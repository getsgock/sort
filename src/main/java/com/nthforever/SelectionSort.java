package com.nthforever;

/**
 * @author Nthforever
 * @date 2018/10/23
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = new int[]{3,5,8,1,22,54,4,9,34,43,11,44};

        int[] ints = selectionSort(a);
        for (int i=0;i<ints.length;i++){
            System.out.print(ints[i]);
            System.out.print(",");
        }
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    private static int[] selectionSort(int[] array){
        for (int i= 0;i < array.length - 1;i++){
            for (int j= i+1;j<array.length;j++){
                if (array[i] > array[j]){
                    array[i] = array[i] ^ array[j];
                    array[j] = array[j] ^ array[i];
                    array[i] = array[i] ^ array[j];
                }
            }
        }
        return array;
    }

}
