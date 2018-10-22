package com.nthforever;

import java.util.Random;

/**
 * @author Nthforever
 * @date 2018/10/22
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{3,5,8,1,22,54,4,9,34,43,11,44};

        int[] ints = quickSort(a);
        for (int i=0;i<ints.length;i++){
            System.out.print(ints[i]);
            System.out.print(",");
        }
    }

    /**
     * 快速排序
     * 递归-随机数选取
     * @param array
     * @return
     */
    private static int[] quickSort(int[] array){
        int length = array.length;
        if (length <2){
            return array;
        }
        int index = generateL(array);
        int indexValue = array[index];
        int array1Length=0;
        int array2Length=0;
        for (int target:array){
            if (target < indexValue){
                array1Length++;
            }else {
                array2Length++;
            }
        }
        int[] array1 = new int[array1Length];
        int[] array2 = new int[array2Length];
        int array1Index = 0;
        int array2Index = 0;
        for (int now:array){
            if (now < indexValue){
                array1[array1Index] = now;
                array1Index++;
            }else {
                array2[array2Index] = now;
                array2Index++;
            }
        }
        int[] ints = quickSort(array1);
        int[] ints1 = quickSort(array2);
        return getTogether(ints,ints1);
    }

    private static int generateL(int[] array){
        int length = array.length;
        Random random = new Random();
        int i = random.nextInt(length);
        return i;
    }

    private static int[] getTogether(int[] array1,int[] array2){
        int index = 0;
        int maxLength = array1.length+array2.length;
        int[] res = new int[maxLength];
        for (int i =0;i<array1.length;i++){
            res[index] = array1[i];
            index++;
        }
        for (int i =0;i<array2.length;i++){
            res[index] = array2[i];
            index++;
        }
        return res;
    }

}
